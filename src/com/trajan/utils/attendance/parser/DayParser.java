package com.trajan.utils.attendance.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.trajan.utils.attendance.model.Day;
import com.trajan.utils.attendance.model.DayRow;
import com.trajan.utils.attendance.model.enums.EventType;

public class DayParser {

	private BufferedReader data;
	private Day day;

	public DayParser() {
	}

	public void setData(BufferedReader data) {
		this.data = data;
		day = new Day();
		parseData();
	}

	public Day getDay() {
		return day;
	}

	private void parseData() {
		String line;
		try {
			while ((line = data.readLine()) != null) {
				String[] tokens = line.split("\\s{2,}");
				if (tokens[0].substring(0,1).matches("[a-zA-Z]|-")) {
					continue;
				}
				DayRow row = new DayRow();
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				row.setTime(df.parse(tokens[0]));
				row.setName(tokens[2].split("\\s")[1]);
				row.setSurname(tokens[2].split("\\s")[0]);
				if (tokens[4].contains("Vstup")) {
					row.setType(EventType.ARRIVE);
				} else {
					row.setType(EventType.LEAVE);
				}
				day.addRow(row);
			}
			data.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}



}
