package com.tanushka.framework.platform;

import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class EventLogger {
    private final List<String> mProblemList = new ArrayList<String>();

    public void logProblem(String message) {
        mProblemList.add(message);
        Reporter.log(message);
    }

    public void logStep(String message) {
        Reporter.log(message);
    }

    public boolean hasProblems() {
        return mProblemList.size() > 0;
    }
}
