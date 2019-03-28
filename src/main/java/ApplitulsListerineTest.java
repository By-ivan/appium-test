import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplitulsListerineTest
{
    private static final String APPLITOOLS_API_KEY = "key";
    private static final String APPLITOOLS_SERVER_URL = "url";

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Repos\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Eyes eyes = new Eyes();
        eyes.setApiKey(APPLITOOLS_API_KEY);
        eyes.setServerUrl(APPLITOOLS_SERVER_URL);
        eyes.setLogHandler(new StdoutLogHandler(true));

        eyes.open(driver, "appName", "windowName", new RectangleSize(600, 800));
        driver.get("https://www.listerineprofessional.com/");
        eyes.checkWindow("Login window");
        eyes.close();
    }
}
