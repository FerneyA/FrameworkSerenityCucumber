package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {

    public static String getScreenShot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "target/surefire-reports/reports/chrome/evidencia/CP001.png";
        File destination = new File(path);
        FileUtils.copyFile(src, destination);
        return path;
    }
}