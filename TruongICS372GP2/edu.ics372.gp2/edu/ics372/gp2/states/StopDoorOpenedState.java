package edu.ics372.gp2.states;

import edu.ics372.timer.Notifiable;
import edu.ics372.timer.Timer;

public class StopDoorOpenedState extends TrainState implements Notifiable {
	private static StopDoorOpenedState instance;
	private Timer timer;
	private int second;

	/**
	 * Private for the singleton pattern
	 */
	private StopDoorOpenedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static StopDoorOpenedState getInstance(int second) {
		if (instance == null) {
			instance = new StopDoorOpenedState();
		}
		instance.setSecond(second);
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showStopDoorsOpened(timerValue);
	}

	@Override
	public void OnTimerRunsOut() {
		TrainContext.getInstance().showStopDoorsOpened(second);
		TrainContext.getInstance().changeState(StopDoorClosingState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, second);
		TrainContext.getInstance().showStopDoorsOpened(second);
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
}
