package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents train stop door closing state
 */
public class StopDoorClosingState extends TrainState implements Notifiable {
	private static StopDoorClosingState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private StopDoorClosingState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static StopDoorClosingState getInstance() {
		if (instance == null) {
			instance = new StopDoorClosingState();
		}
		return instance;
	}

	@Override
	public void onDoorObstructingRequest() {
		int remainingTimer = (5 - timer.getTimeValue()) * 4 / 5;
		TrainContext.getInstance().changeState(StopDoorOpeningState.getInstance(remainingTimer, true));
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showStopDoorsClosing(timerValue);
	}

	@Override
	public void OnTimerRunsOut() {
		TrainContext.getInstance().showStopDoorsClosed();
		TrainContext.getInstance().changeState(StopDoorClosedState.getInstance(3, false));
	}

	@Override
	public void enter() {
		timer = new Timer(this, 5);
		TrainContext.getInstance().showStopDoorsClosing(5);
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
