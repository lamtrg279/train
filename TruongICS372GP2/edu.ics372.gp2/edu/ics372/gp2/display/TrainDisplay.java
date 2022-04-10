package edu.ics372.gp2.display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface TrainDisplay {
	/**
	 * Display the train accelerates
	 * 
	 * @param time remaining time
	 */
	public void showAccelerate(int time);

	/**
	 * Display the train decelerates
	 */
	public void showDecelerate();

	/**
	 * Display the train full speed
	 */
	public void showFullSpeed();

	/**
	 * Display the train stopped, doors closed
	 */
	public void showStopDoorsClosed();

	/**
	 * Display the train stopped, doors opening
	 * 
	 * @param time remaining time
	 */
	public void showStopDoorsOpening(int time);

	/**
	 * Display the train stopped, doors opened
	 * 
	 * @param time remaining time
	 */
	public void showStopDoorsOpened(int time);

	/**
	 * Display the train stopped, doors closing
	 * 
	 * @param time remaining time
	 */
	public void showStopDoorsClosing(int time);

}
