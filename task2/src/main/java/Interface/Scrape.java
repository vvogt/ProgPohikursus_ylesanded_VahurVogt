package Interface;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Scrape implements ScrapeInterface {
    private String url;
    private String html;
    
    public void run_msg() {
        System.out.println("Scraper hakkas tööle");
    };
    
    public void web_request(String url) {
        this.url = url;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            this.html = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save_file(String fileName) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(this.html);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void terminate_msg() {
        System.out.println("Scraper lülitas välja");
    }


}
