package pageEvents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductsPageEvents {
	private static Logger loggerj = LogManager.getLogger(ProductsPageEvents.class);
	public WebDriver driver;

	public ProductsPageEvents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}
	
	@FindBy(xpath="//div[@class='plan plan-original']/div[2]/h2")	WebElement aspirationText;
	@FindBy(xpath="//div[@class='plan plan-a-plus']/div[2]/h2")	WebElement aspirationPlusText;
	@FindBy(xpath="//div[@class='plan plan-original']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']")	WebElement getAspirationButton;
	@FindBy(xpath="//div[@class='inside-form']/div/div/input")	WebElement getAspirationTextbox;
	@FindBy(xpath="//div[@class='jwt-modal ng-scope']/button")	WebElement getAspirationPopupExitButton;
	@FindBy(xpath="//div[@class='plan plan-a-plus']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']")	WebElement getAspirationPlusButton;
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[1]/p")	WebElement yearlyText;
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[2]/p")	WebElement monthyText;

	public void findProducts(String product1, String product2) {
		String aspOrig = aspirationText.getText();
		String aspPlus = aspirationPlusText.getText();
		if(aspOrig.contains(product1) && aspPlus.contains(product2))
		{
			loggerj.info("Aspiration and Aspiration Plus seen: " + aspOrig + " and " +aspPlus);
		}
		else if(aspOrig.contains("Aspiration"))
		{
			loggerj.info("Only Aspiration Seen");
		}
		else if(aspPlus.contains("Aspiration Plus"))
		{
			loggerj.info("Only Aspiration Plus Seen");
		}
		else
		{
			loggerj.info("Aspiration and Aspiration Plus not seen");
		}
	}
	public void clickGetAspiration() {
		getAspirationButton.click();
		loggerj.info("Clicking Get Aspiration");
	}
	public void GetAspirationFillInput(String email) {
		getAspirationTextbox.sendKeys(email);
		loggerj.info("Clicking Get Aspiration and checking input field");
	}
	public void exitGetAspirationPopup() {
		getAspirationPopupExitButton.click();
		loggerj.info("Exiting Get Aspiration Popup");
	}
//	Verify that when you click Get Aspiration Plus - A modal with monthly and yearly plans appears
	public void clickGetAspirationPlus() {
		getAspirationPlusButton.click();
		loggerj.info("Clicking Get Aspiration Plus");
	}
//	Verify that yearly radio option is $71.88 paid once yearly and that monthly radio option is $7.99 paid monthly
	public void VerifyYearlyAndMonthlyPlan(String yearlyprice, String monthlyprice) {
		String yearlytext = yearlyText.getText();
		String monthlytext = monthyText.getText();
		if(yearlytext.contains(yearlyprice) && monthlytext.contains(monthlyprice))
		{
			loggerj.info("Yearly and Monthly radio option verified: " + yearlytext + " and " + monthlytext);
		}
		else if(yearlytext.contains(yearlyprice))
		{
			loggerj.info("Only yearly text seen");
		}
		else if(monthlytext.contains(monthlyprice))
		{
			loggerj.info("Only monthly text seen");
		}
		else
		{
			loggerj.info("Yearly and Monthly radio option not verified");
		}
	}
}
