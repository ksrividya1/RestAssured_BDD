package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	RequestSpecification req;
	ResponseSpecification response;
	PrintStream logReq;
	PrintStream logRes;

	public RequestSpecification requestSpecification() throws IOException {
		
		logReq=new PrintStream(new FileOutputStream("ReqLogs.txt"));
		logRes=new PrintStream(new FileOutputStream("ResLogs.txt"));
		
		
		req=new RequestSpecBuilder()
				.setBaseUri(getGlobalPropertyValue("baseUrl"))				
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(logReq))
				//.addFilter(ResponseLoggingFilter.logResponseTo(logRes))
				.setContentType(ContentType.JSON)
				.build();
		
		return req;
		
	}
	
	public ResponseSpecification responseSpecification() {
		response=new ResponseSpecBuilder()				
				.expectContentType(ContentType.JSON)				
				.build();
		
		return response;
	}
	
	public String getGlobalPropertyValue(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\kotip\\study\\Testing-workspace\\RestAssured\\BDD_API_Framework\\src\\test\\java\\resources\\global.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
	
}
