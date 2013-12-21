package com.trajan.utils.attendance.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.trajan.utils.attendance.analyzer.DayAnalyzer;
import com.trajan.utils.attendance.model.Person;
import com.trajan.utils.attendance.model.Row;
import com.trajan.utils.attendance.model.enums.EventType;

public class DayParser {

	private BufferedReader 	data;
	private DayAnalyzer 	analyzer;
	private List<Person>	persons;

	private boolean 		personFound;
	private int 			blankLineCounter;

	public DayParser() {
		analyzer = new DayAnalyzer();
	}

	public void setData(BufferedReader data) {
		this.data = data;
		personFound = false;
		blankLineCounter = 0;
		persons = new ArrayList<Person>();

		parseData();
	}

	private void parseData() {
		Person foundPerson = null;
		String line;
		try {
			while ((line = data.readLine()) != null) {

				if (!personFound) {
					if (line.contains("Pro osobu:")) {
						personFound = true;
						foundPerson = new Person();
						line = line.replace("Pro osobu: ", "");
						String[] tokens = line.split(" ");
						foundPerson.setName(tokens[1]);
						foundPerson.setSurname(tokens[0]);
						persons.add(foundPerson);
					}
					continue;
				}

				if (line.matches("^\\s*$")) {
					blankLineCounter++;
					if (blankLineCounter > 1) {
						personFound = false;
						blankLineCounter = 0;
					}
					continue;
				}

				String[] tokens = line.split("\\s{2,}");
				if (tokens[0].substring(0,1).matches("[a-zA-Z]|-")) {
					continue;
				}
				Row row = new Row();
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				row.setTime(df.parse(tokens[0]));
				if (tokens[4].contains("Vstup")) {
					row.setType(EventType.ARRIVE);
				} else {
					row.setType(EventType.LEAVE);
				}
				foundPerson.getRows().add(row);
			}

			for (Person person : persons) {
				analyzer.analyzePerson(person);
			}
			data.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public List<Person> getPersons() {
		return persons;
	}

}
