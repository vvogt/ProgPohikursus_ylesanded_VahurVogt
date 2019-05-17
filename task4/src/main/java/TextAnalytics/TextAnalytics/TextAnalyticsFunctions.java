package TextAnalytics.TextAnalytics;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class TextAnalyticsFunctions implements TextAnalyticsInterface {
    public String[] lowerCaseLetters(String[] wordArray) {
        for (int i = 0; i < wordArray.length; i++) {
            String word = wordArray[i];
            wordArray[i] = word.toLowerCase();
        }
        return wordArray;
    }

    public int countLetterMoreThan(String[] wordArray, char letter, int letterCount) {
        int count = 0;

        for (int i = 0; i < wordArray.length; i++) {
            String word = wordArray[i];
            int countInWord = 0;

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == letter) {
                    countInWord ++;
                }
            }

            if (countInWord > letterCount) {
                count ++;
            }

        }
        
        return count;
    }

    public String readFile(String path) {
        String text = "";
        Path file_path = Paths.get(path);
        try {
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);
            String file_content_str = new String(file_content_in_bytes, StandardCharsets.UTF_8);
            text = file_content_str;
            // System.out.println(file_content);
        } catch (IOException my_error) {
            my_error.printStackTrace();
        }
        return text;
    }

    public String[] splitWords(String text) {
        String[] wordArray = text.split("\\s");
        return wordArray;
    }
}