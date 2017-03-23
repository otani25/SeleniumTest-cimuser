package test.browser.chrome.cimuser;

import org.junit.Test;

import test.browser.chrome.BrowserChromeDriver;
import test.common.cimuser.CimUserLogin;

/**
 * Chromeのログインテスト
 */
public class CHCimUserLoginTest extends BrowserChromeDriver {

    private CimUserLogin cimUserLogin;

    @Override
    protected void setupProfile() {
    }

    @Override
    public void preTest() {
        super.preTest();
        cimUserLogin = new CimUserLogin("Chrome", getDriver(), "testInfo/cimuser.properties");
    }

//  @Test
//  public void testDebug(){
//  	cimUserLogin.CIM_59();
//  }
}
