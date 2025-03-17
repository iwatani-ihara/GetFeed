package application;

import java.util.List;

import application.logic.GetRSS;
import application.logic.RSSItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SampleController {

    // FXMLで指定したfx:idと一致するフィールドを定義
    @FXML
    private Label titleLabel;

    @FXML
    private ListView<RSSItem> feedListView;


    @FXML
    private void initialize() {
    }
    
    @FXML
    private void handleNikkeiUrl() {
        // RSSフィードURL
        String rssUrl = "https://business.nikkei.com/rss/sns/nb.rdf";

        // RSSデータを取得
        List<RSSItem> rssItems = GetRSS.fetchRSSItems(rssUrl);

        // ListViewをクリアして新しいデータを追加
        feedListView.getItems().clear();
        feedListView.getItems().addAll(rssItems);

        // 選択リスナーを追加（詳細表示）
        feedListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                titleLabel.setText(newSelection.getDescription()); // 内容を表示
//            }
        });
    }
    @FXML
    private void yahooTopPicksUrl() {
        // RSSフィードURL
        String rssUrl = "https://news.yahoo.co.jp/rss/topics/top-picks.xml";

        // RSSデータを取得
        List<RSSItem> rssItems = GetRSS.fetchRSSItems(rssUrl);

        // ListViewをクリアして新しいデータを追加
        feedListView.getItems().clear();
        feedListView.getItems().addAll(rssItems);

        // 選択リスナーを追加（詳細表示）
        feedListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                titleLabel.setText(newSelection.getDescription()); // 内容を表示
//            }
        });
    }

}
