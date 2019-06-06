package quotes;

public class Quote {
    String author;
    String text;

    Quote(String author, String quotes){
        this.author = author;
        this.text = quotes;
    }

    public String toString() {
        return (this.author + ": " + this.text);
    }
}
