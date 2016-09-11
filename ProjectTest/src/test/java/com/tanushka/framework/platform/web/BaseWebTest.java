package com.tanushka.framework.platform.web;



import com.tanushka.framework.platform.BaseTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Map;


public abstract class BaseWebTest extends BaseTest<WebDevice> {
    protected WebDevice initializeDevice(Map<String, String> params) throws MalformedURLException {
        String browser = params.get("browser");
        return new WebDevice(browser);
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
