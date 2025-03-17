package application;

import java.util.List;

import application.logic.GetRSS;
import application.logic.RSSItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SampleController {
	
	// RSSフィードURLを定数として定義
    private static final String NIKKEI_RSS_URL = "https://business.nikkei.com/rss/sns/nb.rdf";
    private static final String YAHOO_RSS_URL = "https://news.yahoo.co.jp/rss/topics/top-picks.xml";

    // FXMLで指定したfx:idと一致するフィールドを定義
    @FXML
    private Label titleLabel;

    @FXML
    private ListView<RSSItem> feedListView;


    @FXML
    private void initialize() {
    }
    
    // 日経情報を読み込む
    @FXML
    private void handleNikkeiUrl() {
        loadRSSFeed(NIKKEI_RSS_URL);
    }

    // Yahoo!ニュースを読み込む
    @FXML
    private void yahooTopPicksUrl() {
        loadRSSFeed(YAHOO_RSS_URL);
    }
    
    // RSS取得処理の呼出
    private void loadRSSFeed(String rssUrl) {
        // RSSデータを取得
        List<RSSItem> rssItems = GetRSS.fetchRSSItems(rssUrl);

        // ListViewをクリアして新しいデータを追加
        feedListView.getItems().clear();
        feedListView.getItems().addAll(rssItems);

        // 選択リスナー（タイトルラベルを固定）
        feedListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            titleLabel.setText("feed"); // ラベルを固定
        });
    }
    

}
