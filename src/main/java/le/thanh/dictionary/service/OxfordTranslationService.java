package le.thanh.dictionary.service;

import le.thanh.dictionary.dto.TranslateResult;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class OxfordTranslationService implements TranslationService{

    private final RestTemplate client;
    private final HttpHeaders defaultHttpHeaders;
    private final String apiRootPath;

    public static final String TRANSLATION_PATH = "/translations/{src}/{tag}/{word}";


    public OxfordTranslationService(String apiRootPath, String appId, String appKey) {
        this.apiRootPath = apiRootPath;
        client = new RestTemplate();
        defaultHttpHeaders = new HttpHeaders();
        defaultHttpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        defaultHttpHeaders.set("app_id", appId);
        defaultHttpHeaders.set("app_key", appKey);
    }

    @Override
    public TranslateResult translate(String word, String sourceLang, String targetLang) {
        URI uri = new UriTemplate(apiRootPath + TRANSLATION_PATH).expand(sourceLang, targetLang, word);
        ResponseEntity<TranslateResponse> response = client.exchange(
                RequestEntity.get(uri).headers(defaultHttpHeaders).build(),
                TranslateResponse.class
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            List<TranslateResult.Translation> translations = new ArrayList<>();
            Objects.requireNonNull(response.getBody()).results.forEach(x -> {
                x.lexicalEntries.forEach(l -> {
                    l.entries.forEach(e -> {
                        e.senses.forEach(s -> {
                            s.translations.forEach(t -> {
                                translations.add(new TranslateResult.Translation(t.language, t.text));
                            });
                        });
                    });
                });
            });
            return new TranslateResult(translations);
        }
        throw new RuntimeException("Error on request Oxford API " + response.getStatusCode());
    }


    protected final class TranslateResponse {
        private String id;
        private String word;
        private Object metadata;
        private List<Result> results;

        protected final class Result {
            private String id;
            private String language;
            private List<LexicalEntry> lexicalEntries;
        }

        protected final class LexicalEntry {
            private List<Entry> entries;
            private String language;
            private String text;
        }

        protected final class Entry {
            private List<Object> pronunciations;
            private List<Sense> senses;
        }

        protected final class Sense {
            List<Translation> translations;
        }

        protected final class Translation {
            private String language;
            private String text;
        }
    }

}
