module Feedly {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.xml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.logic to javafx.base;
	
	exports application;
    exports application.logic;
}
