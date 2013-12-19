package com.trajan.utils.attendance.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Day {

	private List<DayRow> rows;

	private Date date;
	private ElapsedTime elapsedInside;
	private ElapsedTime elapsedOutside;
	private ElapsedTime elapsedTotal;

	public Day() {
		rows = new ArrayList<DayRow>();
	}

	public List<DayRow> getRows() {
		return rows;
	}

	public void addRow(DayRow row) {
		this.rows.add(row);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ElapsedTime getElapsedInside() {
		return elapsedInside;
	}

	public void setElapsedInside(ElapsedTime elapsedInside) {
		this.elapsedInside = elapsedInside;
	}

	public ElapsedTime getElapsedOutside() {
		return elapsedOutside;
	}

	public void setElapsedOutside(ElapsedTime elapsedOutside) {
		this.elapsedOutside = elapsedOutside;
	}

	public ElapsedTime getElapsedTotal() {
		return elapsedTotal;
	}

	public void setElapsedTotal(ElapsedTime elapsedTotal) {
		this.elapsedTotal = elapsedTotal;
	}

}
