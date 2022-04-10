package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for door obstructing
 */
public class DoorObstructingButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for door obstructing
	 * 
	 * @param string
	 */
	public DoorObstructingButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onDoorObstructingRequest();
	}
}
