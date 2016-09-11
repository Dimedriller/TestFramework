package com.tanushka.framework.platform.web;



import com.tanushka.framework.platform.BaseTest;

import java.net.MalformedURLException;


public abstract class BaseWebTest extends BaseTest<WebDevice> {
    protected WebDevice initializeDevice() throws MalformedURLException {

        return new WebDevice();
    }

    /*@Parameters({"platform", "browser", "version", "url"})

    @BeforeTest(alwaysRun = true)
    public void setup(String platform, String browser, String
            version,
                      String url) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
// Platforms
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            caps.setPlatform(org.openqa.selenium.Platform.MAC);
        }

// Browsers
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            caps = DesiredCapabilities.internetExplorer();
        }
        if (browser.equalsIgnoreCase("Firefox")) {
            caps = DesiredCapabilities.firefox();
        }
        if (browser.equalsIgnoreCase("Chrome")) {
            caps = DesiredCapabilities.chrome();
        }
        if (browser.equalsIgnoreCase("Safari")) {
            caps = DesiredCapabilities.safari();
        }
// Version
        caps.setVersion(version);
    }*/
}
