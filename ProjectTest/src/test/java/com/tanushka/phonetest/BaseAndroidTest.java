package com.tanushka.phonetest;

import java.net.MalformedURLException;

public abstract class BaseAndroidTest extends BaseTest<AndroidDevice> {
    protected AndroidDevice initializeDevice() throws MalformedURLException {
        return new AndroidDevice();
    }

}
