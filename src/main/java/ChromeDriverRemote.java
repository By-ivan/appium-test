import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverRemote
{
    public static void main(String[] args) throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("commandTimeout", "360");
//        caps.setCapability("maxDuration", "300");
//        caps.setCapability("idleTimeout", "900");
        caps.setCapability("extendedDebugging", "true");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "CHROME");
        caps.setCapability("version", "latest");
//        caps.setCapability("seleniumVersion", "3.12");
//        caps.setCapability("screen-resolution", "1920x1200");
        caps.setCapability("recordVideo", "true");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 8");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        caps.merge(chromeOptions);

        WebDriver driver = new RemoteWebDriver(new URL("http://username:access_key@ondemand.saucelabs.com:80/wd/hub"), caps);
        driver.get("https://cleanandclear.com");
        driver.findElement(By.id("touch-menu")).click();
        driver.quit();
    }
}
