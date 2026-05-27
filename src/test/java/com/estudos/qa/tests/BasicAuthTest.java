package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthTest extends BaseTest {

	private static final By PARAGRAFO_SUCESSO = By.cssSelector("p");
	private static final String URL_AUTENTICACAO = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

	@Test
	@DisplayName("Deve realizar autenticação Basic Auth injetando as credenciais na URL")
	public void testarAutenticacaoBasica() {
		driver.get(URL_AUTENTICACAO);

		String textoEncontrado = driver.findElement(PARAGRAFO_SUCESSO).getText();
		assertTrue(textoEncontrado.contains("Congratulations!"), 
			"A autenticação falhou. O texto de sucesso não foi encontrado.");
	}
}