package com.tanushka.framework.platform.ios;

import com.tanushka.framework.platform.BaseTest;

import java.net.MalformedURLException;
import java.util.Map;

public abstract class BaseIOSTest extends BaseTest<IOSDevice> {
    @Override
    protected IOSDevice initializeDevice(Map<String, String> params) throws MalformedURLException {
        return new IOSDevice();
    }
}
