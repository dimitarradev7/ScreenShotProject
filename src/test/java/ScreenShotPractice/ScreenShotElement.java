package ScreenShotPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by dimitarrad
 * on 2/8/2021
 */
public class ScreenShotElement {
    public static void main(String[] args) throws IOException {
        //set the location of chrome browser
        System.setProperty("webdriver.chrome.driver", "C://WebDriver//bin//chromedriver.exe");

        // Initialize browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to url
        driver.get("http://automationpractice.com/index.php");

        // Locate the element on the web page
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));

        // capture screenshot with getScreenshotAs() of the WebElement class
        File f = logo.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(f, new File("C:\\WebDriver\\logoScreeshot.png"));

        driver.close();


    }
}
