package application.logic;

public class RSSItem {
    private String title;
    private String description;

    public RSSItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title; // ListViewにはタイトルのみ表示
    }
}
