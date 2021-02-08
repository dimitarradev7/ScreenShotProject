package ScreenShotPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by dimitarrad
 * on 2/8/2021
 */
public class CreateHomePageScreenShot {
    public static void main(String[] args) {
        //set the location of chrome browser
        System.setProperty("webdriver.chrome.driver", "C://WebDriver//bin//chromedriver.exe");

        // Initialize browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to url
        driver.get("http://automationpractice.com/index.php");

        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\WebDriver\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //closing the webdriver
        driver.close();
    }
}
