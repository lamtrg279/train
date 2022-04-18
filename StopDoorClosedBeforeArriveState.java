package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents train stop door closed before arriving state
 */
public class StopDoorClosedBeforeArriveState extends TrainState implements Notifiable {
	private static StopDoorClosedBeforeArriveState instance;
	private Timer timer;
	

	/**
	 * Private for the singleton pattern
	 */
	private StopDoorClosedBeforeArriveState() {
	}

	/**
	 * For singleton
	 * 
	 * @param second  second remaining
	 * @param arrived train arrived or depart
	 * @return the object
	 */
	public static StopDoorClosedBeforeArriveState getInstance() {
		if (instance == null) {
			instance = new StopDoorClosedBeforeArriveState();
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
		TrainContext.getInstance().changeState(StopDoorOpeningState.getInstance(4, false));
	}

	@Override
	public void enter() {
		timer = new Timer(this, 1);
		TrainContext.getInstance().showStopDoorsClosed();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
