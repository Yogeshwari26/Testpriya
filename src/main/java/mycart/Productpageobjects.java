package mycart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Productpageobjects extends BasePage {

	@FindBy(xpath = "//*[@class ='btn btn-default btn-twitter']")
	private WebElement texttweet;

	@FindBy(xpath = "//*[@class ='btn btn-default btn-facebook']")
	private WebElement textshare;

	@FindBy(xpath = "//*[@id='short_description_content']")
	private WebElement getdescription;

	@FindBy(xpath = "//ul[@id='homefeatured']//li[1]//div[2]/div[2]/a[@title='Add to cart']")
	private WebElement getaddtocart;

	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement clicksumitbutton;

	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement iconok;

	public Productpageobjects() {

		PageFactory.initElements(driver, this);
	}

	public String gettweet() {
		return texttweet.getText();
	}

	public String getshare() {
		return textshare.getText();
	}

	public String getproddescription() {
		return getdescription.getText();
	}

	public void goproceedtocheckout() {
		clicksumitbutton.click();

	}

	public WebElement geticon() {
		return iconok;
	}
}
