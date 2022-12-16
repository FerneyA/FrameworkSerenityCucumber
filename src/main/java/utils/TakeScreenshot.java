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
        String nameImage = System.currentTimeMillis() + ".png";
        String path = System.getProperty("user.dir") + "target/surefire-reports/reports/chrome/evidencia/" + nameImage;
        System.out.println("Path screenshot:: " + path);
        File destination = new File(path);
        FileUtils.copyFile(src, destination);
        return "evidencia/" + nameImage;
    }
}