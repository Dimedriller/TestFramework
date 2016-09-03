package com.tanushka.phonetest;

import java.net.MalformedURLException;

public abstract class BaseIOSTest extends BaseTest<IOSDevice> {
    @Override
    protected IOSDevice initializeDevice() throws MalformedURLException {
        return new IOSDevice();
    }
}
