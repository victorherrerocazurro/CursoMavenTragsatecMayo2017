package com.portal.parejas;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class PruebaWikipediaIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://es.wikipedia.org";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPruebaWikipediaIT() throws Exception {
		selenium.open("/wiki/Wikipedia:Portada");
		selenium.click("css=a.mw-wiki-logo");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a[title=\"Discusi�n acerca del art�culo [Alt+Shift+t]\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Contribuciones");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Actualidad");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=searchInput", "pepe");
		selenium.click("id=searchButton");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
