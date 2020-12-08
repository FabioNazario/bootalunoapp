package br.edu.infnet.bootalunoapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InsertIT {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("headless");
		driver = new ChromeDriver(op);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void insert() {
		driver.get("http://localhost:8181/");
		driver.findElement(By.linkText("Cadastrar novo aluno")).click();
		driver.findElement(By.id("nome")).click();

		driver.findElement(By.id("nome")).sendKeys("godofredo");
		driver.findElement(By.id("email")).sendKeys("godofredo@bol.com");

		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		assertTrue(driver.getPageSource().contains("godofredo"));
		
		
	}
}
