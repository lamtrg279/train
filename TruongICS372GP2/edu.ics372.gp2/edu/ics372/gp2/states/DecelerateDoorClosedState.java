package edu.ics372.gp2.states;

/**
 * Represents the decelerate door closed state
 */
public class DecelerateDoorClosedState extends TrainState {
	private static DecelerateDoorClosedState instance;

	/**
	 * Private for the singleton pattern
	 */
	private DecelerateDoorClosedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static DecelerateDoorClosedState getInstance() {
		if (instance == null) {
			instance = new DecelerateDoorClosedState();
		}
		return instance;
	}

	/**
	 * Process station reached request
	 */
	@Override
	public void onStationReachedRequest() {
		boolean arrived = true;
	}

	/**
	 * Initializes the state. Adds itself as a listener
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showDecelerate();
		TrainContext.getInstance().changeState(StopDoorClosedBeforeArriveState.getInstance());
	}

	@Override
	public void leave() {
	}

}
