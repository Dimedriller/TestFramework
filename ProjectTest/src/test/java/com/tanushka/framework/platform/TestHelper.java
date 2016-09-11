package com.tanushka.framework.platform;

public class TestHelper {
    private final EventLogger mEventLogger;

    public TestHelper(BaseTest test) {
        this.mEventLogger = test.getEventLogger();
    }

    protected void logProblem(String message) {
        mEventLogger.logProblem(message);
    }

    protected void logStep(String message) {
        mEventLogger.logStep(message);
    }
}
