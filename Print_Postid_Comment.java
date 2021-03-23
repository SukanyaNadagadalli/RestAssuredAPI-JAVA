import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class print_postid_comment {
	@Test
	public void idMessageBody()
	{
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
	RequestSpecification httpRequest = RestAssured.given();
	Scanner scan=new Scanner(System.in);
	System.out.println("enter id");
	int J=scan.nextInt();
	Response response = httpRequest.get("/"+J+"/comments");
	JsonPath jsonPath = response.jsonPath();
	ArrayList a = (ArrayList)jsonPath.get();
	
	System.out.println();
	System.out.println("*******************List Of POSTS*************");
	System.out.println();
	
	for(int i=0;i<a.size();i++)
	{
		System.out.println();
		LinkedHashMap l=(LinkedHashMap) a.get(i);
		System.out.println("POST ID: "+l.get("postId"));
		System.out.println("ID: "+l.get("id"));
		System.out.println("NAME: "+l.get("name"));
		System.out.println("EMAIL ID: "+l.get("email"));
		System.out.println("COMMENT: "+l.get("body"));
		System.out.println();
	}
	int n = response.getStatusCode();
	System.out.println("Status code is: "+n);
}
}
