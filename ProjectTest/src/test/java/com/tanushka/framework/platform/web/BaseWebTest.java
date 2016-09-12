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


}
