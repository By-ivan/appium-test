import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class Test
{
    public static void main(String... args) throws MalformedURLException
    {
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("commandTimeout", "300");
        caps.setCapability("safariIgnoreFraudWarning", "true");
        caps.setCapability("idleTimeout", "360");
        caps.setCapability("name", "Test");
        caps.setCapability("safariAllowPopups", "true");
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("deviceName", "iPhone Simulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("platformVersion", "10.3");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "Safari");
        RemoteWebDriver driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),
                caps);
        driver.get("http://m.bbc.com/sport/rugby-league/39829001");
        driver.findElement(By.xpath("//*[@id='sb-1']/span[1]/i")).click();
        driver.findElement(By.xpath("//*[@id='sb-1-panel']/ul/li[2]/a")).click();
        System.out.println("Never will be reached");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
