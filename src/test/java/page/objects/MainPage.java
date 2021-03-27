package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MainPage {



    @FindBy(className = "filter")
    WebElement btnFilter;

    @FindBy(css = "[class='primaryLink']")
    private List<WebElement> lnkFirstElement;
    @FindBy(css = "[class*=\"styles__StyledProductCardVertical\"]")
    private List<WebElement> btnShowDetails;
    @FindBy(css = "[class='buttonWrap']>button")
    WebElement btnAddToBasket;
    @FindBy(css = "[class*='acceptcookies']")
    WebElement btnAcceptCookies;


    public MainPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }



    @Step("clickBtnFilter")
    public void clickBtnFilter() {
        WaitForElement.waitForClicableElements(btnFilter);
        btnFilter.click();
    }


    @Step("clickOnFirstElementWithList")
    public void clickOnFirstElementWithList() {


        try {
            WaitForElement.waitForVisibilityOfAllElements(lnkFirstElement);
            Actions actions=new Actions( DriverManager.getWebDriver());
            actions.moveToElement(btnShowDetails.get(0)).click().build().perform();

        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WaitForElement.waitForVisibilityOfAllElements(lnkFirstElement);
            Actions actions=new Actions( DriverManager.getWebDriver());
            actions.moveToElement(btnShowDetails.get(0)).click().build().perform();

        }
    }
    @Step("clickOnAddElementToBasket")
    public void clickOnAddElementToBasket() {
        WaitForElement.waitForClicableElements(btnAddToBasket);
        btnAddToBasket.click();
    }
    @Step("clickOnAcceptCookies")
    public void clickOnAcceptCookies() {
        WaitForElement.waitForClicableElements(btnAcceptCookies);
        Actions actions=new Actions(DriverManager.getWebDriver());
        actions.moveToElement(btnAcceptCookies).click().build().perform();
    }

}
