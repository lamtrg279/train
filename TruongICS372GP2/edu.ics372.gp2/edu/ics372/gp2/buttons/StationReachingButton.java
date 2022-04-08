package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StationReachingButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for cooking
	 * 
	 * @param string
	 */
	public StationReachingButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onStationReachingRequest();
	}
}
