public class Quote {
    public String text;
    public String author;

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public Quote(String text) {
        this.text = text;
        this.author = "    --- Ron Swanson";
    }
    public String toString() {
        return "Quotable Quote of the Moment:\n\n" + text + "\n\n" + "     --- " + author;
    }
}
