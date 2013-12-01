package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReserveInputPage {
    private WebDriver driver;
    private By reserveDate = By.id("datePick");
    private By reserveTerm = By.id("reserve_term");

    private By headCount = By.id("headcount");
    private By breakfastOn = By.id("breakfast_on");
    private By breakfastOff = By.id("breakfast_off");
    private By planA = By.id("plan_a");
    private By planB = By.id("plan_b");
    private By guestName = By.id("guestname");

    private By goToNext = By.id("agree_and_goto_next");

    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setReserveDate(String year, String month, String day) {
    	WebElement el = this.driver.findElement(reserveDate);
    	el.clear();
    	el.sendKeys(year + "/" + month + "/" + day);
    	el.sendKeys(Keys.RETURN);
    }

    public void setReserveTerm(String value) {
        Select select = new Select(driver.findElement(reserveTerm));
        select.selectByValue(value);
    }
    
    public ReserveConfirmPage goToNext() {
        driver.findElement(goToNext).click();
        return new ReserveConfirmPage(driver);
    }

	public void setHeadCount(String value) {
        Select select = new Select(driver.findElement(headCount));
        select.selectByValue(value);
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
