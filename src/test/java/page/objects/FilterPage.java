package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.Assert.assertEquals;

public class FilterPage {


    @FindBy(css = "[class*='styles__StyledFilterWrapper'] [data-qa=\"LST_FilterLabel\"]:nth-of-type(2)")
    WebElement btnChooseSmartwatch;

    @FindBy(css = "[class*='dt_selectWithLabel']")
    WebElement selectSortList;
    @FindBy(css = "[data-qa=\"option1\"]")
    WebElement chooseLowestPrice;
    @FindBy(css = "[class*='styles__StyledFooterActions']>button:nth-of-type(2)")
    WebElement btnConfirmFilter;

    @FindBy(css = "[class*=\"filtersApplied\"] [class*='labelText']")
    WebElement filtersApplied;
    @FindBy(css = "[class*=\"sortByFilter\"] [class*='selectedText']")
    WebElement filterSort;

    public FilterPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    @Step("chooseSmartwatchWithFilter")
    public void chooseSmartwatchWithFilter() {
        WaitForElement.waitForClicableElements(btnChooseSmartwatch);
        btnChooseSmartwatch.click();
    }
    @Step("selectSortList")
    public void selectSortList() {
        WaitForElement.waitForClicableElements(selectSortList);
        selectSortList.click();
    }
    @Step("chooseLowestPriceOption")
    public void chooseLowestPriceOption() {
        WaitForElement.waitForClicableElements(chooseLowestPrice);
        chooseLowestPrice.click();
    }
    @Step("clickOnButtonConfirmFilter")
    public void clickOnButtonConfirmFilter() {
        WaitForElement.waitForClicableElements(btnConfirmFilter);
        btnConfirmFilter.click();
    }

    @Step("chooseSmartwatchWithFilter")
    public void verifyFilterSort() {
        WaitForElement.waitForVisibilityElements(filterSort);
       assertEquals(filterSort.getText(),"Najniższa cena");
    }
    @Step("selectSortList")
    public void verifyFiltersApplied() {
        WaitForElement.waitForVisibilityElements(filtersApplied);
        assertEquals(filtersApplied.getText(),"Zegarki");

    }
}
