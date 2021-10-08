package pageEvents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageEvents {

	private static Logger loggerj = LogManager.getLogger(HomePageEvents.class);
	public WebDriver driver;

	public HomePageEvents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a")
	WebElement spendSaveButton;

	public void clickOnSpendSave() {
		loggerj.info("Clicking on Spend & Save");
		spendSaveButton.click();
	}
}
