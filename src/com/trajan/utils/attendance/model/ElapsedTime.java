package com.trajan.utils.attendance.model;

import java.util.Date;

public class ElapsedTime {

	private Date elapsedTime;
	private long elapsedHours;
	private long elapsedMinutes;
	private long elapsedSeconds;

	public ElapsedTime() {
	}

	public ElapsedTime(Date elapsedTime) {
		setElapsedTime(elapsedTime);
	}

	public void setElapsedTime(Date elapsedTime) {
		this.elapsedTime = elapsedTime;

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsed = elapsedTime.getTime();

		elapsed = elapsed % daysInMilli;
		elapsedHours = elapsed / hoursInMilli;
		elapsed = elapsed % hoursInMilli;
		elapsedMinutes = elapsed / minutesInMilli;
		elapsed = elapsed % minutesInMilli;
		elapsedSeconds = elapsed / secondsInMilli;
	}

	public void printElapsedTime() {
		System.out.printf("%d hours, %d minutes, %d seconds%n", elapsedHours,
				elapsedMinutes, elapsedSeconds);
	}

	public String toString() {
		return elapsedHours + " hours, " + elapsedMinutes + " minutes, "
				+ elapsedSeconds + " seconds";
	}

	public Date getElapsedTime() {
		return elapsedTime;
	}

}
