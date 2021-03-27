package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BasketPage {


    @FindBy(css = "[class*='styles__ProductName']>h2")
    private List<WebElement> productInBasket;
    public BasketPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    @Step("assertNameProductInBasket")
    public void assertNameProductInBasket() {
        WaitForElement.waitForVisibilityOfAllElements(productInBasket);
        System.out.println(productInBasket.get(0).getText());
        assertEquals(productInBasket.get(0).getText(), "Xiaomi Mi Watch Lite");

    }
}
