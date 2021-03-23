import java.util.List;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class print_post_details {
	@Test
	public void MessageBody()
	{
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("/posts");
	 
	List<String> body = response.jsonPath().getList("body");
	for(int i=0;i<body.size();i++)
	{
		System.out.println("POST "+i+": \n"+body.get(i));
		System.out.println();
	}
	int n = response.getStatusCode();
	System.out.println("Status code is: "+n);
	}
}
