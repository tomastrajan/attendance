package com.trajan.utils.attendance.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static final String DEFAULT = "";

	private String pathSourceDir 		= DEFAULT;
	private String pathDestDir 			= DEFAULT;

	public ConfigLoader() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("attendance.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!prop.isEmpty()) {
			pathSourceDir = (String) (prop.get("srcDir") != null ? prop
					.get("srcDir") : DEFAULT);
			pathDestDir = (String) (prop.get("destDir") != null ? prop
					.get("destDir") : DEFAULT);
		}
	}

	public String getPathSourceDir() {
		return pathSourceDir;
	}

	public String getPathDestDir() {
		return pathDestDir;
	}

}
