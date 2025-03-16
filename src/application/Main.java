package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
	
	@Override
    public void start(Stage primaryStage) {
        try {
            // FXMLファイルをロードし、ルート要素を取得
            Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
//            BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));

            // シーンを作成（FXMLで定義したサイズを使用）
            Scene scene = new Scene(root);

            // CSSスタイルを適用
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            // ステージにシーンを設定
            primaryStage.setScene(scene);

            // ウィンドウタイトルを設定
            primaryStage.setTitle("My JavaFX Application");

            // ステージを表示
            primaryStage.show();
        } catch (Exception e) {
            // 例外処理：エラー詳細を出力
            e.printStackTrace();
            System.err.println("Error loading FXML or other resources.");
        }
    }

    public static void main(String[] args) {
        // JavaFXアプリケーションを起動
        launch(args);
    }
}
