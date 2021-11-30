package finalProject.pages;

import finalProject.base.TestBase;
import org.openqa.selenium.By;


public class LogInPage extends TestBase {


    private final By noRegEmail = By.xpath("(//input[@type='email'])[2]");
    private final By continueButton = By.xpath("//input[@value='Turpināt']");


    public void enterNoRegEmail(String email) {
        driver.findElement(noRegEmail).sendKeys(email);
    }

    public void setContinueButtonClick() {
        driver.findElement(continueButton).click();
    }

}
