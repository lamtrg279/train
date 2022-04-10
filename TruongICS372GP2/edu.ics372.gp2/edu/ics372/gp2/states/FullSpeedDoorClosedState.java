package edu.ics372.gp2.states;

/**
 * Represents the full speed door closed state
 */
public class FullSpeedDoorClosedState extends TrainState {
	private static FullSpeedDoorClosedState instance;

	/**
	 * Private for the singleton pattern
	 */
	private FullSpeedDoorClosedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static FullSpeedDoorClosedState getInstance() {
		if (instance == null) {
			instance = new FullSpeedDoorClosedState();
		}
		return instance;
	}

	/**
	 * Process station reached request
	 */
	@Override
	public void onStationReachedRequest() {
		TrainContext.getInstance().changeState(DecelerateDoorClosedState.getInstance());
	}

	/**
	 * Initializes state. Adds itself as listener
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showFullSpeed();
	}

	@Override
	public void leave() {
		TrainContext.getInstance().showStopDoorsClosed();
	}
}
