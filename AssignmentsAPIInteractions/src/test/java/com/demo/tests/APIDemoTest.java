package com.demo.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.utils.AutomationConstants;
import com.demo.utils.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;

public class APIDemoTest extends BaseTest{
	
	@Test
	public void demoRestAssured() throws IOException{
		
		//Reading the excel file column fields and storing as key array list
		ArrayList<String> keysLst = getExcelUtils().readExcelWithSpecificRow(0);
		
		//getting all the excel file row's values into the array list
		ArrayList<String> values1Lst = getExcelUtils().readExcelWithSpecificRow(1);
		ArrayList<String> values2Lst = getExcelUtils().readExcelWithSpecificRow(2);
		ArrayList<String> values3Lst = getExcelUtils().readExcelWithSpecificRow(3);
		
		// framing the hash map for the 1,2,3 row with keys and values list
		HashMap<String, String> firstRowMap = getExcelUtils().getFramedMap(keysLst, values1Lst);
		HashMap<String, String> secondRowMap = getExcelUtils().getFramedMap(keysLst, values2Lst);
		HashMap<String, String> thirdRowMap = getExcelUtils().getFramedMap(keysLst, values3Lst);
		
		//hitting to the server with rest assured
		Response res=getRestAssuredUtils().getRequest(AutomationConstants.apiEndPoint);
		
		//parsing the json response
		List<JsonNode> windNode=getJsonUtils().getJsonNodes(res.asString(),AutomationConstants.wind);
		List<JsonNode> mainNode=getJsonUtils().getJsonNodes(res.asString(),AutomationConstants.main);;
		
		//Getting the wind and deg nodes values in the list
		ArrayList<String> speedLst = getJsonUtils().getRespectiveNodeValuesInList(windNode,AutomationConstants.speed);
		ArrayList<String> degLst = getJsonUtils().getRespectiveNodeValuesInList(windNode,AutomationConstants.deg);
		
		String speedActual1stRow = speedLst.get(0);
		String speedExpected1stRow = firstRowMap.get(AutomationConstants.windSpeed);
		
		String  firstRowActualSpeed="Actual"+" "+AutomationConstants.speed+" is "+speedActual1stRow;
		String  firstRowExpectedSpeed="Expected"+" "+AutomationConstants.windSpeed+"is"+speedExpected1stRow;
		
		String speedActual2ndRow = speedLst.get(1);
		String speedExpected2ndRow = secondRowMap.get(AutomationConstants.windSpeed);
		
		String  secondRowActualSpeed="Actual"+" "+AutomationConstants.speed+" is "+speedActual2ndRow;
		String  secondRowExpectedSpeed="Expected"+" "+AutomationConstants.windSpeed+"is"+speedActual2ndRow;
		
		String speedActual3rdRow = speedLst.get(2);
		String speedExpected3rdRow = thirdRowMap.get(AutomationConstants.windSpeed);
		
		String  thirdRowActualSpeed="Actual"+" "+AutomationConstants.speed+" is "+speedActual3rdRow;
		String  thirdRowExpectedSpeed="Expected"+" "+AutomationConstants.windSpeed+"is"+speedExpected3rdRow;
		
		Assert.assertEquals(speedActual1stRow,speedExpected1stRow,"the actual wind speed is: "+speedActual1stRow+" is not matching with expected wind speed:"+speedExpected1stRow);
		Assert.assertEquals(speedActual2ndRow,speedExpected2ndRow,"the actual wind speed is: "+speedActual2ndRow+" is not matching with expected wind speed:"+speedExpected2ndRow);
		Assert.assertEquals(speedActual3rdRow,speedExpected3rdRow,"the actual wind speed is: "+speedActual3rdRow+" is not matching with expected wind speed:"+speedExpected3rdRow);
		
		String degActual1stRow = degLst.get(0);
		String degExpected1stRow = firstRowMap.get(AutomationConstants.windDeg);
		
		String  firstRowActualDeg="Actual"+" "+AutomationConstants.deg+" is "+degActual1stRow;
		String  firstRowExpectedDeg="Expected"+" "+AutomationConstants.deg+"is"+degExpected1stRow;
	
		
		String degActual2ndstRow = degLst.get(1);
		String degExpected2ndRow = secondRowMap.get(AutomationConstants.windDeg);
		
		String  secondRowActualDeg="Actual"+" "+AutomationConstants.deg+" is "+degActual2ndstRow;
		String  secondRowExpectedDeg="Expected"+" "+AutomationConstants.deg+"is"+degExpected2ndRow;
		
		String degActual3rdRow = degLst.get(2);
		String degExpected3rdRow = thirdRowMap.get(AutomationConstants.windDeg);
		
		String  thirdRowActualDeg="Actual"+" "+AutomationConstants.deg+" is "+degActual3rdRow;
		String  thirdRowExpectedDeg="Expected"+" "+AutomationConstants.deg+"is"+degExpected2ndRow;
		
		Assert.assertEquals(degActual1stRow,degExpected1stRow,"the actual wind deg is: "+degActual1stRow+" is not matching with expected wind deg:"+degExpected1stRow);
		Assert.assertEquals(degActual2ndstRow,degExpected2ndRow,"the actual wind deg is: "+degActual2ndstRow+" is not matching with expected wind deg:"+degExpected2ndRow);
		Assert.assertEquals(degActual3rdRow,degExpected3rdRow,"the actual wind deg is: "+degActual3rdRow+" is not matching with expected wind deg:"+degExpected3rdRow);

		
		ArrayList<String> tempLst = new ArrayList<String>();
		ArrayList<String> tempMinLst = new ArrayList<String>();
		ArrayList<String> tempMaxLst = new ArrayList<String>();
		ArrayList<String> pressureLst = new ArrayList<String>();

		
		tempLst.add(mainNode.get(0).get(AutomationConstants.temp).asText());
		tempLst.add(mainNode.get(2).get(AutomationConstants.temp).asText());
		tempLst.add(mainNode.get(4).get(AutomationConstants.temp).asText());
		

		String mainTempActual1stRow = tempLst.get(0);
		String mainTempExpected1stRow = firstRowMap.get(AutomationConstants.mainTemp);
		
		String  firstRowActualMainTemp="Actual"+" "+AutomationConstants.mainTemp+" is "+mainTempActual1stRow;
		String  firstRowExpectedMainTemp="Expected"+" "+AutomationConstants.mainTemp+"is"+mainTempExpected1stRow;
		
		String mainTempActual2ndtRow = tempLst.get(1);
		String mainTempExpected2ndRow = secondRowMap.get(AutomationConstants.mainTemp);
		
		String  secondRowActualMainTemp="Actual"+" "+AutomationConstants.mainTemp+" is "+mainTempActual2ndtRow;
		String  secondRowExpectedMainTemp="Expected"+" "+AutomationConstants.mainTemp+"is"+mainTempExpected2ndRow;
		
		String mainTempActual3rdRow = tempLst.get(2);
		String mainTempExpected3rdRow = thirdRowMap.get(AutomationConstants.mainTemp);
		
		String  thirdRowActualMainTemp="Actual"+" "+AutomationConstants.mainTemp+" is "+mainTempActual3rdRow;
		String  thirdRowExpectedMainTemp="Expected"+" "+AutomationConstants.mainTemp+"is"+mainTempExpected3rdRow;
		
		
		Assert.assertEquals(mainTempActual1stRow,mainTempExpected1stRow,"the actual main temp is: "+mainTempActual1stRow+" is not matching with expected main temp:"+mainTempExpected1stRow);
		Assert.assertEquals(mainTempActual2ndtRow,mainTempExpected2ndRow,"the actual main temp  is: "+mainTempActual2ndtRow+" is not matching with expected main temp :"+mainTempExpected2ndRow);
		Assert.assertEquals(mainTempActual3rdRow,mainTempExpected3rdRow,"the actual main temp  is: "+mainTempActual3rdRow+" is not matching with expected main temp :"+mainTempExpected3rdRow);

		
		tempMinLst.add(mainNode.get(0).get(AutomationConstants.temp_min).asText());
		tempMinLst.add(mainNode.get(2).get(AutomationConstants.temp_min).asText());
		tempMinLst.add(mainNode.get(4).get(AutomationConstants.temp_min).asText());
		
		String mainTempMinActual1stRow = tempMinLst.get(0);
		String mainTempMinExpected1stRow = firstRowMap.get(AutomationConstants.mainTempMin);
		
		String  firstRowActualTempMin="Actual"+" "+AutomationConstants.temp_min+" is "+mainTempMinActual1stRow;
		String  firstRowExpectedTempMin="Expected"+" "+AutomationConstants.temp_min+"is"+mainTempMinExpected1stRow;
		
		String mainTempMinActual2ndtRow = tempMinLst.get(1);
		String mainTempMinExpected2ndRow = secondRowMap.get(AutomationConstants.mainTempMin);
		
		String  secondRowActualTempMin="Actual"+" "+AutomationConstants.temp_min+" is "+mainTempMinActual2ndtRow;
		String  secondRowExpectedTempMin="Expected"+" "+AutomationConstants.temp_min+"is"+mainTempMinExpected2ndRow;
		
		String mainTempMinActual3rdRow = tempMinLst.get(2);
		String mainTempMinExpected3rdRow = thirdRowMap.get(AutomationConstants.mainTempMin);
		
		String  thirdRowActualTempMin="Actual"+" "+AutomationConstants.temp_min+" is "+mainTempMinActual3rdRow;
		String  thirdRowExpectedTempMin="Expected"+" "+AutomationConstants.temp_min+"is"+mainTempMinExpected3rdRow;
		
		Assert.assertEquals(mainTempMinActual1stRow,mainTempMinExpected1stRow,"the actual main temp min is: "+mainTempMinActual1stRow+" is not matching with expected main temp:"+mainTempMinExpected1stRow);
		Assert.assertEquals(mainTempMinActual2ndtRow,mainTempMinExpected2ndRow,"the actual main temp min is: "+mainTempMinActual2ndtRow+" is not matching with expected main temp :"+mainTempMinExpected2ndRow);
		Assert.assertEquals(mainTempMinActual3rdRow,mainTempMinExpected3rdRow,"the actual main temp min is: "+mainTempMinActual3rdRow+" is not matching with expected main temp :"+mainTempMinExpected3rdRow);

		
		tempMaxLst.add(mainNode.get(0).get(AutomationConstants.temp_max).asText());
		tempMaxLst.add(mainNode.get(2).get(AutomationConstants.temp_max).asText());
		tempMaxLst.add(mainNode.get(4).get(AutomationConstants.temp_max).asText());
		
		String mainTempMaxActual1stRow = tempMaxLst.get(0);
		String mainTempMaxExpected1stRow = firstRowMap.get(AutomationConstants.mainTempMax);
		
		String  firstRowActualTempMax="Actual"+" "+AutomationConstants.temp_max+" is "+mainTempMaxActual1stRow;
		String  firstRowExpectedTempMax="Expected"+" "+AutomationConstants.temp_max+" is "+mainTempMaxExpected1stRow;
		
		String mainTempMaxActual2ndtRow = tempMaxLst.get(1);
		String mainTempMaxExpected2ndRow = secondRowMap.get(AutomationConstants.mainTempMax);
		
		String  secondRowActualTempMax="Actual"+" "+AutomationConstants.temp_max+" is "+mainTempMaxActual2ndtRow;
		String  secondRowExpectedTempMax="Expected"+" "+AutomationConstants.temp_max+" is "+mainTempMaxExpected2ndRow;
		
		String mainTempMaxActual3rdRow = tempMaxLst.get(2);
		String mainTempMaxExpected3rdRow = thirdRowMap.get(AutomationConstants.mainTempMax);
		
		String  thirdRowActualTempMax="Actual"+" "+AutomationConstants.temp_max+" is "+mainTempMaxActual3rdRow;
		String  thirdRowExpectedTempMax="Expected"+" "+AutomationConstants.temp_max+" is "+mainTempMaxExpected3rdRow;
		
		Assert.assertEquals(mainTempMaxActual1stRow,mainTempMaxExpected1stRow,"the actual main temp max is: "+mainTempMaxActual1stRow+" is not matching with expected main temp:"+mainTempMaxExpected1stRow);
		Assert.assertEquals(mainTempMaxActual2ndtRow,mainTempMaxExpected2ndRow,"the actual main temp max is: "+mainTempMaxActual2ndtRow+" is not matching with expected main temp :"+mainTempMaxExpected2ndRow);
		Assert.assertEquals(mainTempMaxActual3rdRow,mainTempMaxExpected3rdRow,"the actual main temp max is: "+mainTempMaxActual3rdRow+" is not matching with expected main temp :"+mainTempMaxExpected3rdRow);
		
		pressureLst.add(mainNode.get(0).get(AutomationConstants.pressure).asText());
		pressureLst.add(mainNode.get(2).get(AutomationConstants.pressure).asText());
		pressureLst.add(mainNode.get(4).get(AutomationConstants.pressure).asText());
		
		String mainPressueActual1stRow = pressureLst.get(0);
		String mainPressureExpected1stRow = firstRowMap.get(AutomationConstants.mainPressure);
		
		String  firstRowActualPressure="Actual"+" "+AutomationConstants.pressure+" is "+mainPressueActual1stRow;
		String  firstRowExpectedPressure="Expected"+" "+AutomationConstants.pressure+" is "+mainPressureExpected1stRow;
		
		String mainPressureActual2ndtRow = pressureLst.get(1);
		String mainPressureExpected2ndRow = secondRowMap.get(AutomationConstants.mainPressure);
		
		String  secondRowActualPressure="Actual"+" "+AutomationConstants.pressure+" is "+mainPressureActual2ndtRow;
		String  secondRowExpectedPressure="Expected"+" "+AutomationConstants.pressure+" is "+mainPressureExpected2ndRow;
		
		String mainPressureActual3rdRow = pressureLst.get(2);
		String mainPressureExpected3rdRow = thirdRowMap.get(AutomationConstants.mainPressure);
		
		String  thirdRowActualPressure="Actual"+" "+AutomationConstants.pressure+" is "+mainPressureActual3rdRow;
		String  thirdRowExpectedPressure="Expected"+" "+AutomationConstants.pressure+" is "+mainPressureExpected3rdRow;
		
		Assert.assertEquals(mainPressueActual1stRow,mainPressureExpected1stRow,"the actual main pressure is: "+mainPressueActual1stRow+" is not matching with expected main temp:"+mainPressureExpected1stRow);
		Assert.assertEquals(mainPressureActual2ndtRow,mainPressureExpected2ndRow,"the actual main pressure is: "+mainPressureActual2ndtRow+" is not matching with expected main temp :"+mainPressureExpected2ndRow);
		Assert.assertEquals(mainPressureActual3rdRow,mainPressureExpected3rdRow,"the actual main pressure is: "+mainPressureActual3rdRow+" is not matching with expected main temp :"+mainPressureExpected3rdRow);
		
		Object[][] resultsData = {
                {firstRowActualSpeed,firstRowExpectedSpeed},
                {firstRowActualDeg, firstRowExpectedDeg},
                {firstRowActualMainTemp, firstRowExpectedMainTemp},
                {firstRowActualTempMin,firstRowExpectedTempMin},
                {firstRowActualTempMax, firstRowExpectedTempMax},
                {firstRowActualPressure,firstRowExpectedPressure},
                
                {secondRowActualSpeed,secondRowExpectedSpeed},
                {secondRowActualDeg, secondRowExpectedDeg},
                {secondRowActualMainTemp, secondRowExpectedMainTemp},
                {secondRowActualTempMin,secondRowExpectedTempMin},
                {secondRowActualTempMax, secondRowExpectedTempMax},
                {secondRowActualPressure,secondRowExpectedPressure},
                
                {thirdRowActualSpeed,thirdRowExpectedSpeed},
                {thirdRowActualDeg, thirdRowExpectedDeg},
                {thirdRowActualMainTemp, thirdRowExpectedMainTemp},
                {thirdRowActualTempMin,thirdRowExpectedTempMin},
                {thirdRowActualTempMax, thirdRowExpectedTempMax},
                {thirdRowActualPressure,thirdRowExpectedPressure},
          
                
        };
		String fileName = "output"+getRandomNumber();
		System.out.println("file name is::"+fileName);
		getExcelUtils().writeResultsIntoExcelFile(fileName,resultsData);
		
	}
}
