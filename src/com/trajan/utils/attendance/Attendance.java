package com.trajan.utils.attendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.trajan.utils.attendance.config.ConfigLoader;
import com.trajan.utils.attendance.file.FileLoader;
import com.trajan.utils.attendance.model.Day;
import com.trajan.utils.attendance.model.Person;
import com.trajan.utils.attendance.output.FileOutputWritter;
import com.trajan.utils.attendance.parser.DayParser;

public class Attendance {

	public static void main(String... args) {
		new Attendance();
	}

	private ConfigLoader config;
	private FileLoader files;
	private FileOutputWritter writer;
	private DayParser parser;
	private List<Person> persons;

	public Attendance() {

		System.out.println("Working Directory = "
				+ System.getProperty("user.dir"));

		config = new ConfigLoader();
		files = new FileLoader(config.getPathSourceDir());
		writer = new FileOutputWritter(config.getPathDestDir());
		parser = new DayParser();
		persons = new ArrayList<Person>();

		for (BufferedReader file : files.getFiles()) {
			parser.setData(file);
			Person person = new Person();
			person.setName(parser.getName());
			person.setSurname(parser.getSurname());
			person.addDay(parser.getDay());
			persons.add(person);
		}

		for (Person person : persons) {
			writer.writeOutput(person);
			System.out.println();
			System.out.println("-----------------------------------------");
			System.out.println();
			System.out.println(person.getName() + " " + person.getSurname());
			System.out.println();
			for (Day day : person.getDays()) {
				DateFormat df = new SimpleDateFormat("dd. MM. yyyy");
				System.out.println("Date: " + df.format(day.getDate()));
				System.out.println("Inside: " + day.getElapsedInside().toString());
				System.out.println("Outside: " + day.getElapsedOutside().toString());
				System.out.println("Total: " + day.getElapsedTotal().toString());
				System.out.println();
			}
		}

		System.out.println();
		System.out.println("Press enter to exit");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
