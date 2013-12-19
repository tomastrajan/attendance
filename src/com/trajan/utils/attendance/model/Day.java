package com.trajan.utils.attendance.model;

import java.util.ArrayList;
import java.util.List;

public class Day {

	private List<DayRow> rows;

	public Day() {
		rows = new ArrayList<DayRow>();
	}

	public List<DayRow> getRows() {
		return rows;
	}

	public void addRow(DayRow row) {
		this.rows.add(row);
	}

}
