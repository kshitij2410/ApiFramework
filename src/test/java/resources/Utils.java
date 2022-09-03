package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException
	{
		PrintStream log =new PrintStream(new FileOutputStream("C:\\Users\\Mahesh\\eclipse-workspace\\My1APIFramework\\logging.txt"));
		RestAssured.baseURI="https://rahulshettyacademy.com";
		 req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))	
				 .setContentType(ContentType.JSON).build();
		return req;
	}
}
