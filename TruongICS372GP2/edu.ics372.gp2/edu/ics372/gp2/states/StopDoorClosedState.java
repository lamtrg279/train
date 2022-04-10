package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents train stop door closed state
 */
public class StopDoorClosedState extends TrainState implements Notifiable {
	private static StopDoorClosedState instance;
	private Timer timer;
	private int second;
	private boolean arrived;

	/**
	 * Private for the singleton pattern
	 */
	private StopDoorClosedState() {
	}

	/**
	 * For singleton
	 * 
	 * @param second  second remaining
	 * @param arrived train arrived or depart
	 * @return the object
	 */
	public static StopDoorClosedState getInstance(int second, boolean arrived) {
		if (instance == null) {
			instance = new StopDoorClosedState();
		}
		instance.setSecond(second);
		instance.setArrived(arrived);
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showStopDoorsClosed();
	}

	@Override
	public void OnTimerRunsOut() {
		TrainContext.getInstance().showStopDoorsClosed();
		if (isArrived()) {
			TrainContext.getInstance().changeState(StopDoorOpeningState.getInstance(4, false));
		} else {
			TrainContext.getInstance().changeState(AccelerateDoorClosedState.getInstance());
		}
	}

	@Override
	public void enter() {
		timer = new Timer(this, instance.getSecond());
		TrainContext.getInstance().showStopDoorsClosed();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	public boolean isArrived() {
		return arrived;
	}

	public void setArrived(boolean arrived) {
		this.arrived = arrived;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
