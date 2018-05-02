package com.variables;

import java.io.File;

/**
 * @author Carl Cocchiaro
 *
 * Global Variable Utility Class
 *
 */
public class Global_VARS {
    // browser defaults
    /*public static final String BROWSER = "chrome";
    public static final String PLATFORM = "Windows 10";
    public static final String ENVIRONMENT = "local";
    public static String DEF_BROWSER = null;
    public static String DEF_PLATFORM = null;
    public static String DEF_ENVIRONMENT = null;*/

    // suite folder defaults
   // public static String SUITE_NAME = null;
    public static final String TARGET_URL = "https://test.tri-mpronav.com/login/index";
    public static String propFile = "selenium.properties";
    public static final String SE_PROPS = new File(propFile).getAbsolutePath();
   

    // suite timeout defaults
    public static final int TIMEOUT_MINUTE = 60;
    public static final int TIMEOUT_ELEMENT = 10;
}
