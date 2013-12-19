package com.trajan.utils.attendance.model;

import java.util.Date;
import java.util.List;

public class Person {

	private String name;
	private String surname;
	private Date arrived;
	private Date left;
	private Date worked;
	private List<Day> days;

	public Person() {
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

	public Date getArrived() {
		return arrived;
	}

	public void setArrived(Date arrived) {
		this.arrived = arrived;
	}

	public Date getLeft() {
		return left;
	}

	public void setLeft(Date left) {
		this.left = left;
	}

	public Date getWorked() {
		return worked;
	}

	public void setWorked(Date worked) {
		this.worked = worked;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

}
