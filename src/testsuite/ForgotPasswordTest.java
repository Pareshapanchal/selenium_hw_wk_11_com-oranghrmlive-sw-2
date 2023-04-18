package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    //initialise base url link
    String baseUrl ="https://opensource-demo.orangehrmlive.com/";
    // public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
    public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){openBrowser(baseUrl,browser); }

    //1. userShouldNavigateToForgotPasswordPageSuccessfully
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        // Verify the text ‘Forgot Your Password?’
        driver.findElement(By.xpath("//p[@class ='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
        // Verify the text ‘Reset Passsword’
        WebElement element1 =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));
        String acctualMessage = element1.getText();
        String expectedMessage ="Reset Password";
        Assert.assertEquals("Not Match",expectedMessage,acctualMessage);
    }
    @After
    public void tearDown(){closeBrowser();}
}
