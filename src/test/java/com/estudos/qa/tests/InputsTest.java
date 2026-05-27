package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest extends BaseTest {

		@Test
		public void testarInteracaoComCampoNumerico() {

			// 1. AÇÃO: Navegar para a página de Inputs
			driver.findElement(By.linkText("Inputs")).click();

			// 2. LOCALZIAR: Encontrar o campo de entrada (input type="number")
			WebElement campoInput = driver.findElement(By.tagName("input"));

			// 3. AÇÃO: Digitar um número no campo
			String numeroParaDigitar = "12345";
			campoInput.sendKeys(numeroParaDigitar);

			System.out.println("Número digitado: " + numeroParaDigitar);

			// 4. VALIDAÇÃO:
			// Diferente de um texto comum, o que digitamos em um input não é capturado com .getText().
			// Precisamos capturar o atributo 'value'.

			String valorCapturado = campoInput.getAttribute("value");

			assertEquals(numeroParaDigitar, valorCapturado, 
				"Erro: O valor no campo de input não corresponde com o que foi digitado!");

			// 5. EXTRA: tentar digitar letras em um campo númerico (Cenário Negativo)
			campoInput.clear();
			campoInput.sendKeys("abc");

			String valorAposLetra = campoInput.getAttribute("value");
			System.out.println("Valor apos tentar digitar letras: \"" + valorAposLetra + "\"");
			assertEquals("", valorAposLetra, "ERRO: O campo aceitou letras quando deveria aceitar apenas números!");
		}
}
