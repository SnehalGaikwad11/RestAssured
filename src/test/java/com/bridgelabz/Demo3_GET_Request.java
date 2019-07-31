package com.bridgelabz;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//user/{id}
public class Demo3_GET_Request {
	
	@Test
	void getHedersDeatils()
 
	{   //Specify base URL
		RestAssured.baseURI="http://192.168.0.51:8000/api/user";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		
		//Request Object
		Response response=httpRequest.request(Method.GET,"/5d36d10eec93cd2a2532e7c2?access_token=49yjbmGW1nqTnjgdlDy5KHgO4AngHogkuZFFkuPFkhOlEeqml8n4owdxM6GMLjBP");
		
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "  +responseBody);
		 
		
		//validating headers
		 String contentType=response.header("Content-Type"); //capture details of content-Type header
		 System.out.println("Content Type is:"+contentType);
		 Assert.assertEquals(contentType, "application/json; charset=utf-8");
		 
//		//validating headers
		 String connection=response.header("Connection"); //capture details of connection header
		 System.out.println(" Connection is:"+connection);
		 Assert.assertEquals(connection, "keep-alive");
	}
	

	

}
