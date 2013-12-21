package com.trajan.utils.attendance.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Person {

	private String 		name;
	private String 		surname;
	private List<Row> 	rows;
	private DayInfo 	dayInfo;

	public Person() {
		rows = new ArrayList<Row>();
		dayInfo = new DayInfo();
	}

	public void addRow(Row row) {
		rows.add(row);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public DayInfo getDayInfo() {
		return dayInfo;
	}

	public void setDayInfo(DayInfo dayInfo) {
		this.dayInfo = dayInfo;
	}

	public void printPersonInfo() {
		DateFormat df = new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
		System.out.println();
		System.out.println(name + " " + surname);
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		System.out.format("%-15s%-30s", "Arrived:", df.format(dayInfo.getArrived()));
		System.out.println();
		System.out.format("%-15s%-30s", "Left:", df.format(dayInfo.getLeft()));
		System.out.println();
		System.out.format("%-15s%-20s", "Diff:", dayInfo.getDiff().toString());
		System.out.println();
		System.out.println();

		System.out.format("%-15s%-30s", "Inside:", dayInfo.getInside().toString());
		System.out.println();
		System.out.format("%-15s%-30s", "Outside:", dayInfo.getOutside().toString());
		System.out.println();
		System.out.format("%-15s%-30s", "Total:", dayInfo.getTotal().toString());
		System.out.println();
		System.out.println();
	}

}
