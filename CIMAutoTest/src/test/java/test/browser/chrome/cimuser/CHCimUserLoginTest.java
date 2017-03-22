package test.browser.chrome.cimuser;

import org.junit.Test;

import test.browser.chrome.BrowserChromeDriver;
import test.common.cimuser.CimUserLogin;

/**
 * Chromeのログイン画面テスト
 */
public class CHCimUserLoginTest extends BrowserChromeDriver {

    private CimUserLogin cimUserLogin;

    @Override
    protected void setupProfile() {
    }

    @Override
    public void preTest() {
        super.preTest();
        cimUserLogin = new CimUserLogin("Chrome", getDriver(), getTestInfo());
    }

    // ログインのテスト
//    @Test
//    public void userLogin() {
//    	cimUserLogin.userLogin();
//    }

	@Override
	protected String getinitialURL() {
		// TODO Auto-generated method stub
		return null;
	}
}
