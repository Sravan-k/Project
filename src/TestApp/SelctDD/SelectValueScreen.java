package TestApp.SelctDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class SelectValueScreen {

	@FindBy(id = "picker_1")
	WebElement pickerWheeel1;

	@FindBy(id = "picker_2")
	WebElement pickerWheeel2;
	
	@FindBy(id= "")
	WebElement selectedActualValue;

	private String valueSelected;
	
	AppiumDriver driver;

	public SelectValueScreen(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Input below code for navigate to selctValueScreen
	}

	public String selectValueFromDropdown(String valueinGivenPicker, String pickerWheelNumber) {

		if (pickerWheelNumber.equalsIgnoreCase("picker1")) {
			pickerWheeel1.click();
			valueSelected = getValueSelected(valueinGivenPicker, pickerWheeel1);
		} else {
			pickerWheeel2.click();
			valueSelected = getValueSelected(valueinGivenPicker, pickerWheeel2);
		}
		return valueSelected;
	}

	private String getValueSelected(String valueinGivenPicker, WebElement pickerWheel) {
		Select selectValue = new Select(pickerWheel);
		selectValue.selectByValue(valueinGivenPicker);
		valueSelected = selectValue.getFirstSelectedOption().getText();
		return valueSelected;
	}

	public void verifyValueSelected(String selectedValue) {
		// Implement code for adding decimal value to selectedValue and compare
		// the value
		Double expectedValue = Double.parseDouble(selectedValue);
		Assert.assertEquals(selectedActualValue.getText(), expectedValue);
	}

}
