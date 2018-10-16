package mycart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Homepageobjects extends BasePage {

	@FindBy(xpath = "//*[@id='block_top_menu']//*[text()='Women']")
	private WebElement textwomen;

	@FindBy(xpath = "//div/ul/li[2]//*[text()='Dresses']")
	private WebElement textdress;

	@FindBy(xpath = "//div/ul/li[3]//*[text()='T-shirts']")
	private WebElement textshirt;

	@FindBy(xpath = "//div[@id='newsletter_block_left']//*[@id='newsletter-input']")
	private WebElement textboxnewsletter;

	@FindBy(xpath = "//ul[@id='homefeatured']//li[7]")
	private WebElement moredescription;

	@FindBy(xpath = "//ul[@id='homefeatured']//li[.//*[@title='Printed Chiffon Dress']]//*[text()='More']")
	private WebElement moretextbtn;

	@FindBy(xpath = "//ul[@id='homefeatured']//li[1]//a[@title='Add to cart']")
	private WebElement textaddtocart;

	@FindBy(xpath = "//button[@name='submitNewsletter']")
	private WebElement textsummitbtn;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	private WebElement getsuccessmsg;

	@FindBy(xpath = "//div[@class='right-block']/h5/a")
	private WebElement getproductname;

	@FindBys(@FindBy(xpath = "//ul[@id='homefeatured']//li"))

	private List<WebElement> productlist;

	public Homepageobjects() {
		PageFactory.initElements(driver, this);
	}

	public String getwomentext() {
		return textwomen.getText();
	}

	public String getdresstext() {
		return textdress.getText();
	}

	public String getshirttext() {
		return textshirt.getText();
	}

	public void clickwomentext() {
		textwomen.click();

	}

	public void clickdresstext() {
		textdress.click();
	}

	public void clickshirttext() {
		textshirt.click();
	}

	public void sendemail(String email) {
		textboxnewsletter.sendKeys(email);

	}

	public void getemailentered() {
		textboxnewsletter.click();

	}

	public void gototweetsharepage() {
		moretextbtn.click();

	}

	public void clickaddtocart() {
		textaddtocart.click();

	}

	public void getmoredesc() {

		moredescription.click();
	}

	public void navigatesummitbutton() {
		textsummitbtn.click();
	}

	public String getsubscribesuccessmessage() {
		return getsuccessmsg.getText();
	}

	public List<WebElement> getproductslist() {
		return productlist;
	}

	public boolean verifyaddtocartmatch(WebElement parent) {

		return elementFound(parent.findElement(By.xpath(".//*[text()='Add to cart']")));

	}

	public String displaythemissedaddtocart(WebElement prod) {
		return (prod.findElement(By.xpath("//div[@class='right-block']/h5/a"))).getText();
	}

}
