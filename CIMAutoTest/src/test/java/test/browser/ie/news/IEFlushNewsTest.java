package test.browser.ie.news;

import org.junit.Test;

import test.browser.ie.BrowserIEDriver;
import test.common.news.CommonFlushNews;

public class IEFlushNewsTest extends BrowserIEDriver {

    private CommonFlushNews newsTest;

    @Override
    protected void setupProfile() {
    }

    @Override
    public void preTest() {
        super.preTest();
        newsTest = new CommonFlushNews("IE", getDriver(), getTestInfo());
    }

    // ニュースのテスト
    @Test
    public void flushNews() {
    	newsTest.flushNews();
    }

	@Override
	protected String getinitialURL() {
		// TODO Auto-generated method stub
		return null;
	}

}
