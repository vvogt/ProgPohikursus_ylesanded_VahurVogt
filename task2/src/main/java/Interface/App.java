package Interface;

public class App {
    public static void main(String[] args) {

        Scrape scrape = new Scrape();
        scrape.run_msg();
        scrape.web_request("https://heeeeeeeey.com");
        scrape.save_file("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task2/src/main/java/Interface/output.txt");
        scrape.terminate_msg();
    }
}
