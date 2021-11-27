package finalProject.testRunner;


import finalProject.base.TestBase;
import finalProject.models.Customer;
import finalProject.pages.ItemPage;
import finalProject.pages.StartPage;
import org.junit.Test;

public class Test1a extends TestBase  {
    @Test
    public void itemBuyingTest() {
        StartPage startPage = new StartPage(this.driver);
        ItemPage itemPage = new ItemPage(this.driver);
        Customer customer = new Customer();

        startPage.openStartPage();
        startPage.acceptAllCookies();
        startPage.itemNameInput();
        startPage.setSubmitButtonClick();
        itemPage.setItemSelectionClick();
        itemPage.setAddItemClick();
        itemPage.setGoToBasketButtonClick();
        itemPage.nameAndPriceValidation();
        itemPage.setProceedToPaymentClick();
        itemPage.enterNoRegEmail(customer.getUserEmail1());
        itemPage.setContinueButtonClick();
        itemPage.setShipmentFieldClick();
        itemPage.setPickupPlaceClick();
        itemPage.enterCredentials(customer.getUserName(), customer.getUserSurname(), customer.getUserPhoneNum());
        itemPage.setSaveCredentialsClick();
        itemPage.setPaymentButtonClick();
        itemPage.setPaymentMethodClick();
        itemPage.nameSurnamePhonePriceValidation();


    }
}
