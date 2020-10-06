package com.demo.utils;

public class AutomationConstants {
	
	public static String apiEndPoint = PropertiesUtils.initEnvironmentProperties().getProperty("apiEndPoint");
	
	public static String windSpeed = "wind/speed";
	public static String windDeg = "wind/deg";
	public static String mainTemp = "main/temp";
	public static String mainTempMin = "main/temp_min";
	public static String mainTempMax = "main/temp_max";
	public static String mainPressure = "main/pressure";
	
	public static String wind = "wind";
	public static String main = "main";
	
	public static String speed = "speed";
	public static String deg = "deg";
	
	public static String temp = "temp";
	public static String temp_min = "temp_min";
	public static String temp_max = "temp_max";
	public static String pressure = "pressure";
	
	public static String actual="Actual";
	public static String Expected="Expected";
	
}
