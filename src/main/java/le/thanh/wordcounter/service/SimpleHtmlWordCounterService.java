package le.thanh.wordcounter.service;

import le.thanh.wordcounter.dto.WordCounterResult;

import java.util.StringTokenizer;

public class SimpleHtmlWordCounterService implements WordCounterService {

    @Override
    public WordCounterResult count(String input) {
        // Remove html tag
        String tmp = input.replaceAll("<(.|\r|\f)*?>", " ");
        // Replace new line by .
        tmp = tmp.replaceAll("\n+", ".");
        // Remove duplicate .
        tmp = tmp.replaceAll("(\\s+|\\.+)\\.", ".");

        int sentences = 0;
        int words = 0;
        StringTokenizer strTokenizer = new StringTokenizer(tmp);
        while (strTokenizer.hasMoreTokens()) {
            String token = strTokenizer.nextToken();
            if (token.endsWith(".")) {
                sentences++;
            }
            words++;
        }

        return new WordCounterResult(
            input.length(),
            sentences,
            words
        );
    }

}
