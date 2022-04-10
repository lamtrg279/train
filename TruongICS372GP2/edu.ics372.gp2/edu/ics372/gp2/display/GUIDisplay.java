package edu.ics372.gp2.display;

import edu.ics372.gp2.buttons.DoorObstructingButton;
import edu.ics372.gp2.buttons.GUIButton;
import edu.ics372.gp2.buttons.StationReachedButton;
import edu.ics372.gp2.buttons.StationReachingButton;
import edu.ics372.gp2.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * GUI to implement the TrainDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends Application implements TrainDisplay {
	private GUIButton stationReachedButton;
	private GUIButton stationReachingButton;
	private GUIButton doorObstructingButton;
	private Text doorStatus = new Text("Door Closed");
	private Text trainStatus = new Text("Train Stopped");

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		stationReachedButton = new StationReachedButton("Station Reached");
		stationReachingButton = new StationReachingButton("Station Reaching");
		doorObstructingButton = new DoorObstructingButton("Doors Obstructing");
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(trainStatus, 0, 0);
		pane.add(doorStatus, 1, 0);
		pane.add(stationReachingButton, 2, 0);
		pane.add(stationReachedButton, 3, 0);
		pane.add(doorObstructingButton, 4, 0);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train");
		TrainContext.getInstance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * Indicate the train accelerates and doors closed
	 */
	@Override
	public void showAccelerate(int time) {
		trainStatus.setText("Train accelerates for " + time + " seconds");
		doorStatus.setText("Doors closed");
	}

	/**
	 * Indicate the train decelerates and doors closed
	 */
	@Override
	public void showDecelerate() {
		trainStatus.setText("Train decelerates");
		doorStatus.setText("Doors closed");
	}

	/**
	 * Indicate the train at full speed and doors closed
	 */
	@Override
	public void showFullSpeed() {
		trainStatus.setText("Train at full speed");
		doorStatus.setText("Doors closed");
	}

	/**
	 * Indicate the train stopped and doors closed
	 */
	@Override
	public void showStopDoorsClosed() {
		trainStatus.setText("Train stopped");
		doorStatus.setText("Doors closed");
	}

	/**
	 * Indicate the train stopped and doors opening
	 */
	@Override
	public void showStopDoorsOpening(int time) {
		trainStatus.setText("Train stopped");
		doorStatus.setText("Doors opening (Elapsed time " + time + "s)");
	}

	/**
	 * Indicate the train stopped and doors opened
	 */
	@Override
	public void showStopDoorsOpened(int time) {
		trainStatus.setText("Train stopped");
		doorStatus.setText("Doors opened (Elapsed time " + time + "s)");
	}

	/**
	 * Indicate the train stopped and doors closing
	 */
	@Override
	public void showStopDoorsClosing(int time) {
		trainStatus.setText("Train stopped");
		doorStatus.setText("Doors closing (Elapsed time " + time + "s)");
	}

}
