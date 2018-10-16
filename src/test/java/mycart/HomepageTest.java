package mycart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomepageTest extends BasePage {

	Homepageobjects homePage;
	BasePage bp;
	Productpageobjects Pb;
	DresspageObjects Dp;
	String email = "dellp@gmail.com";

	public HomepageTest() {
		homePage = new Homepageobjects();
		bp = new BasePage();
		Pb = new Productpageobjects();
		Dp = new DresspageObjects();

	}

// Verify Tabs - Women, Dresses and T-shirt are displayed on Home Page.

	@Test
	public void findthreetextbox() {
		String a = homePage.getwomentext();

		String b = homePage.getdresstext();

		String c = homePage.getshirttext();

		Assert.assertTrue((b.equals("DRESSES")) && (c.equals("T-SHIRTS")) && (a.equals("WOMEN")));
	}

// Verify Corresponding page been navigated on selecting these tabs

	@Test
	public void findcorresspondingpage() {

		homePage.clickdresstext();
		Assert.assertTrue(bp.getTitlte().contains("Dresses"));
		bp.getnavigateback();
		homePage.clickshirttext();
		Assert.assertTrue(bp.getTitlte().contains("T-shirts"));
		bp.getnavigateback();
		homePage.clickwomentext();
		Assert.assertTrue(bp.getTitlte().contains("Women"));
		bp.getnavigateback();
	}

// Verify Subscription message is displayed after entering valid e-mail in Newsletter follow up.

	@Test
	public void checkemailaddress() {
		homePage.sendemail(email);
		homePage.getemailentered();
		homePage.navigatesummitbutton();
		String success = homePage.getsubscribesuccessmessage();
		Assert.assertTrue((success.equals("Newsletter : You have successfully subscribed to this newsletter.")));
	}

// verify all add to cart have products

	@Test

	public void checkproductaddtocart() {

		List<WebElement> counts = homePage.getproductslist();

		for (WebElement p : counts) {

			Assert.assertTrue(homePage.verifyaddtocartmatch(p),
					"Add to cart is not present:" + homePage.displaythemissedaddtocart(p));

		}
	}

	@AfterClass

	public void quit() {
		quitDriver();
		System.out.println("The browser got closed");
	}
}