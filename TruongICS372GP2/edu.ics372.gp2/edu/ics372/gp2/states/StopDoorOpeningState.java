package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents train stop door opening state
 */
public class StopDoorOpeningState extends TrainState implements Notifiable {
	private static StopDoorOpeningState instance;
	private Timer timer;
	private int remainingTime;
	private boolean reopen;

	/**
	 * Private for the singleton pattern
	 */
	private StopDoorOpeningState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static StopDoorOpeningState getInstance(int remainingTime, boolean reopen) {
		if (instance == null) {
			instance = new StopDoorOpeningState();
		}
		instance.setRemainingTime(remainingTime);
		instance.setReopen(reopen);
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showStopDoorsOpening(timerValue);
	}

	@Override
	public void OnTimerRunsOut() {
		TrainContext.getInstance().showStopDoorsOpening(remainingTime);
		if (isReopen()) {
			TrainContext.getInstance().changeState(StopDoorOpenedState.getInstance(8));
		} else {
			TrainContext.getInstance().changeState(StopDoorOpenedState.getInstance(10));
		}
	}

	@Override
	public void enter() {
		timer = new Timer(this, remainingTime);
		TrainContext.getInstance().showStopDoorsOpening(remainingTime);
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	public boolean isReopen() {
		return reopen;
	}

	public void setReopen(boolean reopen) {
		this.reopen = reopen;
	}
}
