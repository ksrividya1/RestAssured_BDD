package stepDefinitions;

import static io.restassured.RestAssured.given;
//import org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import pojo.LocationPOJO;
import pojo.POJOobjectClass;
import resources.Utils;
import resources.TestDataBuild;


public class StepDefinition extends Utils{
	
	RequestSpecification request;	
	ResponseSpecification response;
	Response respPayload;
	
	@Given("Add Place payload")
	public void add_place_payload() throws IOException{	
		

		request=given()
				.spec(requestSpecification())
				.body(TestDataBuild.addPlacePayload());
		
	}
	
	@When("user calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string) throws IOException{
	    
			
		respPayload=request.when()
		.post("maps/api/place/add/json")
		.then()
		.spec(responseSpecification())		
		.extract().response();
		
	}
	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(Integer statusCodeActual) {
	    assertEquals(respPayload.getStatusCode(), 200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		
		JsonPath path=new JsonPath(respPayload.asString());
		assertEquals(path.get(key).toString(),value);
		
		
	}

}
