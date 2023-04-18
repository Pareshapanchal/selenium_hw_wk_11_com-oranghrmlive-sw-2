package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    //initialise base url link
    String baseUrl ="https://opensource-demo.orangehrmlive.com/";
    public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
    //public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){openBrowser(baseUrl,browser); }
    @Test
    //1. userSholdLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “Admin” username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //Enter “admin123 password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        //Verify the ‘Welcome’ text is display
        String acctualDisplay = driver.findElement(By.xpath("//h6[@class ='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        String expectedDisplay ="Dashboard";
        Assert.assertEquals("not match",acctualDisplay,expectedDisplay);
    }

    @After
    public void tearDown(){closeBrowser();}
}
