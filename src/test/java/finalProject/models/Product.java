package finalProject.models;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

@Getter
public class Product {
    private ChromeDriver driver;

    public Product(ChromeDriver driver) {this.driver=driver;}


    public void copyName(){
    String name = driver.findElement(By.cssSelector("h1.PlayStation 4 (PS4) spēle Activision Call of Duty: Vanguard")).getText();

    }
    private final String ProductName = "PlayStation 4 (PS4) spēle Activision Call of Duty: Vanguard";
    private final String ProductPrice = "69,49 €";
}
