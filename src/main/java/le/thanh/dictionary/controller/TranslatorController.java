package le.thanh.dictionary.controller;

import le.thanh.dictionary.dto.TranslateResult;
import le.thanh.dictionary.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TranslatorController {

    @Autowired
    private TranslationService translationService;

    @GetMapping("/translate/{word}/{sourceLang}/{targetLang}")
    public TranslateResult translate(
            @PathVariable String word,
            @PathVariable String sourceLang,
            @PathVariable String targetLang
    ){
        return translationService.translate(word, sourceLang, targetLang);
    }

}
