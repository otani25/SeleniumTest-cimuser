package test.browser.chrome;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.browser.BrowserTestBase;

public abstract class BrowserChromeDriver extends BrowserTestBase {

    @Override
    protected void initDriver() {
    	capabilities = DesiredCapabilities.chrome();
        setupProfile();

        // 作成したプロファイルでIE(のドライバー)を起動する
        String driverPath = getTestInfo().getProperty("chromeDriver");
        capabilities = DesiredCapabilities.chrome();
        if(driverPath.contains("http")){
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setBrowserName("internet explorer");
            try {
    			driver = new RemoteWebDriver(new URL(driverPath), capabilities);
    		} catch (MalformedURLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        else{
          capabilities.setCapability("chrome.binary", getTestInfo().getProperty("chromeBinary"));
      	  System.setProperty("webdriver.chrome.driver", driverPath);
          driver = new ChromeDriver(capabilities);
        }
    }

    abstract protected void setupProfile();

}
