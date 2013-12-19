package com.trajan.utils.attendance;

import java.io.BufferedReader;
import java.io.IOException;

import com.trajan.utils.attendance.analyzer.DayAnalyzer;
import com.trajan.utils.attendance.config.ConfigLoader;
import com.trajan.utils.attendance.file.FileLoader;
import com.trajan.utils.attendance.parser.DayParser;

public class Attendance {

	public static void main(String... args) {
		new Attendance();
	}

	private ConfigLoader config;
	private FileLoader files;
	private DayParser parser;
	private DayAnalyzer analyzer;

	public Attendance() {

		System.out.println("Working Directory = "
				+ System.getProperty("user.dir"));

		config = new ConfigLoader();
		files = new FileLoader(config.getPathSourceDir());
		parser = new DayParser();
		analyzer = new DayAnalyzer();

		for (BufferedReader file : files.getFiles()) {
			parser.setData(file);
			analyzer.analyzeDay(parser.getDay());
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
