package data.provider;

import org.testng.annotations.DataProvider;

public class Data {


    @DataProvider(name="CurrencyProvider")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "USD", "dolar amerykański",5,3 },

                };

    }
}
