/**
*
* クラス名
*   CHCimUserLoginTest.java
*
* 概要
*   CimUserのログインテストをfirefoxブラウザで実行するクラス
*/
package test.browser.chrome.cimuser;

import org.junit.Test;

import browser.chrome.BrowserChromeDriver;
import test.common.cimuser.CimUserLogin;

public class CHCimUserLoginTest extends BrowserChromeDriver {

    private CimUserLogin cimUserLogin;

    /**
     * ブラウザオプション設定
     */
    @Override
    protected void setupProfile() {
    }

    /**
     * Chromeブラウザで動作するテストインスタンス生成
     */
    @Override
    public void preTest() {
        super.preTest();
        cimUserLogin = new CimUserLogin( "Chrome", getDriver(), "testInfo/cimuser.properties" );
    }

    // @Test
    // public void testDebug(){
    // cimUserLogin.CIM_59();
    // }
}
