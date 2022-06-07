package org.pages;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLogin extends BaseClass {
	public FlipkartLogin() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement btnclose;
	
	@FindBy(xpath="//input[@type='text'")
	private WebElement txtsearch;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnSearch;

	public WebElement getBtnclose() {
		return btnclose;
	}

	public WebElement getTxtsearch() {
		return txtsearch;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public void flipkart() {
		click(getBtnclose());
		sendKeys(getTxtsearch(), "iphone");
		click(getBtnSearch());
		System.out.println("Search Product name :"+getAttribute(getTxtsearch()));

	}
}
