package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class NavigarionBarPage {

    @FindBy(css = "#ntmMainMenu>div:nth-of-type(1)>a")
    WebElement btnDevices;
    @FindBy(css = "[data-oneshop-redirection=\"atg_tel_menu\"]")
    WebElement btnPhone;

    public NavigarionBarPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }



    @Step("clickOnBtnDevices")
    public void clickOnBtnDevices() {
        WaitForElement.waitForClicableElements(btnDevices);
        btnDevices.click();
    }

    @Step("clickOnBtnPhone")
    public void clickOnBtnPhone() {
        WaitForElement.waitForClicableElements(btnPhone);
        btnPhone.click();
    }
}
