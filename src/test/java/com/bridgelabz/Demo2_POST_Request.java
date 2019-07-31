package com.bridgelabz;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2_POST_Request {
	
	@Test
	void RegisterUserDeatils()
 
	{   //Specify base URL
		//RestAssured.baseURI="http://192.168.0.51:8000/api/user";
		RestAssured.baseURI="http://192.168.0.51:8000/api/user";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		
		//Request payload  sending  along  with post request
		JSONObject requestParams=new JSONObject();
//		requestParams.put("firstName", "pooja");
//		requestParams.put("lastName","patil");
//		requestParams.put("phoneNumber", "9960303782");
//		requestParams.put("service", "Advanced");
//		requestParams.put("username", "pooja");
//		requestParams.put("email", "poojapatil@gmail.com");
//		requestParams.put("password", "pooja1234");
//		requestParams.put("emailVerified", "true");
//		
		requestParams.put("email", "poojapatil@gmail.com");
		requestParams.put("password", "pooja1234");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString()); //attached  above data to request
		
		//Request Object
		//Response response=httpRequest.request(Method.POST,"/userSignUp");
		Response response=httpRequest.request(Method.POST,"/login");


		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:   "  +responseBody);
		 
		
		//Status code validation
		int statusCode=response.getStatusCode();
        System.out.println("Status Code is:  "  +statusCode);
        Assert.assertEquals(statusCode, 200);
        
   	//Success code validation
//       String successCode=response.jsonPath().get("SuccessCode");
//      Assert.assertEquals(successCode, "true");
     
        
    
	}
	
	

}
