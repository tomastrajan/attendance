package com.trajan.utils.attendance.model;

import java.util.Date;

import com.trajan.utils.attendance.model.enums.EventType;

public class Row {

	private Date time;
	private EventType type;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Row [time=");
		builder.append(time);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
