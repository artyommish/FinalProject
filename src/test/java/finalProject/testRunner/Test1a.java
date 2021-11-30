package finalProject.testRunner;


import finalProject.base.TestBase;
import finalProject.models.Customer;

import finalProject.pages.ItemPage;
import finalProject.pages.LogInPage;
import finalProject.pages.StartPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1a extends TestBase {

    StartPage startPage = new StartPage();
    ItemPage itemPage = new ItemPage();
    LogInPage logInPage = new LogInPage();
    Customer customer = new Customer();

    @Before

    public void setUp() {
        startDriver();
        driver.get("https://www.1a.lv/");
        driver.manage().window().maximize();

    }

    @After
    public void stopDriver() {
    driver.quit();
    }

    @Test
    public void itemBuyingTest() {

        startPage.acceptAllCookies();
        startPage.itemNameInput();
        startPage.setSubmitButtonClick();
        itemPage.setItemSelectionClick();
        itemPage.setAddItemClick();
        itemPage.setGoToBasketButtonClick();
        itemPage.nameAndPriceValidation();
        itemPage.setProceedToPaymentClick();
        logInPage.enterNoRegEmail(customer.getUserEmail1());
        logInPage.setContinueButtonClick();
        itemPage.setShipmentFieldClick();
        itemPage.setPickupPlaceClick();
        itemPage.enterCredentials(customer.getUserName(), customer.getUserSurname(), customer.getUserPhoneNum());
        itemPage.setSaveCredentialsClick();
        itemPage.setPaymentButtonClick();
        itemPage.setPaymentMethodClick();
        itemPage.nameSurnamePhonePriceValidation();


    }
}
