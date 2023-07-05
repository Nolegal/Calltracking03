package mytests;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.net.MalformedURLException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import java.util.ArrayList;




import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CallTracking extends  BaseClass{

    public CallTracking(){
        super();

    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();

        driver=null;
    }



    @Test(dataProvider = "testdata")
    public static void callTracking03(String name, String telephone) throws InterruptedException, IOException, ParseException,MalformedURLException, Exception{

       // System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");

     //   WebDriver driver=new ChromeDriver();


     //   driver.manage().window().maximize();
     //   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
     //   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     //   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


/*
         System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
*/
        //   Logger log= LogManager.getLogger();

        navigateToURL("https://calltracking.ru/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/nav[1]/div[2]/div[1]/button[1]/span[1]")).click();
       // driver.findElement(By.xpath("//span[contains(text(),'Посмотреть демо')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.className("demo_access_form")).findElement(By.id("first_step_name")).click();
        driver.findElement(By.className("demo_access_form")).findElement(By.id("first_step_name")).sendKeys("Тест");


        //driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/form[1]/input[7]")).click();
        // driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/form[1]/input[7]")).sendKeys("Тест");

        // driver.findElement(By.className("demo_access_form")).findElement(By.className("email_validation")).click();
        // driver.findElement(By.className("demo_access_form")).findElement(By.className("email_validation")).sendKeys("test@i.ua");

        driver.findElement(By.xpath("//body/div[@id='demoModal']/div[1]/div[1]/div[2]/form[1]/input[8]")).click();
        driver.findElement(By.xpath("//body/div[@id='demoModal']/div[1]/div[1]/div[2]/form[1]/input[8]")).sendKeys( "1111111111");
//7777777777
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[contains(text(),'Получить демо-доступ')]")).click();



        Thread.sleep(3000);

        /*
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(3000);
        */

        /*
        quest_phone4
        "quest_phone4":"+7 (555) 555-55-55"
        if (text3.contains("+7 (495) 357-05-96")) {
            System.out.println("number 3 is same");
        }

        else {
            System.out.println(text3+"calltracking is hucked");
        }

        */



    }

     public static void keys() throws Exception {
     //   System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");

       // WebDriver driver=new ChromeDriver();
        navigateToURL("https://calltracking.ru/usefull_scripts/last_form_data.php?token=7pLdXq0Ri9fZkTm6SoVnMl2NjYhAeWxP&json=1");
    }
    @Test public static void parsing() throws InterruptedException, IOException, ParseException,MalformedURLException {
        Logger log = LogManager.getLogger();
        JSONParser parser = new JSONParser();
        try {
            URL oracle = new URL("https://calltracking.ru/usefull_scripts/last_form_data.php?token=7pLdXq0Ri9fZkTm6SoVnMl2NjYhAeWxP&json=1"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));


            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONObject o = (JSONObject) parser.parse(inputLine);


                JSONObject tutorials = (JSONObject) o;


                String phone = (String) tutorials.get("quest_phone4");
                //System.out.println(phone);
                log.info(phone + "Если вы видите введеный номер то тест прошел успешно. Если нет, то прйдите тест заново");


            }


            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


/*
    @DataProvider(name="testdata")
    public Object[][] TestDataFeed() {

// Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object[][] calltrackingdata = new Object[1][2];

// Enter data to row 0 column 0
        calltrackingdata[0][0] = "Тест";
// Enter data to row 0 column 1
        calltrackingdata[0][1] = "1111111111";


        return calltrackingdata;
    }
*/
}

/*
 System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");

         WebDriver driver=new ChromeDriver();


         driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
*/