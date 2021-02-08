package ScreenShotPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dimitarrad
 * on 2/8/2021
 */
public class CropScreenShot {
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

        // Get screenshot of the visible part of the web page
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Convert the screenshot into BufferedImage
        BufferedImage fullScreen = ImageIO.read(screenshot);

        //Find location of the webelement logo on the page
        Point location = logo.getLocation();

        //Find width and height of the located element logo
        int width = logo.getSize().getWidth()+300;
        int height = logo.getSize().getHeight()+300;

        //cropping the full image to get only the logo screenshot
        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(),
                width, height);
        ImageIO.write(logoImage, "png", screenshot);

        //Save cropped Image at destination location physically.
        FileUtils.copyFile(screenshot, new File("C:\\WebDriver\\particularElementScreenshot.PNG"));

        driver.quit();

    }
}
