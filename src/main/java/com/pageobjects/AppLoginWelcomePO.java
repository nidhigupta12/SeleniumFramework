package com.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.drivers.CreateDriver;
import com.utils.BrowserUtils;
import com.variables.Global_VARS;

import static org.testng.Assert.assertEquals;



public class AppLoginWelcomePO<M extends WebElement> extends AppLoginPO<M> {
    // local variables
    private static final String WELCOME_TITLE = "Welcome";

    // constructor
    public AppLoginWelcomePO() throws Exception {
        super();

        setTitle(WELCOME_TITLE);
    }

    @Override
	public void setTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * getTitle method to get page title
     *
     * @return String
     */
    @Override
    public String getTitle() {
        return this.pageTitle;
    }

   
}

