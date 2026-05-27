package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; // COMANDO NOVO: Para executar scripts de scroll
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloatingMenuTest extends BaseTest {

	@Test
	public void testarMenuFlutuanteAposScroll() {

		// 1. AÇÃO: Navegar para a página de Floating Menu
		driver.findElement(By.linkText("Floating Menu")).click();

		// 2. DICA: Para testar se o menu flutua, primeiro precisamos rolar a página para baixo.
		// O Selenium não tem um comando 'scroll' nativo, então usamos o JavascriptExecutor.

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Rola a página para abixo em 2000 pixels
		js.executeScript("window.scrollBy(0,2000)");
		System.out.println("Scroll de 2000 pixels realizado.");

		// 3. LOCALIZAR: Encontrar o menu flutuante (id="menu")
		WebElement menu = driver.findElement(By.id("menu"));

		// 4. VALIDAÇÃO: O menu ainda está visível na tela após o scroll?
		// O comando .isDisplayed() verifica se o elemento está no campo de visão do usuário.

		assertTrue(menu.isDisplayed(), "ERRO: O menu deveria estar visível mesmo após o scroll!");

		// 5. AÇÃO: Tentar clicar em um dos links do menu (ex: 'Home')
		// Se o menu não fosse flutuante, o Selenium daria erro porque o link estaria "fora da tela".
		driver.findElement(By.linkText("Home")).click();

		// Validar se voltamos para a URL principal ou se o link foi acionado
		assertTrue(driver.getCurrentUrl().contains("floating_menu"), "ERRO: O clique no emnu falhou!");

		System.out.println("Teste concluído: Menu flutuante validado com sucesso!");
	}
}