package application.logic;

public class RSSItem {
    private String title;
    private String description;
    private String pubDate;

    public RSSItem(String title, String description, String pubDate) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return title;
    }
}
