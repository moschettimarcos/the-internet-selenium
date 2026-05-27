package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys; // Classe fundamental para simular o teclado
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSliderTest extends BaseTest {

	@Test
	public void testarMoverSlidercomTeclado() {

		// 1. AÇÃO: Navegar para a página de Horizontal Slider
		driver.findElement(By.linkText("Horizontal Slider")).click();

		// 2. LOCALIZAR: Encontrar o slider e o campo que mostra o valor numérico
		WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input"));
		WebElement valorExibido = driver.findElement(By.id("range"));

		// 3. LOGICA
		// Clicamos no slider para dar foco e usamos a tecla de seta para a direita
		// Cada toque na seta aumenta o valor em 0.5

		slider.click();

		String valorAlvo = "4";

		// Enquanto o texto na tela não for "4", continue apertando a seta para a direita

		while (!valorExibido.getText().equals(valorAlvo)) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
	
		System.out.println("O slider chegou ao valor desejado " + valorExibido.getText());
		
		// 4. VALIDAÇÃO: Confirmar se o valor final é exatamente o que queriamos
		assertEquals(valorAlvo, valorExibido.getText(), "ERRO: O slider parou no valor errado!");
	}
}