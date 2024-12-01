package application;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MatrixNode extends StackPane {
    private final Label label;

    public MatrixNode(String name, double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.LIGHTBLUE);

        label = new Label(name);
        setTranslateX(x);
        setTranslateY(y);

        getChildren().addAll(rectangle, label);
    }

    public void setValue(String value) {
        label.setText(value);
    }

    public String getValue() {
        return label.getText();
    }
}
