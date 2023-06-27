package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        //open the browser nd launch browser
        openBrowser(baseurl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        String expectedMessage = "Dashboard";
        //element to enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //element to enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //element to click on login button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        //element to get message
        String actualMessage = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']").findElement(driver).getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @After
    public void tearDown(){
        //close all windows
        closeBrowser();
    }



}
