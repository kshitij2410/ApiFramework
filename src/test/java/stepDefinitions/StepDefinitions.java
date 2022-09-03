package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class StepDefinitions extends Utils{
	static RequestSpecification res;
	static ResponseSpecification resspec;
	static Response response;
	static TestDataBuild data =new TestDataBuild();
	@Given("Add Place Payload")
	public void add_place_payload() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
			
		 res=given().spec(requestSpecification())
		.body(data.addPlacePayLoad());
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		 response =res.when().post("/maps/api/place/add/json").
				then().spec(resspec).extract().response();

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	    String resp=response.toString();
	    JsonPath js=new JsonPath(resp);
	    assertEquals(js.get(keyValue).toString(),Expectedvalue);
	}
	
	
}
