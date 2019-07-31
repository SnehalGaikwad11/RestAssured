package com.bridgelabz.DataDrivenTest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewUsers {

	
	@Test(dataProvider="empdataprovider")
	void PostNewUsers(String ename,String esal,String eage)
	{
		 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	     
		 
		 RequestSpecification httpRequest=RestAssured.given();
		 
		 
		 //Here we created data which we can send along with post request
		 JSONObject requestParams=new JSONObject();
		 
		 requestParams.put("name", ename);
		 requestParams.put("salary", esal);
		 requestParams.put("age", eage);
		 
		 
		 //Add header starting the request body is JSON
		 httpRequest.header("Content-Type","application/json");

		 //Add the Json to the body of the request
		 httpRequest.body(requestParams.toJSONString());
	     
		 
		 //POST Request
		 Response response=httpRequest.request(Method.POST,"/create ");
	     
		 
		 //capture response body to perform validations
		  String responseBody=response.getBody().asString();
		  
		  System.out.println("Employees Response Body is:"+responseBody);
	      
		 Assert.assertEquals(responseBody.contains(ename),true);
		 Assert.assertEquals(responseBody.contains(esal),true);
		 Assert.assertEquals(responseBody.contains(eage),true);

		  int statusCode=response.getStatusCode();
		  Assert.assertEquals(statusCode, 200 );
		  
		  }
	
	@DataProvider(name="empdataprovider")
	String[][] getEmpData() throws IOException
	{
		 
		//Read data from excel
	    String path="/home/userq/eclipse-workspace/RestAssuredApiTesting/src/test/java/com/bridgelabz/DataDrivenTest/data.xlsx";
		
	    
	    int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		
		//String empdata[][]= {{"Sneha","20000","22"},{"Adhya","45000","23"},{"Somya","56000","25"}};
		String empdata[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				empdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		
		
		return(empdata);
	}
}
