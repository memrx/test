package com.trantor.demo.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFetcher {

	public static String readKeyFromPropertyFile(String key) {
		String dataRead = null;
		Properties prop = new Properties();
		String rootDirectoryPath = System.getProperty("user.dir");
		String confiFilepath = rootDirectoryPath+"\\src\\test\\resources\\Config.properties";
		try {
			prop.load(new FileInputStream(confiFilepath));
			dataRead = prop.getProperty(key);
		} catch (Exception e) {
			System.out.println("Unable to find the specified file");
			e.printStackTrace();
		}
		return dataRead;
	}
	
}
