package com.tanushka.framework.platform.ios;

import com.tanushka.framework.platform.BaseTest;

import java.net.MalformedURLException;

public abstract class BaseIOSTest extends BaseTest<IOSDevice> {
    @Override
    protected IOSDevice initializeDevice() throws MalformedURLException {
        return new IOSDevice();
    }
}
