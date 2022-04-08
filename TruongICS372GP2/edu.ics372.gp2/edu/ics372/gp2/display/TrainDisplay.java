package edu.ics372.gp2.display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface TrainDisplay {
	public void showAccelerate(int time);

	public void showDecelerate();

	public void showFullSpeed();

	public void showStopDoorsClosed();

	public void showStopDoorsOpening(int time);

	public void showStopDoorsOpened(int time);

	public void showStopDoorsClosing(int time);

}
