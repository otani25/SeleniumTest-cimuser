package test.browser.chrome.news;

import org.junit.Test;

import test.browser.chrome.BrowserChromeDriver;
import test.common.news.CommonFlushNews;

public class CHFlushNewsTest extends BrowserChromeDriver {

    private CommonFlushNews newsTest;

    @Override
    protected void setupProfile() {
    }

    @Override
    public void preTest() {
        super.preTest();
        newsTest = new CommonFlushNews("Chrome", getDriver(), getTestInfo());
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
