package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for station reaching request
 */
public class StationReachingButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for station reaching request
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
