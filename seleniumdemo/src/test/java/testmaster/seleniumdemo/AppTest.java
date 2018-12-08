package testmaster.seleniumdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobject.loginpage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
    loginpage loginPage;
	@Before
	public void InitTest()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://member.lazada.vn/user/login");
		this.loginPage = new loginpage(this.driver);
	}
	
	@After
	public void CloseTest()
	{
		this.driver.close();
	}
	
	@Ignore
    @Test
    public void Check_Login_With_Blank_Values()
    {
    	loginPage.txtUserName.clear();
    	loginPage.txtPassword.clear();
    	loginPage.btnLogin.click();
    	
    	String userNameError = loginPage.lbUserNameError.getText();
    	String passwordError = loginPage.lbPasswordError.getText();
    	
    	Boolean result = userNameError.indexOf("can't leave this empty")!=-1;
    	assertTrue(result);
    	/*
    	assertEquals(userNameError, "You can't leave this empty.");
    	assertEquals(passwordError, "You can't leave this empty.");
    	*/
    }
    
    @Ignore
    @Test
    public void Check_login_with_valid_values()
    {
    	loginPage.txtUserName.clear();
    	loginPage.txtPassword.clear();
    	loginPage.btnLogin.click();
    	
    	loginPage.txtUserName.sendKeys("khanh.tx@live.com");
    	String userNameError = loginPage.lbUserNameError.getText();
    	assertEquals(userNameError, "");
    	
    	loginPage.txtUserName.sendKeys("123456abc");
    	String pwdError = loginPage.lbPasswordError.getText();
    	assertEquals(pwdError, "");
    	
    }
    
    @Test
    public void Check_login_with_account_not_existed(){
    	loginPage.txtUserName.sendKeys("khanh.tx999");
    	loginPage.txtPassword.sendKeys("abc123");
    	loginPage.btnLogin.click();
    	
    	assertTrue(loginPage.pnlNotifier.isDisplayed());
    	assertEquals(loginPage.lbNotification.getText(), "Please enter a valid phone number.");
    }
    
    
}
