package tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void WeatherMessageBody()
    {



        RestAssured.baseURI = "http://api.nbp.pl/";
        RestAssured.basePath = "/api/exchangerates/tables/";
        Response response =
                when().
                        get("A").
                        then().
                        contentType(ContentType.JSON).
                        extract().response();

        String jsonAsString = response.asString();
        System.out.println(jsonAsString);

        int statusCode = response.getStatusCode();
        System.out.println("Status code "+ statusCode);
        assertEquals(statusCode, HttpStatus.SC_OK);
    }


}
