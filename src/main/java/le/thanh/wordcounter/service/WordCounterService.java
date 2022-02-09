package le.thanh.wordcounter.service;

import le.thanh.wordcounter.dto.WordCounterResult;

public interface WordCounterService {

    WordCounterResult count(String input);

}
