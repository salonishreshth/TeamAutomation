package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage  {

	public WebDriver driver;
	
	// Page object Repository - Elements located using @FindBy annotation
	
		 // Elements to launch text box page 
			
			@FindBy(xpath = "//input[@name='q']")
			WebElement elementsButton;
				
	
	//Page class constructor 
	
			public DemoPage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			// Operation#1 - Launching page 

			public void SearchBoxTextPage() throws InterruptedException {
				Thread.sleep(5000);
				elementsButton.click();
			}
			
			// Operation#2 - passing data to  Submit form 
			
			public void submitData(String data) throws InterruptedException{
				elementsButton.sendKeys(data);
			}	
			
			//Operation 3 - Get the data to verify 
			
			public String getOutputData(){
				String output="Selenium";
				return output;
			}
}
