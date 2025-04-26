import Base.BaseSteps;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTestCase extends BaseSteps {
    @Test
    public void TestInvalidLogin() throws InterruptedException {
     LoginPage loginPage= homePage.clickOnLoginPageLink();
     loginPage.enterUserName("a321");
     loginPage.enterPassword("54321");
     loginPage.clickOnLoginButton();
     loginPage.waitForAlert();
     String actualResult=loginPage.getMessageAlert();
     String expectedResult="User does not exist.";
     Assert.assertTrue(actualResult.contains(expectedResult));
     Thread.sleep(1000);


    }
}
