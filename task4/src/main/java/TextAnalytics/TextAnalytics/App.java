package TextAnalytics.TextAnalytics;

import java.util.HashMap;
import java.util.function.Function;

/* import com.fasterxml.jackson.databind.jsonschema.JsonSchema; */

import org.springframework.web.bind.annotation.GetMapping;
/* import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; */
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AnalyticsController {

    @GetMapping("/greeting")
    public String myGreetings(@RequestParam(value = "text", defaultValue = "World!", required = false) String name) {
        String template = "word count is %d";
        
        TextAnalyticsFunctions word = new TextAnalyticsFunctions();
        
            String[] wordArray = word.splitWords(name);
            
            wordArray = word.lowerCaseLetters(wordArray);
            int wordCount = word.countLetterMoreThan(wordArray, 'i', 2);
            
            System.out.println(wordCount);

            return String.format(template, wordCount);
    }

}


public class App {
    public static void main(String[] args) {
        TextAnalyticsFunctions word = new TextAnalyticsFunctions();

        String text = word.readFile("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task4/src/main/java/TextAnalytics/TextAnalytics/text.txt");
        String[] wordArray = word.splitWords(text);

        wordArray = word.lowerCaseLetters(wordArray);
        int wordCount = word.countLetterMoreThan(wordArray, 'i', 2);

        System.out.println(wordCount);

    }
}