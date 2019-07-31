package com.bridgelabz;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo6_GET_Authorization {

@Test	
public void AutherizationTest()
{
	//Specify base URL
	RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	
	//Basic Authentication
	PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
	authscheme.setUserName("ToolsQA");
	authscheme.setPassword("TestPassword");
	
	RestAssured.authentication=authscheme;
	

	//Request Object
	RequestSpecification httpRequest=RestAssured.given();
	
	//Response Object
	Response response=httpRequest.request(Method.GET,"/");
	
	
	  //print response in console window
	String responseBody=response.getBody().asString();
	System.out.println("Response Body is: "  +responseBody);
	
	
	//Status code validation
			int statusCode=response.getStatusCode();
	        System.out.println("Status Code is:  "  +statusCode);
	        Assert.assertEquals(statusCode, 200);
	        
	        
	      
	        
	    
	
}

}
