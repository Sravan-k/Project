package TestApp.SelctDD;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class TestStepDef {
	static String deviceName = "Nexus9-6.0.0-API23";
	static AppiumDriver d;

	SelectValueScreen selectValueScreenPage;
	String selectedValue;

	@Given("^User is on the page with dropdown selection$")
	public void User_is_on_the_page_with_dropdown_selection() throws Throwable {

		@SuppressWarnings("unused")
		// Driver initialisation with paramter of driver type - Android/iOS
		Driver driver = new Driver();
		d = driver.createDriver("Appium");
		
		 
	}

	@Given("^click the \"([^\"]*)\" in the dropdown from \"([^\"]*)\"$")
	public void click_the_in_the_dropdown_from(String valueinGivenPicker, String pickerWheelNumber) throws Throwable {
		// Navigate to SlectValueScreen
		selectValueScreenPage = new SelectValueScreen(d);
		selectedValue = selectValueScreenPage.selectValueFromDropdown(valueinGivenPicker, pickerWheelNumber);
	}

	@Then("^verify the selectedValue$")
	public void verify_the_selectedValue() throws Throwable {
		selectValueScreenPage.verifyValueSelected(selectedValue);
	}
}
