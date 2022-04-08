package edu.ics372.gp2.states;

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

	@Override
	public void onStationReachedRequest() {
		boolean arrived = true;
		TrainContext.getInstance().changeState(StopDoorClosedState.getInstance(1, arrived));
	}

	@Override
	public void enter() {
		TrainContext.getInstance().showDecelerate();
	}

	@Override
	public void leave() {
	}

}
