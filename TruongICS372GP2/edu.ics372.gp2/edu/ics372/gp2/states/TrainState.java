package edu.ics372.gp2.states;

public abstract class TrainState {
	public abstract void enter();

	public abstract void leave();

	public void onStationReachedRequest() {

	}

	public void onStationReachingRequest() {

	}

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
