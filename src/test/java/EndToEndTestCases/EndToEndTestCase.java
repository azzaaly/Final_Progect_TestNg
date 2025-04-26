package EndToEndTestCases;

import Base.BaseSteps;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class EndToEndTestCase extends BaseSteps {
    @Test(priority = 1)
    public void TestLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickOnLoginPageLink();
        loginPage.enterUserName("Test_2025");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String actualResult="welcome "+loginPage.validateusername();
        String expectedResult="Welcome Test_2025";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

  @Test(priority = 2)
    public void TestProductOne() throws InterruptedException {
        ProductOnePage productOnePage=homePage.clickOnProductOne();
        productOnePage.clickOnAddToCartButton();
        productOnePage.waitForAlert();
        String actualResult = productOnePage.getTextAlert();
        productOnePage.acceptAlert();
        String expectedResult = "Product added.";
        Assert.assertEquals(actualResult,expectedResult);
        productOnePage.clickOnHomeButton();
    }
    @Test(priority = 3)
    public void TestProductTwo() throws InterruptedException {
      ProductTwoPage productTwoPage=homePage.clickToAddProductTwo();
        productTwoPage.ClickOnAddButton();
        productTwoPage.waitForAlert();
        String actualResult= productTwoPage.getTextAlert();
        productTwoPage.acceptAlert();
        String expectedResult="Product added.";
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test(priority = 4)
    public void TestCart() throws InterruptedException {
      CartPage cartPage= homePage.ClickOnCartPage();
        List<String> actualResultNames=cartPage.getProductNames();
        List<String>actualResultPrices=cartPage.getPrices();
        int actualTotal=cartPage.getTotalPrices();
        List<String>expectedResultNames= Arrays.asList("Nexus 6","Iphone 6 32gb");
        List<String>expectedResultPrices=Arrays.asList("650","790");
        int expectedTotal=cartPage.getTotalPrices();
        Assert.assertTrue(actualResultNames.containsAll(expectedResultNames));
        Assert.assertTrue(actualResultPrices.containsAll(expectedResultPrices));
        Assert.assertEquals(actualTotal,expectedTotal,"Total Price does not match expected");
        cartPage.clickPlaceOrderButton();
        cartPage.insert("Azza","egypt","cairo","123","10","2020");
        cartPage.ClickOnPurchaseBtn();
        String actualResult=cartPage.ValidateMessage();
        String expectedResult="Thank you for your purchase!";
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);



    }

}

