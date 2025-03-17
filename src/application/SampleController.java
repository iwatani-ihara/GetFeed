package application;

import java.util.List;

import application.logic.GetRSS;
import application.logic.RSSItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	
	// RSSフィードURLを定数として定義
    private static final String NIKKEI_RSS_URL = "https://business.nikkei.com/rss/sns/nb.rdf";
    private static final String YAHOO_RSS_URL = "https://news.yahoo.co.jp/rss/topics/top-picks.xml";

    // FXMLで指定したfx:idと一致するフィールドを定義
    @FXML
    private Label titleLabel;

    @FXML
    private TableView<RSSItem> rssTableView;
    
    @FXML
    private TableColumn<RSSItem, String> timeColumn;

    @FXML
    private TableColumn<RSSItem, String> contentColumn;

    @FXML
    private void initialize() {
        // TableViewの列をRSSItemクラスのプロパティにバインド
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("pubDate"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // 初期ラベルを固定値に設定
        titleLabel.setText("feed");
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

        // ObservableListに変換してTableViewに設定
        ObservableList<RSSItem> observableList = FXCollections.observableArrayList(rssItems);
        rssTableView.setItems(observableList);

        // タイトルラベルは常に「feed」に固定
        titleLabel.setText("feed");
    }
    

}
