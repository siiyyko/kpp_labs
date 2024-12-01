module lab4 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.base;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
