package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private ToggleGroup tools;
    
    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (pen.isSelected()) {
    		Circle newBlackCircle = new Circle(event.getX(), 
        			event.getY(), 4, Color.BLACK);
        	drawingAreaPane.getChildren().add(newBlackCircle);
    	}else if (eraser.isSelected()){
    		Circle newWhiteCircle = new Circle(event.getX(),
        			event.getY(), 4, Color.WHITE);
        	drawingAreaPane.getChildren().add(newWhiteCircle);
    	}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}

