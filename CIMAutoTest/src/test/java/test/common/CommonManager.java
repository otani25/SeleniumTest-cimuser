package test.common;

import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public abstract class CommonManager {

    protected String browserName;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties testInfo;
    protected String baseURL;

    public CommonManager(String browserName, WebDriver driver, Properties testInfo) {
        this.browserName = browserName;
        this.driver = driver;
        this.testInfo = testInfo;
        this.baseURL = testInfo.getProperty("baseURL");
        this.wait = new WebDriverWait(driver, 10);
    }

    public void beforeTestClass() {
    }

    public void afterTestClass() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public void waitUntil(ExpectedCondition<?> arg0){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	wait.until(arg0);
    }
}
