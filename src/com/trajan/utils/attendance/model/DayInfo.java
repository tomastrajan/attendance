package com.trajan.utils.attendance.model;

import java.util.Date;

public class DayInfo {

	private Date 		arrived;
	private Date 		left;
	private ElapsedTime diff;
	private ElapsedTime inside;
	private ElapsedTime outside;
	private ElapsedTime total;

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

	public ElapsedTime getDiff() {
		return diff;
	}

	public void setDiff(ElapsedTime diff) {
		this.diff = diff;
	}

	public ElapsedTime getInside() {
		return inside;
	}

	public void setInside(ElapsedTime inside) {
		this.inside = inside;
	}

	public ElapsedTime getOutside() {
		return outside;
	}

	public void setOutside(ElapsedTime outside) {
		this.outside = outside;
	}

	public ElapsedTime getTotal() {
		return total;
	}

	public void setTotal(ElapsedTime total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DayInfo [arrived=");
		builder.append(arrived);
		builder.append(", left=");
		builder.append(left);
		builder.append(", inside=");
		builder.append(inside);
		builder.append(", outside=");
		builder.append(outside);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

}
