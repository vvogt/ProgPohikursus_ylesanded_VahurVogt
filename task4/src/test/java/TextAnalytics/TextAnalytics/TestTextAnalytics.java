package TextAnalytics.TextAnalytics;

/* import static org.junit.Assert.assertEquals; */
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.lang.Character;

public class TestTextAnalytics {

    @Test
    public void testIfFileWasRead() {
        TextAnalyticsFunctions text = new TextAnalyticsFunctions();
        String fileContent = text.readFile("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task4/src/main/java/TextAnalytics/TextAnalytics/text.txt");
        assertNotNull(fileContent);
    }

    @Test
    public void testIfWordArrayIsCreated() {
        TextAnalyticsFunctions text = new TextAnalyticsFunctions();
        String fileContent = text.readFile("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task4/src/main/java/TextAnalytics/TextAnalytics/text.txt");
        String[] wordArray = text.splitWords(fileContent);
        assertTrue(wordArray.length > 0);
    }

    @Test
    public void testIfWordArrayIsLongerThan1() {
        TextAnalyticsFunctions text = new TextAnalyticsFunctions();
        String fileContent = text.readFile("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task4/src/main/java/TextAnalytics/TextAnalytics/text.txt");
        String[] wordArray = text.splitWords(fileContent);
        assertTrue(wordArray.length > 1);
    }


    @Test
    public void testIfLowerCaseLettersAreLowerCase() {
        TextAnalyticsFunctions text = new TextAnalyticsFunctions();
        String fileContent = text.readFile("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task4/src/main/java/TextAnalytics/TextAnalytics/text.txt");
        String[] wordArray = text.splitWords(fileContent);
        String[] wordArrayLowerCase = text.lowerCaseLetters(wordArray);
        boolean isUpperCase = false;

        for (int i = 0; i < wordArrayLowerCase.length; i++) {
            String word = wordArrayLowerCase[i];
            int lengthOfWord = word.length();
            for (int j = 0; j < lengthOfWord-1; j++) {
                char letter = word.charAt(j);
                if (Character.isUpperCase(letter)) {
                    isUpperCase = true;
                    System.out.println(letter + '\n');
                }
            }
        }

        assertTrue(isUpperCase == false);

    }

    @Test
    public void testIfLetterCounterCounts(){
        TextAnalyticsFunctions text = new TextAnalyticsFunctions();
        String[] testArray = {"iiii", "iiii", "iiii"};
        int testNumOfWords = text.countLetterMoreThan(testArray, 'i', 3);
        
        assertTrue(testNumOfWords == 3);

    }

    @Test
    public void testIfLetterCounterCounts2(){
        TextAnalyticsFunctions text = new TextAnalyticsFunctions();
        String[] testArray = {"eeee", "eeee", "eeee", "oooooo"};
        int testNumOfWords = text.countLetterMoreThan(testArray, 'e', 3);
        
        assertTrue(testNumOfWords == 3);

    }

}