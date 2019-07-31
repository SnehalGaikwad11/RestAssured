package com.bridgelabz;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_Request {
	
	@Test
	void getUserDeatils()
 
	{   //Specify base URL
		RestAssured.baseURI="http://192.168.0.51:8000/api";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"/user");
		
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:   "  +responseBody);
		 
		
		//Status code validation
		int statusCode=response.getStatusCode();
        System.out.println("Status Code is:  "  +statusCode);
        Assert.assertEquals(statusCode, 200);
        
        
      //Status Line validation
        String statusLine=response.getStatusLine();
        System.out.println("Status Line is: "+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	

}
