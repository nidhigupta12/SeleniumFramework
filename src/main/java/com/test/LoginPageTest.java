package com.test;



import com.utils.JSONDataProvider;
import com.variables.Global_VARS;
import com.drivers.CreateDriver;
import com.pageobjects.AppLoginWelcomePO;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class LoginPageTest {
    // local vars
    private AppLoginWelcomePO<WebElement> welcome = null;
    private static final String DATA_FILE = "login.json";

    // constructor
    public LoginPageTest() throws Exception {
    }

    // setup/teardown methods

    /**
     * suiteSetup method
     *
     * @param environment
     * @param context
     * @throws Exception
     */
    @Parameters({"environment"})
    @BeforeSuite(alwaysRun = true, enabled = true)
   /* protected void suiteSetup(@Optional(Global_VARS.ENVIRONMENT) String environment,
                              ITestContext context)
                              throws Exception {

        Global_VARS.DEF_ENVIRONMENT = System.getProperty("environment", environment);
        Global_VARS.SUITE_NAME = context.getSuite().getXmlSuite().getName();
    }*/

    /**
     * suiteTeardown method
     *
     * @throws Exception
     */
    @AfterSuite(alwaysRun = true, enabled = true)
    protected void suiteTeardown() throws Exception {
    }

    /**
     * testSetup method
     *
     * @param browser
     * @param platform
     * @param includePattern
     * @param excludePattern
     * @param ctxt
     * @throws Exception
     */
    @Parameters({"browser", "platform", "includePattern", "excludePattern"})
    @BeforeTest(alwaysRun = true, enabled = true)
    protected void testSetup(@Optional String browser,
    		@Optional String platform,
    		@Optional String includePattern,
    		@Optional String excludePattern,
                             ITestContext ctxt)
                             throws Exception {

        // data provider filters
        if ( includePattern != null ) {
            System.setProperty("includePattern", includePattern);
        }

        if ( excludePattern != null ) {
            System.setProperty("excludePattern", excludePattern);
        }

        // global variables
       // Global_VARS.DEF_BROWSER = System.getProperty("browser", browser);
       // Global_VARS.DEF_PLATFORM = System.getProperty("platform", platform);

        // create driver
        CreateDriver.getInstance().setDriver(browser,
                                             platform
                                             );
    }

    /**
     * testTeardown method
     *
     * @throws Exception
     */
    @AfterTest(alwaysRun = true, enabled = true)
    protected void testTeardown() throws Exception {
        // close driver
        CreateDriver.getInstance().closeDriver();
    }

    /**
     * testClassSetup method
     *
     * @param context
     * @throws Exception
     */
    
    
    
    @BeforeClass(alwaysRun = true, enabled = true)
    protected void testClassSetup(ITestContext context) throws Exception {
        // instantiate page object classes
        welcome = new AppLoginWelcomePO<WebElement>();

        // set datafile for data provider
        JSONDataProvider.dataFile = DATA_FILE;

        // load page
        welcome.loadPage(Global_VARS.TARGET_URL, Global_VARS.TIMEOUT_MINUTE);
    }

    /**
     * testClassTeardown method
     *
     * @param context
     * @throws Exception
     */
    @AfterClass(alwaysRun = true, enabled = true)
    protected void testClassTeardown(ITestContext context) throws Exception {
    }

    /**
     * testMethodSetup method
     *
     * @param result
     * @throws Exception
     */
    @BeforeMethod(alwaysRun = true, enabled = true)
    protected void testMethodSetup(ITestResult result) throws Exception {
    }

    /**
     * testMethodTeardown method
     *
     * @param result
     * @throws Exception
     */
    @AfterMethod(alwaysRun = true, enabled = true)
   protected void testMethodTeardown(ITestResult result) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();

     System.out.println("driver url"+driver.getCurrentUrl());
       
    }

    // test methods

    @Test(groups={"loginGroup"}, dataProvider="fetchData_JSON", dataProviderClass=JSONDataProvider.class, enabled=true)
    public void TestCase1_Login_Verify(String rowID,
                                   String description,
                                   JSONObject testData) throws Exception {

        
    	System.out.println("json data" +testData.get("username").toString());
        welcome.verifyLogin(testData.get("username").toString(), testData.get("password").toString());
    }

    
    @Test(groups={"loginGroup1"}, dataProvider="fetchData_JSON", dataProviderClass=JSONDataProvider.class, enabled=true)
    public void TestCase2_Login_Failed(String rowID,
                                   String description,
                                   JSONObject testData) throws Exception {

        
       
    }

    

}