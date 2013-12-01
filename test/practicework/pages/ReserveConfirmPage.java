package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveConfirmPage {
    private WebDriver driver;    
    private By price = By.id("price");
    private By dateFrom = By.id("datefrom");
    private By dateTo = By.id("dateto");
    private By daysCount = By.id("dayscount");
    private By headCount = By.id("hc");
    private By breakfast = By.id("bf_order");
	private By planA = By.id("plan_a_order");
	private By planB = By.id("plan_b_order");
	private By guestName = By.id("gname");
        
    public ReserveConfirmPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPrice() {
        return driver.findElement(price).getText();
    }
    
    public String getDateFrom() {
        return driver.findElement(dateFrom).getText();
    }

    public String getDateTo() {
        return driver.findElement(dateTo).getText();
    }
    
    public String getDaysCount() {
        return driver.findElement(daysCount).getText();
    }

    public String getHeadCount() {
		return driver.findElement(headCount).getText();
	}

	public boolean isBreakfast() {
		if ("あり".equals(driver.findElement(breakfast).getText())) {
			return true;
		} else if ("なし".equals(driver.findElement(breakfast).getText())) {
			return false;
		} else {
			throw new RuntimeException();
		}
	}

	public boolean isPlanA() {
		if (0 < driver.findElements(planA).size()) {
			return "昼からチェックインプラン".equals(driver.findElement(planA).getText());
		} else {
			return false;
		}
	}

	public boolean isPlanB() {
		if (0 < driver.findElements(planB).size()) {
			return "お得な観光プラン".equals(driver.findElement(planB).getText());
		} else {
			return false;
		}
	}

	public String getGuestName() {
        return driver.findElement(guestName).getText();
	}
}
