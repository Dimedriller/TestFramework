package com.tanushka.framework.platform.android;

import com.tanushka.framework.platform.BaseTest;

import java.net.MalformedURLException;
import java.util.Map;

public abstract class BaseAndroidTest extends BaseTest<AndroidDevice> {
    protected AndroidDevice initializeDevice(Map<String, String> params) throws MalformedURLException {
        return new AndroidDevice();
    }

}
