package edu.ics372.timer;

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
