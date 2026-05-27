package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert; // Classe específica para lidar com janelas nativas
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertsTest extends BaseTest {

	@Test
	public void testarDiferentesTiposDeAlertas() {

		// 1. AÇÃO: Navegar para a página de JavaScript Alerts
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		
		// --- TIPO 1: JS ALERT (Apenas um botão de OK)
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		// Muda o foco do driver para a janelinha do browser
		Alert alertaSimples = driver.switchTo().alert();
		System.out.println("Texto de alerta: " + alertaSimples.getText());

		alertaSimples.accept(); // Clica no botão OK

		String resultado1 = driver.findElement(By.id("result")).getText();
		assertEquals("You successfully clicked an alert", resultado1);

		// --- TIPO 2: JS CONFIRM (Bõtões OK e Cancelar)
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alertaConfirmacao = driver.switchTo().alert();
		alertaConfirmacao.dismiss(); // Simula o clique no botão "Cancelar"

		String resultado2 = driver.findElement(By.id("result")).getText();
		assertEquals("You clicked: Cancel", resultado2);

		// --- TIPO 3: JS PROMPT (Campo de texto + OK/CANCELAR)
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

		Alert alertaPrompt = driver.switchTo().alert();
		String mensagem = "Desafio Selenium Concluído!";

		alertaSimples.sendKeys(mensagem); // Digita no campo de texto do alerta
		alertaPrompt.accept();

		String resultado3 = driver.findElement(By.id("result")).getText();
		assertEquals("You entered: " + mensagem, resultado3);

		System.out.println("Todos os tipos de alertas validados com sucesso!");

	}
}