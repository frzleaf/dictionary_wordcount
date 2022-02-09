package le.thanh.wordcounter.dto;

public class WordCounterResult {

    private final int chars;
    private final int sentences;
    private final int words;

    public WordCounterResult(int chars, int lines, int words) {
        this.chars = chars;
        this.sentences = lines;
        this.words = words;
    }

    public int getChars() {
        return chars;
    }

    public int getSentences() {
        return sentences;
    }

    public int getWords() {
        return words;
    }
}
