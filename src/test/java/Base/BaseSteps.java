package Base;

import Pages.CartPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseSteps {
public WebDriver driver;
public HomePage homePage;
@BeforeClass
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();
    homePage=new HomePage(driver);
    driver.manage().window().maximize();
    driver.get("https://demoblaze.com/index.html");

}
@AfterClass
public void close(){
    driver.quit();
}


}
