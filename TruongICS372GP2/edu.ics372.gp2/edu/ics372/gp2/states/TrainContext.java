package edu.ics372.gp2.states;

import edu.ics372.gp2.display.TrainDisplay;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class TrainContext {
	private TrainDisplay display;
	private TrainState currentState;
	private static TrainContext instance;

	/**
	 * Make it a singleton
	 */
	private TrainContext() {
		instance = this;
		currentState = AccelerateDoorClosedState.getInstance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its reference.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(TrainDisplay display) {
		this.display = display;
		initialize();
	}

	/**
	 * Lets door closed state be the starting state adds the object as an observable
	 * for clock
	 */
	public void initialize() {
		AccelerateDoorClosedState.getInstance().enter();
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void onStationReachingRequest() {
		currentState.onStationReachingRequest();
	}

	public void onStationReachedRequest() {
		currentState.onStationReachedRequest();
	}

	public void onDoorObstructingRequest() {
		currentState.onDoorObstructingRequest();
	}

	public void showAccelerate(int time) {
		display.showAccelerate(time);
	}

	public void showDecelerate() {
		display.showDecelerate();
	}

	public void showFullSpeed() {
		display.showFullSpeed();
	}

	public void showStopDoorsClosed() {
		display.showStopDoorsClosed();
	}

	public void showStopDoorsOpening(int time) {
		display.showStopDoorsOpening(time);
	}

	public void showStopDoorsOpened(int time) {
		display.showStopDoorsOpened(time);
	}

	public void showStopDoorsClosing(int time) {
		display.showStopDoorsClosing(time);
	}
}
