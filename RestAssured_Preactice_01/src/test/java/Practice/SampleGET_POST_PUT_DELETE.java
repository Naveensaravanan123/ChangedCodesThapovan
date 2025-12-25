package Practice;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleGET_POST_PUT_DELETE {
	
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void GenerateReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/TestReport_"+System.currentTimeMillis()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("Api test started successfully");
	}
	
	@Test(priority=1)
	public void GET_StatusCode() {
		Response response = RestAssured.get("http://localhost:3000/users");		
		
		int actual_Statuscode = response.getStatusCode();
	    String statusLine = response.getStatusLine();
	    String prettyResponse = response.getBody().asPrettyString();
		
		System.out.println("Actual Status code : "+actual_Statuscode);
		
		if(actual_Statuscode==200) {
			test.pass("Expected status code received : "+actual_Statuscode );
	        test.pass("Status Line: " + statusLine);
	        test.pass("Response Body:\n" + prettyResponse);
		} else {
			test.fail("Actual status code received : "+actual_Statuscode);
	        test.fail("Status Line: " + statusLine);
	        test.fail("Response Body:\n" + prettyResponse);
	        
	        Assert.fail("API returned failure response");
		}	
	}
	
	@Test(priority=2)
	public void POST_StatusCode() {
	    RestAssured.baseURI = "http://localhost:3000/";
	    
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("id", "6");
	    jsonObject.put("first_name", "Arun");
	    jsonObject.put("last_name", "Babu");
	    jsonObject.put("email", "babu@gmail.com");
	    
	    Response response = RestAssured.given()
	    .header("Content-Type","application/json")
	    .body(jsonObject.toString())
	    .post("users");
	    
	    int actual_StatusCode = response.getStatusCode();
	    String statusLine = response.getStatusLine();
	    String responseBody = response.getBody().asPrettyString();
	    
	    if(actual_StatusCode==201) {
	    	test.pass("Expected status code received : "+actual_StatusCode);
	    	test.pass("Status Line : "+statusLine);
	    	test.pass("Response Body : "+responseBody);
	    }else {
	    	test.fail("Expected status code 201 : But got "+actual_StatusCode);
	    	test.fail("Status Line : "+statusLine);
	    	test.fail("Response Body : "+responseBody);
	    	
	    	Assert.fail("POST API failed with the status code : "+ actual_StatusCode);
	    }

	    
		
	}
	
	@AfterTest
	public void closereport() {
		extent.flush();
	}
	


}
