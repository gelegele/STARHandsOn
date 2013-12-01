package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReserveInputPage {
    private WebDriver driver;
    private By reserveYear = By.id("reserve_year");
    private By reserveMonth = By.id("reserve_month");
    private By reserveDay = By.id("reserve_day");
    private By reserveTerm = By.id("reserve_term");

    private By headCount = By.id("headcount");
    private By breakfastOn = By.id("breakfast_on");
    private By breakfastOff = By.id("breakfast_off");
    private By planA = By.id("plan_a");
    private By planB = By.id("plan_b");
    private By guestName = By.id("guestname");

    private By goToNext = By.id("goto_next");

    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setReserveYear(String value) {
        WebElement element = driver.findElement(reserveYear);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveMonth(String value) {
        WebElement element = driver.findElement(reserveMonth);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveDay(String value) {
        WebElement element = driver.findElement(reserveDay);
        element.clear();
        element.sendKeys(value);
    }
    
    public void setReserveDate(String year, String month, String day) {
        setReserveYear(year);
        setReserveMonth(month);
        setReserveDay(day);
    }

    public void setReserveTerm(String value) {
        WebElement element = driver.findElement(reserveTerm);
        element.clear();
        element.sendKeys(value);
    }
    
    public ReserveConfirmPage goToNext() {
        driver.findElement(goToNext).click();
        return new ReserveConfirmPage(driver);
    }

	public void setHeadCount(String value) {
		driver.findElement(headCount).clear();
		driver.findElement(headCount).sendKeys(value);
	}

	public void setBreakfastOn() {
		driver.findElement(breakfastOn).click();
	}

	public void setBreakfastOff() {
		driver.findElement(breakfastOff).click();
	}

	public void setPlanA(boolean value) {
		WebElement el = driver.findElement(planA);
		if (el.isSelected() != value) {
			el.click();
		}
	}

	public void setPlanB(boolean value) {
		WebElement el = driver.findElement(planB);
		if (el.isSelected() != value) {
			el.click();
		}
	}

	public void setGuestName(String value) {
		WebElement el = driver.findElement(guestName);
		el.clear();
		el.sendKeys(value);
	}
}
