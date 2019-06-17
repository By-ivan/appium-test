import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class IeDriverRemote
{
    public static void main(String[] args) throws MalformedURLException
    {
        DesiredCapabilities  sauceLabsCapabilities = DesiredCapabilities.internetExplorer();
        sauceLabsCapabilities.setCapability("platformName", "Windows 10");
        sauceLabsCapabilities.setCapability("browserVersion", "11.285");
        sauceLabsCapabilities.setCapability("browserName", "internet explorer");
        //pass if run
//        sauceLabsCapabilities.setCapability("recordVideo", "true");
//        sauceLabsCapabilities.setCapability("recordScreenshots", "false");
//        sauceLabsCapabilities.setCapability("seleniumVersion", "3.12.0");

        //failed if run
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("recordVideo", "true");
        sauceOptions.put("recordScreenshots", "false");
        sauceOptions.put("seleniumVersion", "3.12.0");
        sauceLabsCapabilities.setCapability("sauce:options", sauceOptions);

        WebDriver driver =
                    new RemoteWebDriver(new URL("http://userName:apiKey@ondemand.saucelabs.com:80/wd/hub")
                                ,sauceLabsCapabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.URL.com");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.quit();
    }
}
