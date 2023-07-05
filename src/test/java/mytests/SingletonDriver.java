package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonDriver {
    private static WebDriver driver;

    private SingletonDriver() {}

    public static WebDriver getSingletonInstance() {
        if (null == driver) {
         //  System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");
         //    driver = new ChromeDriver();

            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver= new ChromeDriver(options);


        }
        return driver;
    }



}
