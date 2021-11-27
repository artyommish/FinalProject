package finalProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInPage {
    private ChromeDriver driver;

    private final By noRegEmail = By.xpath("(//input[@type='email'])[2]");
    private final By continueButton = By.xpath("//input[@value='Turpināt']");

    public LogInPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void enterNoRegEmail(String email) {
        driver.findElement(noRegEmail).sendKeys(email);
    }

    public void setContinueButtonClick() {
        driver.findElement(continueButton).click();
    }

}
