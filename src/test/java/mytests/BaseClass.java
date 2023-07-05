package mytests;


import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    static WebDriver driver = null;
    public BaseClass(){
        driver = SingletonDriver.getSingletonInstance();
    }
    public static void navigateToURL(String URL){
        driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
        driver.navigate().to(URL);
    }

}