package homeTaskWebServices.tests;


import homeTaskPatterns.businessObjects.User;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestAssuredTest {
    @BeforeTest
    public  void initTest(){
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }
    @Test
    public void checkStatusCode(){
      Response response =  RestAssured.when()
              .get("/users")
              .andReturn();
        System.out.println(response.getStatusLine());
      Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void checkResponseHeader(){
        Response response = RestAssured.when()
                .get("/users")
                .andReturn();
      String rpContentTypeHeader = response.getHeader("Content-Type");
      Assert.assertEquals(rpContentTypeHeader, "application/json; charset=utf-8");
    }
    @Test
    public void checkResponseBody(){
        Response response = RestAssured.when()
                           .get("/users")
                           .andReturn();
       ResponseBody <?> responseBody = response.getBody();
       User[] users = responseBody.as(User[].class);
        System.out.println(users.length);
        Assert.assertEquals(users.length, 10);
    }
}
