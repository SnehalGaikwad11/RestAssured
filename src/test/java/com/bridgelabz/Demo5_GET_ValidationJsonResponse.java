package com.bridgelabz;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo5_GET_ValidationJsonResponse {
	
	@Test
	public void GetValidateJsonResponse()
	{
	
	  //Specify base URL
			RestAssured.baseURI="http://192.168.0.51:8000/api";
			
			//Request Object
			RequestSpecification httpRequest=RestAssured.given();
			
			
			//Request Object
			Response response=httpRequest.request(Method.GET,"/user");
			
			
			//print response in console window
			String responseBody=response.getBody().asString();
			System.out.println("Response Body is: "  +responseBody);
			Assert.assertEquals(responseBody.contains("user"), true);
			
			
			
			
			 
			
}

}
