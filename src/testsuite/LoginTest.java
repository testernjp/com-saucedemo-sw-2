package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find username and enter credential
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Find password and enter password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        // Find and click on login button
        driver.findElement(By.id("login-button")).click();
        // Verify the "PRODUCTS" text
        String expectedProductText = "Products";
        String actualProductText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedProductText, actualProductText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Find username and enter credential
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Find password and enter password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        // Find and click on login button
        driver.findElement(By.id("login-button")).click();
        // Verify the product list text
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(productCount,6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
