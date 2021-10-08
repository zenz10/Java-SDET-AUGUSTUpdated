package stepDefinitions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageEvents.HomePageEvents;
import pageEvents.ProductsPageEvents;
import utilitiesmain.BaseClass;
import utilitiestest.Constants;

public class Steps extends BaseClass{

	public HomePageEvents hp;
	public ProductsPageEvents pp;
	
	@Given("User opens browser and visits aspirations homepage")
	public void user_opens_browser_and_visits_aspirations_homepage() {
		setDriver("chrome");
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User clicks on Spend & Save")
	public void user_clicks_on_spend_save() {
		hp=new HomePageEvents(driver);
		hp.clickOnSpendSave();
	}

	@Then("The two products aspiration and aspiration plus is seen")
	public void the_two_products_aspiration_and_aspiration_plus_is_seen() {
		pp=new ProductsPageEvents(driver);
		pp.findProducts("Aspiration", "Aspiration Plus");
	}

	@When("User clicks on Get Aspiration")
	public void user_clicks_on_get_aspiration() {
		pp.clickGetAspiration();
	}

	@Then("User can input email")
	public void user_can_input_email() {
		pp.GetAspirationFillInput("email input check");
	}

	@When("User exits the popup by clicking on the top right X")
	public void user_exits_the_popup_by_clicking_on_the_top_right_x() {
		pp.exitGetAspirationPopup();
	}

	@Then("The products page can be seen")
	public void the_products_page_can_be_seen() {
		pp.findProducts("Aspiration", "Aspiration Plus");
	}

	@When("User clicks on Get Aspiration Plus")
	public void user_clicks_on_get_aspiration_plus() {
		pp.clickGetAspirationPlus();
	}

	@Then("The yearly and monthly plan can be seen")
	public void the_yearly_and_monthly_plan_can_be_seen() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pp.VerifyYearlyAndMonthlyPlan("$71.88 paid once yearly", "$7.99 paid monthly");
		closeDriver();
	}
}
