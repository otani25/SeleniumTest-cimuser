/**
*
* クラス名
*   FFCimUserLoginTest.java
*
* 概要
*   CimUserのログインテストをfirefoxブラウザで実行するクラス
*/
package test.browser.firefox.cimuser;

import org.junit.Test;

import browser.firefox.BrowserFirefoxDriver;
import test.common.cimuser.CimUserLogin;

public class FFCimUserLoginTest extends BrowserFirefoxDriver {

    private CimUserLogin cimUserLogin;

    /**
     * ブラウザオプション設定
     */
    @Override
    protected void setupProfile() {
        profile.setEnableNativeEvents( true );
    }

    /**
     * IEブラウザで動作するテストインスタンス生成
     */
    @Override
    public void preTest() {
        super.preTest();
        cimUserLogin = new CimUserLogin( "Firefox", getDriver(), "testInfo/cimuser.properties" );
    }

    // @Test
    // public void testDebug(){
    // cimUserLogin.CIM_59();
    // }

    // CIM->利用者用ポータル（WEB機能）>ログイン
    @Test
    public void CIM_19() {
        cimUserLogin.CIM_19();
    }

    @Test
    public void CIM_20() {
        cimUserLogin.CIM_20();
    }

    @Test
    public void CIM_22() {
        cimUserLogin.CIM_22();
    }

    @Test
    public void CIM_58() {
        cimUserLogin.CIM_58();
    }

    @Test
    public void CIM_59() {
        cimUserLogin.CIM_59();
    }

    @Test
    public void CIM_60() {
        cimUserLogin.CIM_60();
    }

    @Test
    public void CIM_61() {
        cimUserLogin.CIM_61();
    }

    @Test
    public void CIM_62() {
        cimUserLogin.CIM_62();
    }

    @Test
    public void CIM_69() {
        cimUserLogin.CIM_69();
    }

    @Test
    public void CIM_70() {
        cimUserLogin.CIM_70();
    }

}
