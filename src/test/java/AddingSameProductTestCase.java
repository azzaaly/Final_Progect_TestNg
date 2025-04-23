import Base.BaseSteps;
import Pages.CartPage;
import Pages.ProductOnePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingSameProductTestCase extends BaseSteps {
    @Test
    public void testAddingSameProductTwice() throws InterruptedException {
       ProductOnePage productOnePage= homePage.clickOnProductOne();
       productOnePage.clickOnAddToCartButton();
       productOnePage.waitForAlert();
       productOnePage.acceptAlert();
       productOnePage.clickOnAddToCartButton();
       productOnePage.waitForAlert();
       productOnePage.acceptAlert();
       CartPage cartPage= homePage.ClickOnCartPage();
       int actualResult=cartPage.countProductOccurrences("Nexus 6");
       int expectedResult=2;
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(1000);


    }
}
