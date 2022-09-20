package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Demo123 {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	  RequestSpecification req = RestAssured.given();
	  Response response = req.get();
	  System.out.println(response.asPrettyString());
	  System.out.println("new branch");
  }
}
