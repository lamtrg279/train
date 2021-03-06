package edu.ics372.gp2.start;

import edu.ics372.gp2.display.GUIDisplay;
import edu.ics372.gp2.timer.Clock;
import javafx.application.Application;

/**
 * The main class to start the project
 */
public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}