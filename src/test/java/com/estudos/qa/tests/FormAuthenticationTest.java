package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormAuthenticationTest extends BaseTest {

	@Test
	public void testarLoginComSucesso() {
	

		// 1. AÇÃO: Navegar para a página de Form Authentication
		driver.findElement(By.linkText("Form Authentication")).click();


		// 2. DADOS DE TESTE (Fornecidos na própria página)
		String usuario = "tomsmith";
		String senha = "SuperSecretPassword!";

		// 3. LOCALIZAR: Campos de input e botão de login

		WebElement campoUsuario = driver.findElement(By.id("username"));
		WebElement campoSenha = driver.findElement(By.id("password"));
		WebElement botaoLogin = driver.findElement(By.cssSelector("button[type='submit']"));

		// 4. AÇÃO: pREENCHER OS DADOS E CLICAR
		campoUsuario.sendKeys(usuario);
		campoSenha.sendKeys(senha);
		botaoLogin.click();

		// 5. LOCALICAR FEEDBACK: O site exibe uma abrra verde de sucesso
		// Usamos a classe 'flash success' para identificar
		WebElement mensagemSucesso = driver.findElement(By.id("flash"));

		// 6. VALIDAÇÃO: Verificar se o texto de sucesso está presente

		String textoMensagem = mensagemSucesso.getText();
		assertTrue(textoMensagem.contains("You logged into a secure area!"), "ERRO: A mensagem de sucesso não apareceu! Texto atual: " + textoMensagem);

		// 7. AÇÃO EXTRA: validar se o botão de Logout agora está visível
		boolean botaoLogoutPresente = driver.findElement(By.linkText("Logout")).isDisplayed(); // Retorna True se estiver presente ou False senão estiver
		assertTrue(botaoLogoutPresente, "ERRO: O botão de Logout deveria estar visível após o login.");

		System.out.println("Teste concluído: Login realizado e validado com sucesso!");
	}
}