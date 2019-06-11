package quotes;

public class Quote {
    String author;
    String text;
    String[] tags = new String[1];
    String likes;

    Quote(String author, String quotes, String[] tags, String likes){
        this.author = author;
        this.text = quotes;
        this.tags = tags;
        this.likes = likes;
    }

    public String toString() {
        return (this.author + ": " + this.text);
    }
}
