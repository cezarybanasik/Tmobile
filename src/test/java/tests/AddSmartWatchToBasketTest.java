package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;
import utils.testng.listeners.RetryAnalyzer;

import static navigation.ApplicationURLs.APPLICATION_URL;


public class AddSmartWatchToBasketTest extends TestBase {


    @Test(priority = 1,
            description = "asUserTryAddSmartwatchToBasket",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTrySendingPackageTest() {

        DriverUtils.navigateToPage(APPLICATION_URL);

        NavigarionBarPage navigation = new NavigarionBarPage();
        navigation.clickOnBtnDevices();
        navigation.clickOnBtnPhone();
        MainPage mainPage = new MainPage();
        mainPage.clickBtnFilter();
        FilterPage filter = new FilterPage();
        filter.chooseSmartwatchWithFilter();
        filter.clickOnButtonConfirmFilter();
        mainPage.clickBtnFilter();
        filter.selectSortList();
        filter.chooseLowestPriceOption();
        filter.clickOnButtonConfirmFilter();
        mainPage.clickBtnFilter();
        filter.verifyFiltersApplied();
        filter.verifyFilterSort();
        filter.clickOnButtonConfirmFilter();
        mainPage.clickOnFirstElementWithList();
        mainPage.clickOnAcceptCookies();
        mainPage.clickOnAddElementToBasket();
        BasketPage basket = new BasketPage();
        basket.assertNameProductInBasket();


    }


}
