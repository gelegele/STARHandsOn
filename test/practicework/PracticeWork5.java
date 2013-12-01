package practicework;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import practicework.pages.ReserveInputPage;

public class PracticeWork5 {
    private WebDriver driver;
    
    private String chromeDriverPath() {
        String path;
        if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX) {
            path = "chromedriver/mac/chromedriver"; // Mac環境の場合
        } else {
            path = "chromedriver/win/chromedriver.exe"; // Windows環境の場合
        }
        File file = new File(path);
        return file.getAbsolutePath();
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath());
        driver = new ChromeDriver();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void test() {        
        File html = new File("reserveApp_Renewal/index.html");
        String url = "file:///" + html.getAbsolutePath();
        driver.get(url);
        
        // 初期値チェック処理を記述してください
        ReserveInputPage reserveInputPage = new ReserveInputPage(driver);
        assertThat(reserveInputPage.getReserveDate(), is("2013/12/1")); //TODO 今日の日付
        assertThat(reserveInputPage.getReserveTerm(), is("1"));
        assertThat(reserveInputPage.getHeadCount(), is("1"));
        assertThat(reserveInputPage.isBreakfastOn(), is(true));
        assertThat(reserveInputPage.isBreakfastOff(), is(false));
        assertThat(reserveInputPage.isPlanA(), is(false));
        assertThat(reserveInputPage.isPlanB(), is(false));
        assertThat(reserveInputPage.getGuestName(), is(""));
    }
}
