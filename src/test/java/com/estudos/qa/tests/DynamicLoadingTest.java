package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;


public class DynamicLoadingTest extends BaseTest {

	@Test
	public void testarCarregamentoDinamico() {

		//1. AÇÃO: Navegar para a página de Dynamic Load
		driver.findElement(By.linkText("Dynamic Loading")).click();

		// 2. AÇÃO: Selecionar o Exemplo 2 (Elemento renderizado após o fato)
		// Este é o mais difícil, pois o "Hello World" não existe no código até o fim da barra
		driver.findElement(By.partialLinkText("Example 2")).click();

		// 3. AÇÃO: Clicar no botão Start
		driver.findElement(By.cssSelector("#start button")).click();

		// 4. CONFIGURAÇÃO DA ESPERA
		// Criamos uma espera de até 10 segundos. O Selenium vai verificar repetidamente se o elemento apareceu.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 5. COMANDO DE ESPERA: Aguarda até que o texto "Hello World!" fique visível
		// O ID do elemento final é 'finish'
		WebElement textoFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

		// 6. VALIDAÇÃO: Verificar se o texto capturado é o esperado
		assertEquals("Hello World!", textoFinal.getText(), "ERRO: O texto de finalização não apareceu corretamente!");
		System.out.println("Teste de Carregamento Dinâmico concluído: 'Hello World!' detectado." );

	}
}