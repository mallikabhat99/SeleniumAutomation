package com.mb.learning;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started " + result.getTestName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed " + result.getTestName());

    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed " + result.getTestName());

    }
    @Override
    public void onTestSkipped(ITestResult result) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started " + context.getName());

    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finish" + context.getName());

        }
}
