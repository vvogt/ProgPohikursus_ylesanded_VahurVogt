import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Functions {
    String file_path;
    String file_content;
    String[] wordArray;
    HashMap<String, Integer> wordCountMap = new HashMap<>();

    public Functions(String path) {
        this.file_path = path;

        this.readFile();
        this.splitWords();
        this.wordsToLowercase();
        this.countWords();
    }
    
    public void readFile() {
        Path file_path = Paths.get(this.file_path);
        try {
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);
            String file_content_str = new String(file_content_in_bytes, StandardCharsets.UTF_8);
            this.file_content = file_content_str;
        } catch (IOException my_error) {
            my_error.printStackTrace();
        }
    }
    
    public void wordsToLowercase() {
        for (int i = 0; i < this.wordArray.length; i++) {
            String currentWord = wordArray[i];
            wordArray[i] = currentWord.toLowerCase();
        }
    }
    
    public void splitWords() {
        String[] wordArray = this.file_content.split("\\s");
        this.wordArray = wordArray;
    }

    public void countWords() {
        for (String word : this.wordArray) {
            System.out.println("Sõna on: " + word);
            if (this.wordCountMap.get(word) == null) {
                this.wordCountMap.put(word, 1);
            } else {
                int thisWordCount = this.wordCountMap.get(word);
                this.wordCountMap.put(word, thisWordCount + 1);
            }
        }
    }
}
