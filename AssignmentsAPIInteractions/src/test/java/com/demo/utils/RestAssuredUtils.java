package com.demo.utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {
	Response response;
	public Response getRequest(String endPoint){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("q", "London,UK") 
                .queryParam("appid", "b1b15e88fa797225412429c1c50c122a1") 
                .get();
		return response;
	}

}
