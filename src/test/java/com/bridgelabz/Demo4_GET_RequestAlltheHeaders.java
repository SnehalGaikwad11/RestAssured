package com.bridgelabz;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//user/{id}
public class Demo4_GET_RequestAlltheHeaders {
	@Test
	public void GetAllHeaders()
	{
	
	  //Specify base URL
			RestAssured.baseURI="http://192.168.0.51:8000/api/user";
			
			//Request Object
			RequestSpecification httpRequest=RestAssured.given();
			
			
			//Request Object
			Response response=httpRequest.request(Method.GET,"/5d36d10eec93cd2a2532e7c2?access_token=49yjbmGW1nqTnjgdlDy5KHgO4AngHogkuZFFkuPFkhOlEeqml8n4owdxM6GMLjBP");
			
			
			//print response in console window
			String responseBody=response.getBody().asString();
			System.out.println("Response Body is: "  +responseBody);
			
			 
			Headers allheaders=response.headers();	//capture all the headers from response		
             for(Header headers:allheaders)
             {
            	 System.out.println(headers.getName()+"      "+headers.getValue() );
            	 
            	 
             }
}
}
