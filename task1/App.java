public class App{
    public static void main(String[] args) {
        Functions textToRead = new Functions("/Users/vahurvogt/Documents/TLU/progPohikursus/ylesanded/task1/artiklikogumik.txt");
        System.out.println(textToRead.wordCountMap);
    }
}