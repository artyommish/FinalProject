package finalProject.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

    //public static FirefoxDriver driver;

     public static ChromeDriver driver;


    public void startDriver() {
        String driverPath = "C:\\Users\\A\\IdeaProjects\\LectureProjectForQA2\\src\\test\\resources\\";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();

//        String driverPath = "C:\\Users\\A\\IdeaProjects\\LectureProjectForQA2\\src\\test\\resources\\";
//        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    public void open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }




}
