package com.trajan.utils.attendance.analyzer;

import java.util.Date;

import com.trajan.utils.attendance.model.Day;
import com.trajan.utils.attendance.model.DayRow;
import com.trajan.utils.attendance.model.ElapsedTime;
import com.trajan.utils.attendance.model.enums.EventType;

public class DayAnalyzer {

	private ElapsedTime elapsedInside;

	public DayAnalyzer() {
		elapsedInside = new ElapsedTime();
	}

	public void analyzeDay(Day day) {
		DayRow firstArrive = null;
		DayRow previousRow = null;
//		DayRow lastArrive = null;
//		DayRow lastLeave = null;

		Date inside = new Date();
		Date outside = new Date();
		Date total = new Date();
		inside.setTime(0l);
		outside.setTime(0l);
		for (int i = 0; i < day.getRows().size(); i++) {

			DayRow currentRow = day.getRows().get(i);
			if (firstArrive == null && isLeave(currentRow)) {
				continue;
			}
			if (firstArrive == null && isArrive(currentRow)) {
				firstArrive = currentRow;
				previousRow = currentRow;
				continue;
			}

			if (isLeave(currentRow) && isArrive(previousRow)) {
				inside.setTime(inside.getTime()
						+ getTimeDiffeceMillis(previousRow, currentRow));
			}
			if (isArrive(currentRow) && isLeave(previousRow)) {
				outside.setTime(outside.getTime()
						+ getTimeDiffeceMillis(previousRow, currentRow));
			}
			previousRow = currentRow;
		}
		total.setTime(inside.getTime() + outside.getTime());
		elapsedInside.setElapsedTime(inside);
		ElapsedTime elapsedOutside = new ElapsedTime(outside);
		ElapsedTime elapsedTotal = new ElapsedTime(total);
		DayRow helper = day.getRows().get(0);
		System.out.println("-------------------------------------------------------");
		System.out.println(helper.getName() + " " + helper.getSurname());
		System.out.println("Inside: " + elapsedInside.toString());
		System.out.println("Outside: " + elapsedOutside.toString());
		System.out.println("Total: " + elapsedTotal.toString());
	}

	private boolean isArrive(DayRow row) {
		return row.getType() == EventType.ARRIVE;
	}

	private boolean isLeave(DayRow row) {
		return row.getType() == EventType.LEAVE;
	}

	private long getTimeDiffeceMillis(DayRow previousRow, DayRow currentRow) {
		return currentRow.getTime().getTime() - previousRow.getTime().getTime();
	}

}
