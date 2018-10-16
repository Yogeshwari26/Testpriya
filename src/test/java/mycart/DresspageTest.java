package mycart;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DresspageTest extends BasePage {

	Homepageobjects homePage;
	BasePage bp;
	Productpageobjects Pb;
	DresspageObjects Dp;
	String email = "priya@gmail.com";

	public DresspageTest() {
		homePage = new Homepageobjects();
		bp = new BasePage();
		Pb = new Productpageobjects();
		Dp = new DresspageObjects();

	}

// Verify Size – L, M and S is displayed

	@Test

	public void getSandLandM() {

		homePage.clickdresstext();
		String m = Dp.gettextL();
		String n = Dp.gettextM();
		String o = Dp.gettextS();
		bp.getnavigateback();
		Assert.assertTrue((m.equals("L (5)")) && (n.equals("M (5)")) && (o.equals("S (5)")));

	}

// Verify Respective Matching result count and product count is being displayed
	@BeforeMethod

	public void BeforeMethod() {
		homePage.clickdresstext();
	}

	@Test

	public void checkproductcount() {
		// homePage.clickdresstext();
		int number = Dp.sizeofdescription();
		int number1 = Dp.compareheadercount();
		Assert.assertEquals(number, number1);

	}

// verify first product and verify its added to cart

	@Test

	public void checkingcartaddedwith1() {
		// homePage.clickdresstext();
		Dp.getproceedtocheckout();
		Pb.goproceedtocheckout();
		Assert.assertTrue(bp.isElementVisible(Pb.geticon()), "Failed:mistmatch");
	}

// verify ascending order

	@Test

	public void checkascendingorder() {
		homePage.clickdresstext();
		bp.selectoption(Dp.selectdrop(), 1);
		ArrayList<Double> m = Dp.findoutprices(Dp.allproductswithpric());
		for (int i = 0; i < m.size() - 1; i++) {
			Assert.assertTrue(m.get(i) < m.get(i + 1), "Failed");
		}

	}

// verify alphabetical order A to z
	@Test

	public void checkalphabeticalgorder() {
		homePage.clickdresstext();
		bp.selectoption(Dp.selectdrop(), 3);
		List<String> n = Dp.findalldressname(Dp.productnames());
		int sizes = n.size();
		for (int i = 0; i < sizes; i++) {
			for (int j = i + 1; j < sizes; j++) {
				Assert.assertTrue((n.get(i).compareTo(n.get(j)) > 0), "Failed in alpahbetical arrangements");
			}
		}
	}

// verify the discount names

	@Test

	public void verifydiscounts() {
		homePage.clickdresstext();
		Dp.getlisticon();
		Dp.getalldiscountvalues(Dp.);

	}

}
