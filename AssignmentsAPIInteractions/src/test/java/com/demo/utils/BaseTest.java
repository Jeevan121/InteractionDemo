package com.demo.utils;

import java.util.Random;

public class BaseTest {
	
	RestAssuredUtils restAssuredUtlis;
	JsonUtils jsonUtils;
	ExcelUtils excelUtils;
	
	public RestAssuredUtils getRestAssuredUtils(){
		if(restAssuredUtlis==null){
			restAssuredUtlis = new RestAssuredUtils();
		}
		return restAssuredUtlis;
	}
	
	public JsonUtils getJsonUtils(){
		if(jsonUtils==null){
			jsonUtils = new JsonUtils();
		}
		return jsonUtils;
	}
	
	public ExcelUtils getExcelUtils(){
		if(excelUtils==null){
			excelUtils = new ExcelUtils();
		}
		return excelUtils;
	}
	
	public int getRandomNumber(){
		  Random rand = new Random(); 
		  // Generate random integers in range 0 to 999 
	      int rand_int1 = rand.nextInt(1000);
	      return rand_int1;
	}
	
	
}
