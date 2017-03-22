package test.common;

import java.util.Properties;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import util.CaputureUtils;

public abstract class CommonManager {

	protected static Logger LOG = Logger.getLogger(CommonManager.class.getName()); 
    
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
    
    /*
     * waitUntil
     * 
     * @param ExpectedCondition arg0
     * @param sleepTime
     */
    public void waitUntil(ExpectedCondition<?> arg0,int sleepTime){
    	try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	wait.until(arg0);
    }
    public void waitUntil(ExpectedCondition<?> arg0){
    	waitUntil(arg0,1000);
    }
    
    /*
     * setLog
     * 
     * @param String message
     * @param Level logLevel
     */
//    protected void setLog(Logger logger, String message,Level logLevel){
//    	logger.log(logLevel, "【"+this.browserName+"】 "+message);
//    }
//    protected void setLog(Logger logger,String message){
//    	setLog(logger,message,Level.INFO);
//    }
    
    protected String getLogHeader(){
    	return "【"+this.browserName+"】 ";
    }
}
