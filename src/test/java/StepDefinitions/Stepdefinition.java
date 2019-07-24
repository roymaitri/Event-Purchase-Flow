package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;

public class Stepdefinition {
	WebDriver mDriver = new ChromeDriver();

	@Given("^user is on PAPER TICKET EVENT 2$")
	public void user_is_on_paper_ticket_event_2() {
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		mDriver.get("https://test1.ote01.tixey.com/event/z98n-paper-ticket-event-2-6th-mar-booking_fee_venue-tickets");
	}

	@When("^user clicks on BOOK NOW CTA$")
	public void user_clicks_on_book_now_cta() {
		mDriver.findElement(
				By.xpath("//button[@class='PurchaseCTAButton__CTAButton-iuZDvd hqtXAc styles-hgefyM iINFsM']")).click();
	}

	@Then("^No of tickets and CHECKOUT CTA get displayed in Select tickets section$")
	public void no_of_tickets_and_checkout_cta_get_displayed_in_select_tickets_section() {
		mDriver.findElement(By.xpath("//span[contains(text(),'Select tickets')]"));
	}

	@And("^user enters no of tickets and clicks on CHECKOUT CTA$")
	public void user_enters_no_of_tickets_and_clicks_on_checkout_cta() {
		mDriver.findElement(By.xpath("//div[@class='TicketSelection__TicketNumber-jsGAXV fHJpbM']"));
		new WebDriverWait(mDriver, 2).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Button-hYXUXp hFaBCM']")))
				.click();
	}

	@Then("^it navigates to Account section$")
	public void it_navigates_to_account_section() {
		mDriver.findElement(By.xpath("//span[contains(text(),'Account')]"));
	}

	@Given("^user is on login tab of account section$")
	public void user_is_on_login_tab_of_account_section() {
		new WebDriverWait(mDriver, 2).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='LoginAndRegistration__Tab-jCmEoB eESeVW']")))
				.click();
	}

	@When("^user enters valid phone number (\\d+)$")
	public void user_enters_valid_phone_number(long phoneNumber) {
		mDriver.findElement(By.xpath("//input[@name='tel.national']")).sendKeys(phoneNumber+"");
		System.out.println("PHN no" + phoneNumber );
	}

	@And("^user clicks on VERIFY PHONE NUMBER CTA$")
	public void user_clicks_on_verify_phone_number_cta() {
		new WebDriverWait(mDriver, 2).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='LoginForm__Submit-klmacj cQTvBx Button-hYXUXp hFaBCM']")))
		.click();
	}

	@Then("^it navigates to verification section$")
	public void it_navigates_to_verification_section() {
		mDriver.findElement(By.xpath("//div[@class='ProgressIndicator__Wrapper-epcpMV bdvaXD']//div[3]"));
	}

	@Given("^user is on Verification section$")
	public void user_is_on_verification_section() {
		mDriver.findElement(By.xpath("//div[@class='ProgressIndicator__Wrapper-epcpMV bdvaXD']//div[3]"));
	}

	@When("^user enters four digits code in VERIFY PHONE NUMBER input box$")
	public void user_enters_four_digits_code_in_verify_phone_number_input_box() {
		new WebDriverWait(mDriver, 2).until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SMSCodeInput__CodeInput-jpFGWn.CWOdf")));
		List<WebElement> w = mDriver.findElements(By.cssSelector(".SMSCodeInput__CodeInput-jpFGWn.CWOdf"));
		for (int i = 0; i < w.size(); i++) {
			w.get(i).sendKeys((i + 1) + "");
		}
	}

	@Then("^it either navigates to Payment section or dislays an error based on maximum purchase limit$")
	public void it_navigates_to_payment_section() {
		try {
			new WebDriverWait(mDriver, 1).until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Error__Message-kuwLFH.gUaCKF")));
			System.out.println("Maximum number of attempts for an account is reached.");
			mDriver.close();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Number of attempts for an account is less than five.");
		}
		mDriver.findElement(By.xpath("//div[@class='ProgressIndicator__Wrapper-epcpMV bdvaXD']//div[4]"));
	}

	@Given("^user is on Payment section$")
	public void user_is_on_payment_section() {
		mDriver.findElement(By.xpath("//div[@class='ProgressIndicator__Wrapper-epcpMV bdvaXD']//div[4]"));
	}

	@When("^user enters valid Card number, Expiry date and CVV$")
	public void user_enters_valid_card_number_expiry_date_and_cvv() {
		new WebDriverWait(mDriver, 2).until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cardNumber-anchor\"]/div/input")));
		mDriver.findElement(By.xpath("//*[@id=\"cardNumber-anchor\"]/div/input")).sendKeys("4242424242424242");
		mDriver.findElement(By.xpath("//*[@id=\"expiry-anchor\"]/div/input[1]")).sendKeys("09");
		mDriver.findElement(By.xpath("//*[@id=\"expiry-anchor\"]/div/input[2]")).sendKeys("2029");
		mDriver.findElement(By.xpath("//*[@id=\"cvv-anchor\"]/div/input")).sendKeys("897");
	}

	@And("^user clicks on PURCHASE TICKETS CTA$")
	public void user_clicks_on_purchase_tickets_cta() {
		mDriver.findElement(By.xpath("//button[@class='Button-hYXUXp hFaBCM']")).click();
	}

	@Then("^user can see purchased event details$")
	public void user_can_see_purchased_event_details() {
		new WebDriverWait(mDriver, 2).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/article/div[2]/div[1]/div")));
		mDriver.close();
	}
}
