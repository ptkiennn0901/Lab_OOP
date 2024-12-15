/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.controls;
	exports hust.soict.dsai.javafx;
	opens hust.soict.dsai.javafx to javafx.graphics, javafx.fxml;
}