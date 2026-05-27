package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPasswordTest extends BaseTest {

	@Test
	public void testarRecuperacaoDeSenha() {

		// 1. AÇÃO: Navegar para a página de Forgot Password
		driver.findElement(By.linkText("Forgot Password")).click();

		// 2. LOCALIZAR: Encontrar o campo de e-mail e o botão de envio
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement botaoEnviar = driver.findElement(By.id("form_submit"));

		// 3. AÇÃO: Digitar o e-mail
		// Diva: Sempre use um e-mail com formato válido para evitar validações de front-end

		campoEmail.sendKeys("teste.qa@estudos.com");
		System.out.println("E-mail preenchido.");

		// 4. AÇÃO: submeter o formulário
		botaoEnviar.click();

		// 5. VALIDAÇÃO: Verificar se a mensagem "Internal Server Error" aparece
		String corpoDaPagina = driver.findElement(By.tagName("h1")).getText();

		assertTrue(corpoDaPagina.contains("Internal Server Error"), 
			"ERRO: A mensagem de sucesso no envio do e-mail não apareceu!");

		System.out.println("Teste concluído: Solicitação de nova senha enviada.");
	}
}