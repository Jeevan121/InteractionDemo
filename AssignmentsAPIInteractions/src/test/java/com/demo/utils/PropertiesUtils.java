package com.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtils {
	
	@SuppressWarnings("unused")
	  public static Properties initAutomatioProperties() {
	    Properties properties = null;
	    try {
	      final File file = new File(System.getProperty("user.dir") +File.separator+"Env_configs"+File.separator+"Automation.Properties");
	      if (file == null) {
	        throw new FileNotFoundException();
	      }
	      final FileInputStream fileInput = new FileInputStream(file);
	      properties = new Properties();
	      properties.load(fileInput);
	      fileInput.close();
	    } catch (final Exception e) {
	      e.printStackTrace();
	    }
	    return properties;
	  }

	  @SuppressWarnings("unused")
	  public static Properties initEnvironmentProperties() {
	    Properties properties = null;
	    try {
	      final File file = new File(System.getProperty("user.dir") +File.separator+"Environments"+File.separator
	          + initAutomatioProperties().getProperty("Environment") + ".Properties");
	      if (file == null) {
	        throw new FileNotFoundException();
	      }
	      final FileInputStream fileInput = new FileInputStream(file);
	      properties = new Properties();
	      properties.load(fileInput);
	      fileInput.close();
	    } catch (final Exception e) {
	      e.printStackTrace();
	    }
	    return properties;
	  }

}
