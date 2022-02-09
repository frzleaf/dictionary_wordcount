package le.thanh.wordcounter;

import le.thanh.wordcounter.dto.WordCounterResult;
import le.thanh.wordcounter.service.SimpleHttpWordCounterService;
import le.thanh.wordcounter.service.WordCounterService;

public class WordCounter {

    public static WordCounterService wordCounterService = new SimpleHttpWordCounterService();

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please input the text as argument");
            return;
        }
        String strToCount = args[1];
        WordCounterResult countResult = wordCounterService.count(strToCount);
        System.out.printf(
            "\nInput has: \nLines: %s\nWords: %s\nChars: %s",
            countResult.getSentences(),
            countResult.getWords(),
            countResult.getChars()
        );
    }

}
