package edu.ics372.gp2.states;

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

	@Override
	public void onStationReachedRequest() {
		TrainContext.getInstance().changeState(DecelerateDoorClosedState.getInstance());
	}

	@Override
	public void enter() {
		TrainContext.getInstance().showFullSpeed();
	}

	@Override
	public void leave() {
		TrainContext.getInstance().showStopDoorsClosed();
	}
}
