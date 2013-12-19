package com.trajan.utils.attendance.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

	private File sourceDir;
	private List<BufferedReader> files;

	public FileLoader(String sourceDirLocation) {
		sourceDir = new File(sourceDirLocation);
		files = new ArrayList<BufferedReader>();
		listFilesForFolder(sourceDir);
	}

	public List<BufferedReader> getFiles() {
		return files;
	}

	private void listFilesForFolder(final File folder) {
		for (final File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				try {

					BufferedReader br = new BufferedReader(new FileReader(
							file.getAbsoluteFile()));
					files.add(br);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
