package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JQueryMenusTest extends BaseTest {

	@Test
	public void testarNavegacaoMenuMultinivel() {

		// 1. AÇÃO: Navegar para a página de JQuery UI Menus
		driver.findElement(By.linkText("JQuery UI Menus")).click();

		// 2. CONFIGURAÇÃO: Precisamos de um Wait e da classe Actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions acao = new Actions(driver);

		// 3. LOCALIZAR: Itens do menu (enabled -> Downloads -> PDF)
        WebElement menuEnabled = driver.findElement(By.id("ui-id-3"));
        WebElement menuDownloads = driver.findElement(By.id("ui-id-4"));
        WebElement opcaoPDF = driver.findElement(By.id("ui-id-5"));

        // 4. LOGICA
        // Não podemos clicar direto no PDF. Precisamos "navegar" o mouse.
        // .moveToElement move o mouse, .pause dá tempo para a animação do JQuery abrir o submenu

        acao.moveToElement(menuEnabled)
        	.pause(Duration.ofMillis(500))
        	.moveToElement(menuDownloads)
        	.pause(Duration.ofMillis(500))
        	.click(opcaoPDF)
        	.build()
        	.perform();


       	System.out.println("Navegação multinível executada até o PDF.");

       	// 5. VALIDAÇÃO: Ao clicar no PDF gera um download ou recarega a página
       	// Vamos validar se o foco do driver ainda está na página correta ou se houve erro.

       	assertTrue(driver.getCurrentUrl().contains("menu"), "ERRO: A navegação no menu falhou!");
	}
}