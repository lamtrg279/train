package edu.ics372.gp2.timer;

/**
 * An entity that can be notified of timing events
 */
public interface Notifiable {
	/**
	 * Process timer ticks
	 */
	public void OnTimerTick(int timerValue);

	/**
	 * Process timer runs out event
	 */
	public void OnTimerRunsOut();

}
