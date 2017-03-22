package test.browser.ie.cimuser;

import org.junit.Test;

import test.browser.ie.BrowserIEDriver;
import test.common.cimuser.CimUserLogin;

/**
 * IEのログイン画面テスト
 */
public class IECimUserLoginTest extends BrowserIEDriver {

    private CimUserLogin cimUserLogin;

    @Override
    protected void setupProfile() {
    }

    @Override
    public void preTest() {
        super.preTest();
        cimUserLogin = new CimUserLogin("Firefox", getDriver(), getTestInfo());
    }

//    @Test
//    public void testDebug(){
//    	cimUserLogin.CIM_60();
//    }

    //　CIM->利用者用ポータル（WEB機能）>ログイン
    @Test
    public void CIM_19(){
    	cimUserLogin.CIM_19();
    }
    @Test
    public void CIM_20(){
    	cimUserLogin.CIM_20();
    }
    @Test
    public void CIM_22(){
    	cimUserLogin.CIM_22();
    }
    @Test
    public void CIM_58(){
    	cimUserLogin.CIM_58();
    }
    @Test
    public void CIM_59(){
    	cimUserLogin.CIM_59();
    }
    @Test
    public void CIM_60(){
    	cimUserLogin.CIM_60();
    }
    @Test
    public void CIM_61(){
    	cimUserLogin.CIM_61();
    }
    @Test
    public void CIM_62(){
    	cimUserLogin.CIM_62();
    }
    @Test
    public void CIM_69(){
    	cimUserLogin.CIM_69();
    }
    @Test
    public void CIM_70(){
    	cimUserLogin.CIM_70();
    }

	@Override
	protected String getinitialURL() {
		// TODO Auto-generated method stub
		return null;
	}
}
