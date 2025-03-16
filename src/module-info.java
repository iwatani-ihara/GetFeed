module Feedly {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.xml;
	
	opens application to javafx.graphics, javafx.fxml;
}
