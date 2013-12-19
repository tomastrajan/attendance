package com.trajan.utils.attendance.output;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.trajan.utils.attendance.model.Day;
import com.trajan.utils.attendance.model.Person;

public class FileOutputWritter {

	private String destDirLocation;

	public FileOutputWritter(String destDirLocation) {
		this.destDirLocation = destDirLocation;
	}

	public void writeOutput(Person person) {

		PrintWriter writer;
		try {
			writer = new PrintWriter(destDirLocation + "/" + person.getName()
					+ "-" + person.getSurname() + "."
							+ "txt", "UTF-8");
			writer.println();
			writer.println(person.getName() + " " + person.getSurname());
			writer.println();
			for (Day day : person.getDays()) {
				DateFormat df = new SimpleDateFormat("dd. MM. yyyy");
				writer.println("Date: " + df.format(day.getDate()));
				writer.println("Inside: " + day.getElapsedInside().toString());
				writer.println("Outside: " + day.getElapsedOutside().toString());
				writer.println("Total: " + day.getElapsedTotal().toString());
				writer.println();
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
