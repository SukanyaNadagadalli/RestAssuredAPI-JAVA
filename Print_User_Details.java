import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class print_user_details {
	@Test
	
	public void Getdetails()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users");
		JsonPath jsonPath = response.jsonPath();
		ArrayList a = (ArrayList)jsonPath.get();
		System.out.println();
		System.out.println("*******************List Of Users*************");
		System.out.println();
		
		for(int i=0;i<a.size();i++)
		{
			LinkedHashMap l=(LinkedHashMap) a.get(i);
			System.out.println("USER ID: "+l.get("id"));
			System.out.println("NAME: "+l.get("name"));
			System.out.println("USERNAME: "+l.get("username"));
			System.out.println("EMAIL: "+l.get("email"));
			System.out.println("PHONE NUMBER: "+l.get("phone"));
			System.out.println("WEBSITE: "+l.get("website"));
			LinkedHashMap la=(LinkedHashMap) l.get("address");
			System.out.println("STREET: "+la.get("street"));
			System.out.println("SUITE: "+la.get("suite"));
			System.out.println("CITY: "+la.get("city"));
			System.out.println("ZIPCODE: "+la.get("zipcode"));
			LinkedHashMap lc=(LinkedHashMap) l.get("company");
			System.out.println("COMPANY NAME: "+lc.get("name"));
			System.out.println("CATCH PHRASE: "+lc.get("catchPhrase"));
			System.out.println("BS: "+lc.get("bs"));
			System.out.println();
			System.out.println();
			
			
		}
		
		int n = response.getStatusCode();
		System.out.println("Status code is: "+n);
	}
//	public static void getResponseBody(){
//		   given();
//		RestAssured.when().get("https://jsonplaceholder.typicode.com/users").then().log().body();
//		 
//		}
//
//	private static RestAssured given() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
