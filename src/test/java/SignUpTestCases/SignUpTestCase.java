package SignUpTestCases;

import Base.BaseSteps;
import Pages.SignupPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTestCase extends BaseSteps {
    Faker faker=new Faker();
@Test
    public void TestSignup() throws InterruptedException {
    SignupPage signupPage= homePage.clickOnSignUpButtonLink();
    String fakeUsername=faker.name().username();
    String fakerPassword=faker.internet().password();
    signupPage.insertUsername(fakeUsername);
    signupPage.insertPassword(fakerPassword);
    signupPage.clickOnSignupButton();
    signupPage.waitForAlert();
    String actualResult=signupPage.getAlertText();
    signupPage.acceptAlert();
    String expectedResult="Sign up successful.";
    Assert.assertEquals(actualResult,expectedResult);
    Thread.sleep(1000);

}
}
