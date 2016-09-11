package com.tanushka.framework.platform.android;

import com.tanushka.framework.platform.BaseTest;

import java.net.MalformedURLException;

public abstract class BaseAndroidTest extends BaseTest<AndroidDevice> {
    protected AndroidDevice initializeDevice() throws MalformedURLException {
        return new AndroidDevice();
    }

}
