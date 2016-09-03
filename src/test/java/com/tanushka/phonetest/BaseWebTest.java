package com.tanushka.phonetest;

import java.net.MalformedURLException;

public abstract class BaseWebTest extends BaseTest<WebDevice> {
    protected WebDevice initializeDevice() throws MalformedURLException {
        return new WebDevice();
    }
}
