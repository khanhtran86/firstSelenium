package testmaster.seleniumdemo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import pageobject.loginpage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    
    @Test
    public void firstTestCase()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
    	driver= new ChromeDriver();
    	
    	driver.get("https://member.lazada.vn/user/login?spm=a2o4n.home.header.d5.19056afeWNz03N&redirect=https%3A%2F%2Fwww.lazada.vn%2F");
    	
    	//Nhap Username
    	loginpage lgPage = new loginpage(driver);
    	lgPage.txtUserName.sendKeys("khanh.tx@live.com");
    	
        assertTrue( true );
    }
}
