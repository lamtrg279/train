package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents the accelerate door closed state
 */
public class AccelerateDoorClosedState extends TrainState implements Notifiable {
	private static AccelerateDoorClosedState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private AccelerateDoorClosedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static AccelerateDoorClosedState getInstance() {
		if (instance == null) {
			instance = new AccelerateDoorClosedState();
		}
		return instance;
	}

	@Override
	public void onStationReachingRequest() {
		TrainContext.getInstance().changeState(DecelerateDoorClosedState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showAccelerate(timerValue);
	}

	@Override
	public void OnTimerRunsOut() {
		TrainContext.getInstance().showAccelerate(0);
		TrainContext.getInstance().changeState(FullSpeedDoorClosedState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 6);
		TrainContext.getInstance().showAccelerate(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showDecelerate();
		TrainContext.getInstance().showAccelerate(0);
	}
}
