package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeolocationTest extends BaseTest {
	
	@Test
	public void testarObterLocalizacao() {

		// 1. AÇÃO: Navegar para a página de Geolocation
		driver.findElement(By.linkText("Geolocation")).click();


		// 2. AÇÃO: Clicar no botão "Where am I?"
		// Usaremos o seletor da tag button dentro da div principal
		driver.findElement(By.cssSelector(".example butto")).click();

		// 3. CONFIGURAÇÃO DE ESPERA:
		// A geolocalização pode demorar um pouco para ser processada pelo navegador

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 4. LOCALIZAR: Esperar as coordenadas aparecerem
		// Elas surgem em elementos com IDs 'lat-value' e 'long-value'
		WebElement latElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lat-value")));
		WebElement longElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("long-value")));

		// 5. CAPTURAR OS VALORES
		String latitude = latElement.getText();
		String longitude = longElement.getText();

		System.out.println("Latitude Encontrada: " + latitude);
		System.out.println("Longitude Encontrada: " + longitude);

		// 6. VALIDAÇÃO: Verificar se os valores não estão vazios
		// Como a localização exata depende de onde você está, validamos se há conteúdo.
		assertTrue(!latitude.isEmpty(), "ERRO: A latitude não foi capturada!");
		assertTrue(!longitude.isEmpty(), "ERRO: A longitude não foi capturada!");

		System.out.println("Teste concluído: Geolocalização obtida com sucesso!");


	}
}