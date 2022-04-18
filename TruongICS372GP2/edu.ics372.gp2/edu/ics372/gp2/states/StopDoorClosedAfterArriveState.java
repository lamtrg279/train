package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents train stop door closed after arriving state
 */
public class StopDoorClosedAfterArriveState extends TrainState implements Notifiable {
	private static StopDoorClosedAfterArriveState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private StopDoorClosedAfterArriveState() {
	}

	/**
	 * For singleton
	 * 
	 * @param second  second remaining
	 * @param arrived train arrived or depart
	 * @return the object
	 */
	public static StopDoorClosedAfterArriveState getInstance() {
		if (instance == null) {
			instance = new StopDoorClosedAfterArriveState();
		}
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showStopDoorsClosed();
	}

	@Override
	public void OnTimerRunsOut() {
		TrainContext.getInstance().showStopDoorsClosed();
		TrainContext.getInstance().changeState(AccelerateDoorClosedState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 3);
		TrainContext.getInstance().showStopDoorsClosed();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
