import Base.BaseSteps;
import Pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidSignUpTestCase extends BaseSteps {
    @Test
    public void TestInvalidSignUp() throws InterruptedException {
      SignupPage signupPage= homePage.clickOnSignUpButtonLink();
      signupPage.insertUsername("Test");
      signupPage.insertPassword("123456");
      signupPage.clickOnSignupButton();
      signupPage.waitForAlert();
      String actualResult=signupPage.getAlertText();
      signupPage.acceptAlert();
      String expectedResult="This user already exist.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);

    }
}
