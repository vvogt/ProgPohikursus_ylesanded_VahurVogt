package Interface;

public class App {
    public static void main(String[] args) {
        Word word = new Word();
        Word2 word2 = new Word2();

        String text = word.readFile("/Users/vahurvogt/Documents/TLU/progPohikursus/tund8vb/Interface/src/main/java/Interface/test.txt");
        String[] wordArray = word.splitWords(text);

        wordArray = word2.lowerCaseLetters(wordArray);
        int wordCount = word2.countLongerThan(wordArray, 5);

        System.out.println(wordCount);
    
    }
}
