module edu.ics372.gp2 {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;

	exports edu.ics372.gp2.display to javafx.graphics;
	exports edu.ics372.gp2.start to javafx.graphics;
}