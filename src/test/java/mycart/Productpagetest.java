package mycart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Productpagetest extends BasePage {

	public class DresspageTest {

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

		@Test

		public void checkingproddescription() { // homePage.gototweetsharepage();
			homePage.getmoredesc();
			String text = Pb.getproddescription();
			Assert.assertTrue((text.equals("Printed chiffon knee length dress with tank straps. Deep v-neckline.")));
		}

		@Test
		public void checktweetshare() {

			homePage.getmoredesc();
			String text = Pb.getproddescription();
			String x = Pb.getshare();
			String y = Pb.gettweet();
			Assert.assertTrue((y.equals("Tweet")) && (x.equals("Share")));
		}

	}
	
}
