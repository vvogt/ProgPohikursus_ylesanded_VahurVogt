package TextAnalytics.TextAnalytics;

interface TextAnalyticsInterface {
    public String readFile(String path);
    public String[] splitWords(String text);
    public String[] lowerCaseLetters(String[] wordArray);
    public int countLetterMoreThan(String[] wordArray, char letter, int letterCount);
}