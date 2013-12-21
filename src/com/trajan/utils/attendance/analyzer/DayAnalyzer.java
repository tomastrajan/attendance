package com.trajan.utils.attendance.analyzer;

import java.util.Date;

import com.trajan.utils.attendance.model.ElapsedTime;
import com.trajan.utils.attendance.model.Person;
import com.trajan.utils.attendance.model.Row;
import com.trajan.utils.attendance.model.enums.EventType;

public class DayAnalyzer {

	public DayAnalyzer() {
	}

	public void analyzePerson(Person person) {
		Row firstArrive = null;
		Row previousRow = null;
		Row lastLeave = null;

		Date inside = new Date();
		Date outside = new Date();
		Date total = new Date();
		Date diff = new Date();
		inside.setTime(0l);
		outside.setTime(0l);
		for (int i = 0; i < person.getRows().size(); i++) {

			Row currentRow = person.getRows().get(i);
			if (firstArrive == null && isLeave(currentRow)) {
				continue;
			}
			if (firstArrive == null && isArrive(currentRow)) {
				firstArrive = currentRow;
				previousRow = currentRow;
				continue;
			}

			if (isLeave(currentRow) && isArrive(previousRow)) {
				lastLeave = currentRow;
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
		diff .setTime(lastLeave.getTime().getTime() - firstArrive.getTime().getTime());

		person.getDayInfo().setArrived(firstArrive.getTime());
		person.getDayInfo().setLeft(lastLeave.getTime());
		person.getDayInfo().setDiff(new ElapsedTime(diff));
		person.getDayInfo().setInside(new ElapsedTime(inside));
		person.getDayInfo().setOutside(new ElapsedTime(outside));
		person.getDayInfo().setTotal(new ElapsedTime(total));
	}

	private boolean isArrive(Row row) {
		return row.getType() == EventType.ARRIVE;
	}

	private boolean isLeave(Row row) {
		return row.getType() == EventType.LEAVE;
	}

	private long getTimeDiffeceMillis(Row previousRow, Row currentRow) {
		return currentRow.getTime().getTime() - previousRow.getTime().getTime();
	}

}
