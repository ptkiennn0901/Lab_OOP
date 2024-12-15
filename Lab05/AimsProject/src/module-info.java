/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.swing;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	requires java.naming;
	opens hust.soict.dsai.aims.screen to javafx.fxml, javafx.graphics;
	opens hust.soict.dsai.aims.media to javafx.base;
}