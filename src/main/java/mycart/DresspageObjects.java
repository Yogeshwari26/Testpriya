package mycart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Iterable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DresspageObjects extends BasePage {

	@FindBy(xpath = "//div[@class ='product-container']/div[2][.//*[@title='Printed Chiffon Dress']]//*[text()='Add to cart']")
	private WebElement textaddtocart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement textproceedtocheckout;

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement headertext;

	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	private List<WebElement> numberofproducts;

	@FindBy(xpath = "//form[@id ='layered_form']/div/div[2]//ul//a[text()='S']")
	private WebElement findsizeS;

	@FindBy(xpath = "//form[@id ='layered_form']/div/div[2]//ul//a[text()='M']")
	private WebElement findsizeM;

	@FindBy(xpath = "//form[@id ='layered_form']/div/div[2]//ul//a[text()='L']")
	private WebElement findsizeL;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement getproceedtocheck;

	@FindBy(xpath = "//*[@id='center_column']/div/div//span[@class='category-name']")
	private WebElement getdressname;

	@FindBy(xpath = "//div[@class='product-container']/div[1]")
	private WebElement clickfirstproduct;

	@FindBy(id = "selectProductSort")
	private WebElement selectdropdown;

	@FindBys(@FindBy(xpath = "//div[@class='right-block']/div/span[@class='price product-price']"))
	private List<WebElement> listofallproduts;

	@FindBy(id = "layered_ajax_loader")
	private WebElement loadingicon;

	@FindBy(xpath = "//div[@class='left-block']")
	private WebElement mhover;

	@FindBys(@FindBy(xpath = "//div[@class='right-block']/h5/a[@class='product-name']"))
	private List<WebElement> dressname;

	@FindBy(xpath = "//i[@class='icon-th-list']")
	private WebElement listicon;

	@FindBys(@FindBy(xpath = "//div/span[text()='Reduced price!']"))
	private List<WebElement> getreducedprices;

	@FindBys(@FindBy(xpath = "//ul[@class='product_list row list']/li"))
	private List<WebElement> getallproducts;

	@FindBys(@FindBy(xpath = "//div[@class='right-block-content row']/div/span[@class='price-percent-reduction']"))
	private List<WebElement> percentage;
	
	@FindBys(@FindBy(xpath="//span[@class='discount']//parent::div[@class='product-flags']//parent::div[@class='center-block col-xs-4 col-xs-7 col-md-4']//following-sibling::div[@class='right-block col-xs-4 col-xs-12 col-md-4']/div/div/span[3]"))
	private List<WebElement> reduced;
	
	public DresspageObjects() {
		PageFactory.initElements(driver, this);
	}

	public void clickaddtocart() {
		textaddtocart.click();

	}

	public String checkaddtocart() {
		return textproceedtocheckout.getText();

	}

	public int sizeofdescription() {
		return numberofproducts.size();
	}

	public int compareheadercount() {

		String x = headertext.getText();
		String[] arr = x.split(" ");
		String second = arr[2];
		return Integer.parseInt(second);

	}

	public String gettextS() {
		return findsizeS.getText();

	}

	public String gettextM() {
		return findsizeM.getText();

	}

	public String gettextL() {
		return findsizeL.getText();

	}

	public void getproceedtocheckout() {

		clickfirstproduct.click();

	}

	public String getdresstextname() {

		return getdressname.getText();

	}

	public WebElement selectdrop() {
		return selectdropdown;
	}

	public ArrayList<Double> findoutprices(List<WebElement> pass) {
		isElementVisible(loadingicon);

		ArrayList<Double> results = new ArrayList<Double>();
		for (WebElement p : pass) {
			String ele = p.getText();
			ele = ele.replace("$", "");
			Double price = Double.parseDouble(ele);
			System.out.println("Product price " + price);
			results.add(price);
		}
		return results;
	}

	public ArrayList<String> findalldressname(List<WebElement> nam) {
		isElementVisible(loadingicon);
		ArrayList<String> names = new ArrayList<String>();
		for (WebElement Q : nam) {
			String allnames = Q.getText();
			System.out.println("All product names: " + allnames);
			names.add(allnames);
		}
		return names;
	}

	public List<WebElement> allproductswithpric() {
		return listofallproduts;
	}

	public List<WebElement> productnames() {
		return dressname;

	}

	public void getlisticon() {
		listicon.click();

	}

	public void getalldiscountvalues(List<WebElement> pro) {
		List<WebElement> e = getallproducts;
		for (WebElement q : e) {
		 getallproducts.contains(pro);
			}
		
	public ArrayList<String> getproductdiscountnames(List <WebElement> pro) {
		ArrayList<String> name = new ArrayList<String>();
		for(WebElement u : pro) {
			String twoproducts = e.getText();
			System.out.println("All product names: " + twoproducts);
			twoproducts.add(name);
		}
		return name;
		
	}
	
	public List<WebElement> getxpath() {
		return reduced;
	}

		}

	}


