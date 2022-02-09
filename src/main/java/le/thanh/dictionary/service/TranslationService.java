package le.thanh.dictionary.service;

import le.thanh.dictionary.dto.TranslateResult;

public interface TranslationService {

    TranslateResult translate(String word, String sourceLang, String targetLang);

}
