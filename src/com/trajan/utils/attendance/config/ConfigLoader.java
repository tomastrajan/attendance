package com.trajan.utils.attendance.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static final String DEFAULT = "";
	private static final String DEFAULT_BOOLEAN = "false";

	private String pathSourceDir = DEFAULT;
	private String pathDestDir = DEFAULT;
	private Boolean outputConsole = Boolean.valueOf(DEFAULT_BOOLEAN);
	private Boolean outputFile = Boolean.valueOf(DEFAULT_BOOLEAN);

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
			outputConsole = Boolean
					.valueOf((String) (prop.get("outputConsole") != null ? prop
							.get("outputConsole") : DEFAULT_BOOLEAN));
			outputFile = Boolean
					.valueOf((String) (prop.get("outputFile") != null ? prop
							.get("outputFile") : DEFAULT_BOOLEAN));
		}
	}

	public String getPathSourceDir() {
		return pathSourceDir;
	}

	public String getPathDestDir() {
		return pathDestDir;
	}

	public Boolean getOutputConsole() {
		return outputConsole;
	}

	public Boolean getOutputFile() {
		return outputFile;
	}

}
