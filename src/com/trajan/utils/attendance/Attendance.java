package com.trajan.utils.attendance;

import java.io.BufferedReader;
import java.io.IOException;

import com.trajan.utils.attendance.config.ConfigLoader;
import com.trajan.utils.attendance.file.FileLoader;
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

	public Attendance() {

		System.out.println("Working Directory = "
				+ System.getProperty("user.dir"));

		config = new ConfigLoader();
		files = new FileLoader(config.getPathSourceDir());
		writer = new FileOutputWritter(config.getPathDestDir());
		parser = new DayParser();

		for (BufferedReader file : files.getFiles()) {
			parser.setData(file);
		}

		if(config.getOutputFile()) {
			writer.writeOutput(parser.getPersons());
		}

		if (config.getOutputConsole()) {
			for (Person person : parser.getPersons()) {
				person.printPersonInfo();
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

}
