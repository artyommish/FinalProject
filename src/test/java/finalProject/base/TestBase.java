package finalProject.base;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

    //public static FirefoxDriver driver;

     public ChromeDriver driver;

    @Before
    public void startDriver() {
        String driverPath = "C:\\Users\\A\\IdeaProjects\\LectureProjectForQA2\\src\\test\\resources\\";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
//        String driverPath = "C:\\Users\\A\\IdeaProjects\\LectureProjectForQA2\\src\\test\\resources\\";
//        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
//        driver = new FirefoxDriver();
    }



    //@After
    //public void stopDriver() {
        //driver.quit();
    //}
}
