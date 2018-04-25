
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.drivers.CreateDriver;
import com.utils.BrowserUtils;
import com.variables.Global_VARS;

import static org.testng.Assert.assertEquals;

/* This is the base page object class */

public abstract class AppLoginPO<M extends WebElement> {
    // local variables
    protected String pageTitle = "";

    // constructor
    public AppLoginPO() throws Exception {
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);
    }

    // elements
    WebDriver driver;
    @FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
		
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement login;

    // abstract methods
	
    protected abstract void setTitle(String pageTitle);
    protected abstract String getTitle();

	//Set user name in textbox
		public void setUserName(String strUserName){
			username.sendKeys(strUserName);
			
		}
		
		//Set password in password textbox
		public void setPassword(String strPassword){
		password.sendKeys(strPassword);
		}
		
		//Click on login button
		public void clickLogin(){
				login.click();
		}

		
    /**
     * loadPage method to navigate to Target URL
     *
     * @param url
     * @param timeout
     * @throws Exception
     */
    public void loadPage(String url, int timeout) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        driver.navigate().to(url);

        // wait for page URL
        BrowserUtils.waitForURL(Global_VARS.TARGET_URL, timeout);
    }

    
    
    
    /**
     * verifyLogin method to verify login credentials
     *
     * @param pattern
     * @param text
     * @throws AssertionError
     */
    public void verifyLogin(String username, String password) throws AssertionError {
      

      //Fill user name
      		this.setUserName(username);
      		//Fill password
      		this.setPassword(password);
      		//Click Login button
      		this.clickLogin();	
				
		//assertEquals(actual, expected);(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }

    
 

}
