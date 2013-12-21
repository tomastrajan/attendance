package com.trajan.utils.attendance.output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.trajan.utils.attendance.model.Person;

public class FileOutputWritter {

	private String destDirLocation;

	public FileOutputWritter(String destDirLocation) {
		this.destDirLocation = destDirLocation;
	}

	public void writeOutput(List<Person> persons) {

		PrintWriter writer;
		try {
			DateFormat df = new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
			DateFormat dfFile = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
			writer = new PrintWriter(destDirLocation + "/attendance_"
					+ dfFile.format(new Date()) + "." + "txt", "UTF-8");
			for (Person person : persons) {
				writer.println();
				writer.println(person.getName() + " " + person.getSurname());
				writer.println("--------------------------------------------------------------");
				writer.println(String.format("%-15s%-30s", "Arrived:",
						df.format(person.getDayInfo().getArrived())));
				writer.println(String.format("%-15s%-30s", "Left:",
						df.format(person.getDayInfo().getLeft())));
				writer.println(String.format("%-15s%-20s", "Diff:", person
						.getDayInfo().getDiff().toString()));
				writer.println();
				writer.println(String.format("%-15s%-30s", "Inside:", person
						.getDayInfo().getInside().toString()));
				writer.println(String.format("%-15s%-30s", "Outside:", person
						.getDayInfo().getOutside().toString()));
				writer.println(String.format("%-15s%-30s", "Total:", person
						.getDayInfo().getTotal().toString()));
				writer.println();
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
