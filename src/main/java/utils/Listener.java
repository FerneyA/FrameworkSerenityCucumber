package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.java.BaseTests;

import java.io.File;
import java.io.IOException;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String fileName = System.getProperty("user.dir") + File.separator +
                "screenshots" + File.separator + "passed" + File.separator +
                result.getMethod().getMethodName();
        File f = ((TakesScreenshot) BaseTests.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String fileName = System.getProperty("user.dir") + File.separator +
                "screenshots" + File.separator + "failed" + File.separator +
                result.getMethod().getMethodName();
        File f = ((TakesScreenshot)BaseTests.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
