package le.thanh.dictionary.dto;

import java.io.Serializable;
import java.util.List;

public class TranslateResult implements Serializable {

    private static final long serialVersionUID = 4826084336887350973L;

    private List<Translation> translations;

    public TranslateResult(List<Translation> translations) {
        this.translations = translations;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public static class Translation {

        private String language;
        private String text;

        public Translation(String language, String text) {
            this.language = language;
            this.text = text;
        }

        public String getLanguage() {
            return language;
        }

        public String getText() {
            return text;
        }
    }

}
