package finalProject.pages;


import finalProject.models.Customer;
import finalProject.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.assertj.core.api.Assertions.assertThat;

public class ItemPage {
    private ChromeDriver driver;
    Product product = new Product(this.driver);
    Customer customer = new Customer();


    private final By itemSelection = By.xpath("(//a[@class='ks-new-product-name'])[1]");
    private final By addItem = By.id("add_to_cart_btn");
    private final By goToBasketButton = By.xpath("//a[@class='main-button']");
    private final By proceedToPayment = By.xpath("//input[@value='Veikt apmaksu']");
    private final By shipmentField = By.xpath("//input[@value='2']");
    private final By pickupPlace = By.xpath("(//div[@class='pickup-point-name'])[1]");
    private final By nameField = By.id("address_first_name");
    private final By surnameField = By.id("address_last_name");
    private final By phoneNumberField = By.id("address_phone_number");
    private final By saveCredentials = By.xpath("(//button[@type='submit'])[1]");
    private final By paymentButton = By.xpath("(//button[@type='submit'])[2]");
    private final By paymentMethod = By.id("payment_unused_22");

    public ItemPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public void setItemSelectionClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        wait.until(ExpectedConditions.elementToBeClickable(itemSelection));
        driver.findElement(itemSelection).click();
    }

    public void setAddItemClick() {

        driver.findElement(addItem).click();
    }

    public void setGoToBasketButtonClick() {


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(goToBasketButton));
        driver.findElement(goToBasketButton).click();
    }

    public void nameAndPriceValidation() {
        String actualName = driver.findElement(By.xpath("//p[@class='detailed-cart-item__name']")).getText();
        String expectedName = (product.getProductName());
        assertThat(actualName).isEqualTo(expectedName);
        String actualPrice = driver.findElement(By.xpath("//p[@class='detailed-cart-item__price']")).getText();
        String expectedPrice = (product.getProductPrice());
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }

    public void setProceedToPaymentClick() {

        driver.findElement(proceedToPayment).click();
    }

    public void setShipmentFieldClick() {
        driver.findElement(shipmentField).click();
    }


    public void setPickupPlaceClick() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='plainoverlay']"))));


        wait.until(ExpectedConditions.elementToBeClickable(pickupPlace));
        driver.findElement(pickupPlace).click();
    }


    public void enterCredentials(String name, String surname, String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000);");
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);

    }

    public void setSaveCredentialsClick() {
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000);");
        actions.moveToElement(driver.findElement(saveCredentials));
        wait.until(ExpectedConditions.elementToBeClickable(saveCredentials));

       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(saveCredentials));

    }

    public void setPaymentButtonClick() {
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        actions.moveToElement(driver.findElement(saveCredentials));
        wait.until(ExpectedConditions.elementToBeClickable(paymentButton));

       ((JavascriptExecutor) driver).executeScript("arguments[0].submit();", driver.findElement(By.xpath("(//form[@class='default-form'])[1]")));


    }

    public void setPaymentMethodClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        driver.findElement(paymentMethod).click();
    }


    public void nameSurnamePhonePriceValidation() {



        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='name']")));

        String actualNameAndSurname = driver.findElement(By.xpath("//div[@class='name']")).getText();
        assertThat(actualNameAndSurname).isEqualTo(customer.getNameAndSurname());

        String actualPhoneNumber = driver.findElement(By.xpath("//div[@class='address']")).getText();
        assertThat(actualPhoneNumber.substring(0, 8)).isEqualTo(customer.getUserPhoneNum());

        String actualPrice = driver.findElement(By.xpath("//span[@class='checkout-order-summary-total__price']")).getText();
        assertThat(actualPrice).isEqualTo(product.getProductPrice());
    }
}
