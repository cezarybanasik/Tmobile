package tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

public class ApiTest {
    @Test
    public void WeatherMessageBody() throws IOException, JSONException {


        RestAssured.baseURI = "http://api.nbp.pl/";
        RestAssured.basePath = "/api/exchangerates/tables/";
        Response response =
                when().

                        get("A").
                        then().
                        contentType(ContentType.JSON).log().all().
                        extract().response();


        String jsonAsString = response.asString();
        System.out.println(jsonAsString);

        int statusCode = response.getStatusCode();
        System.out.println("Status code " + statusCode);
        assertEquals(statusCode, HttpStatus.SC_OK);


        JSONArray jsonarray = new JSONArray(jsonAsString);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);

            JSONArray jsonarray2 = new JSONArray(jsonobject.getJSONArray("rates").toString());
            for (int j = 0; j < jsonarray2.length(); j++) {
                JSONObject jsonobject2 = jsonarray2.getJSONObject(j);

                String code = jsonobject2.getString("code");
                String mid = jsonobject2.getString("mid");
                String currency = jsonobject2.getString("currency");


                System.out.println("---------------- KURSY WALUT --------------------");
                System.out.println(code + " " + mid);


                if (code.equals("USD")) {
                    System.out.println("---------------- KURSY DLA SPECJALNEJ WALUTY USD --------------------");
                    System.out.println(code + " " + mid);

                }

                if (currency.equals("dolar amerykański")) {
                    System.out.println("---------------- KURSY DLA WALUTY DOLAR AMERYKAŃSKI --------------------");
                    System.out.println(currency + " " + mid);
                }

                if (Double.parseDouble(mid) > 5) {
                    System.out.println("---------------- KURSY POWYŻEJ WARTOSCI 5 --------------------");
                    System.out.println(code + " " + mid);
                }

                if (Double.parseDouble(mid) < 3) {
                    System.out.println("---------------- KURSY PONIŻEJ WARTOSCI 3 --------------------");
                    System.out.println(code + " " + mid);
                }
            }


        }
    }
}







