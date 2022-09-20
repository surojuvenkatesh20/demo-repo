package demo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.read.biff.BiffException;
import utilities.ExcelCommon;
public class DemoPost {
  @Test
  public void f() throws BiffException, IOException {
	  ExcelCommon c = new ExcelCommon();
	  Cell c1 =  c.getsheet().getCell(1, 0);
	  String baseURI =  c1.getContents();
	  RestAssured.baseURI = baseURI;
	  Cell c2 =  c.getsheet().getCell(1, 1);
	  String name =  c2.getContents();
	  Cell c3 =  c.getsheet().getCell(1, 2);
	  String job =  c3.getContents();
	  Cell c4 =  c.getsheet().getCell(1, 3);
	  String endpoint =  c4.getContents();
	  RequestSpecification req = RestAssured.given();
	  String jsonString = "{\n"
	  		+ "    \"name\": \"" + name + "\",\n"
	  		+ "    \"job\": \"" + job + "\"\n"
	  		+ "}";
	  req.contentType(ContentType.JSON);
	  req.body(jsonString);
	  Response response  = req.post(endpoint);
	  System.out.println(response.asPrettyString());
	  System.out.println(response.getStatusCode());
	  if(response.getStatusCode() == 201)
	  {
		  c.writeExcel(2, 0, "passed");
	  }
	  else
	  {
		  c.writeExcel(2, 0, "failed");
	  }
  }
}
