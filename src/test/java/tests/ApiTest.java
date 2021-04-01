package tests;


import data.provider.Data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

public class ApiTest {
    @Test(dataProvider="CurrencyProvider",dataProviderClass= Data.class)
    public void CurrencyTest(String codeValue, String currencyValue, int valueMin, int valueMax) throws  JSONException {


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


                if (code.equals(codeValue)) {
                    System.out.println("---------------- KURSY DLA SPECJALNEJ WALUTY " +codeValue+ " --------------------");
                    System.out.println(code + " " + mid);

                }

                if (currency.equals(currencyValue)) {
                    System.out.println("---------------- KURSY DLA WALUTY "+currencyValue+ " --------------------");
                    System.out.println(currency + " " + mid);
                }

                if (Double.parseDouble(mid) > valueMin) {
                    System.out.println("---------------- KURSY POWYŻEJ WARTOSCI " +valueMin+ " --------------------");
                    System.out.println(code + " " + mid);
                }

                if (Double.parseDouble(mid) < valueMax) {
                    System.out.println("---------------- KURSY PONIŻEJ WARTOSCI " +valueMax+ " --------------------");
                    System.out.println(code + " " + mid);
                }
            }


        }
    }
}







