package le.thanh.dictionary;

import le.thanh.dictionary.service.OxfordTranslationService;
import le.thanh.dictionary.service.TranslationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DictionaryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryDemoApplication.class, args);
	}

	@Bean
	public TranslationService oxfordTranslator(
		@Value("${oxford.api.rootPath}") String apiRootPath,
		@Value("${oxford.api.appId}") String appId,
		@Value("${oxford.api.appKey}") String appKey
	){
		return new OxfordTranslationService(
			apiRootPath, appId, appKey
		);
	}
}
