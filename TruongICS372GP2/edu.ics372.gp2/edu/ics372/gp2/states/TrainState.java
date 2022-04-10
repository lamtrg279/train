package edu.ics372.gp2.states;

/**
 * Super class for all states
 */
public abstract class TrainState {
	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Specifies the actions to be taken when the StationReached Button is pressed
	 */
	public void onStationReachedRequest() {

	}

	/**
	 * Specifies the actions to be taken when the StationReaching Button is pressed
	 */
	public void onStationReachingRequest() {

	}

	/**
	 * Specifies the actions to be taken when the DoorObstructing Button is pressed
	 */
	public void onDoorObstructingRequest() {

	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void onTimerTick(int timerValue) {

	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {

	}
}
