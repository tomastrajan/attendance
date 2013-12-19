package com.trajan.utils.attendance.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	private String surname;
	private List<Day> days;

	public Person() {
		days = new ArrayList<Day>();
	}

	public void addDay(Day day) {
		days.add(day);
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

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

}
