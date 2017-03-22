package test.common.cimuser;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;

import static org.junit.Assert.*;

import test.common.CommonManager;
import util.CaputureUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CimUserLogin extends CommonManager {
	private static Logger LOG = Logger.getLogger(CimUserLogin.class.getName()); 
	
	public CimUserLogin(String browserName, WebDriver driver, String testInfoPath) {
		super(browserName, driver, testInfoPath);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ログイン画面表示(URLに顧客管理番号なし)
	 */
	public void CIM_19(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);
	    assertTrue(driver.findElements(By.id("customerNo")).size() > 0);
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_19");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。path:"+filePath);
        
	}
	
	/**
	 * ログイン画面表示(URLに顧客管理番号あり)
	 */
	public void CIM_20(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath") + testInfo.getProperty("cimUserCode"));
	    waitUntil(titleContains("利用者用ポータル"),1000);
	    // customerNoが無い事を確認
	    assertTrue(driver.findElements(By.id("customerNo")).size() == 0);
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_20");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。path:"+filePath);
	}

	/**
	 * ログイン成功(URLに顧客管理番号なし)
	 */
	public void CIM_22(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),2000);
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_22");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。 path:"+filePath);
	}

	/**
	 * ログイン成功(URLに顧客管理番号あり)
	 */
	public void CIM_58(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath") + testInfo.getProperty("cimUserCode"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),2000);
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_58");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。 path:"+filePath);
	}
	

	/**
	 * ログイン失敗(顧客管理番号)
	 */
	public void CIM_60(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient")+"dummy");
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル"));
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_60");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。 path:"+filePath);
	}
	

	/**
	 * ログイン失敗(契約期間外)
	 */
	public void CIM_59(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　契約期間外になっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_59");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}
	/**
	 * ログイン失敗(ユーザID)
	 */
	public void CIM_61(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　契約一時停止になっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU")+"dummy");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_61");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}
	/**
	 * ログイン失敗(アカウントステータス)
	 */
	public void CIM_62(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　アカウントステータス無効になっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU_62"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP_62"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_62");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}
	/**
	 * ログイン失敗(パスワード有効期限)
	 */
	public void CIM_69(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　アカウントロックになっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU_69"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP_69"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_69");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}
	/**
	 * ログイン失敗(アカウント有効期限)
	 */
	public void CIM_70(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　アカウントロックになっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU_70"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP_70"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),3000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_70");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}
	
	/**
	 * ログイン失敗(契約一時停止)
	 */
	public void CIM_110(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　契約一時停止になっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU_110"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP_110"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_110");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}

	/**
	 * ログイン失敗(パスワード)
	 */
	public void CIM_111(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　契約一時停止になっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP")+"dummy");
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_111");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}

	/**
	 * ログイン失敗(アカウントロック)
	 */
	public void CIM_112(){
	    driver.get(baseURL + testInfo.getProperty("cimUserPath"));
	    waitUntil(titleContains("利用者用ポータル"),1000);

	    //　アカウントロックになっているユーザーでログイン
	    driver.findElement(By.id("loginId")).clear();
	    driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("cimUserU_112"));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("cimUserP_112"));
	    driver.findElement(By.id("customerNo")).clear();
	    driver.findElement(By.id("customerNo")).sendKeys(testInfo.getProperty("cimUserClient"));
	    driver.findElement(By.name("btn1")).click();
	    waitUntil(titleContains("利用者用ポータル - お知らせ一覧"),2000);
	    // 要素がわからないのでソース内検索
	    assertTrue(driver.getPageSource().contains("ログインに失敗しました。") && 
	    		   driver.getPageSource().contains("ログイン情報をご確認ください。"));
	    
	    String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "CIM_112");
	    CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
	    // logは各メソッドで直接呼ばないとログにメソッド名が表示されない
	    LOG.log(Level.INFO,getLogHeader()+"キャプチャ画像を確認してください。暫定で成功にしています。path:"+filePath);
	}
	
	
	
	
	
	
	
	
    public void userLogin() {
      driver.get(baseURL + testInfo.getProperty("loginPath"));
      driver.findElement(By.id("loginId")).clear();
      driver.findElement(By.id("loginId")).sendKeys(testInfo.getProperty("user"));
      driver.findElement(By.id("password")).clear();
      driver.findElement(By.id("password")).sendKeys(testInfo.getProperty("pass"));
      driver.findElement(By.name("btn1")).click();
      waitUntil(titleContains("クラウド管理者"),5000);
    
      String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "userLogin");
      CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
    }

}
