package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InfiniteScrollTest extends BaseTest {

	private static final By INFINITE_SCROLL_LINK = By.linkText("Infinite Scroll");
	private static final By PARAGRAFO_ADDED = By.className("jscroll-added");

	@Test
	@DisplayName("Deve carregar novos conteúdos ao realizar rolagem na página")
	public void testarScrollInfinito() throws InterruptedException {
		driver.findElement(INFINITE_SCROLL_LINK).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int quantidadeInicial = driver.findElements(PARAGRAFO_ADDED).size();

		for (int i = 0; i < 2; i++) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
		}

		int quantidadeFinal = driver.findElements(PARAGRAFO_ADDED).size();
		assertTrue(quantidadeFinal > quantidadeInicial, "Os novos parágrafos não foram carregados via AJAX.");
	}
}