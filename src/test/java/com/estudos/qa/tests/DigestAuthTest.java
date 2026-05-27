package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest; // Importa a nossa configuração de navegador
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

// O 'extends BaseTest' abre o navegador na Home automaticamente

public class DigestAuthTest extends BaseTest {

	@Test
	public void testarAutenticacaoDigest() {

		//1. DICA DE QA:
		// ASsim como no Basic Auth, o pop-up Digest Autentication não é mapeável.
		// Usamos o formato: https://usuario:senha@url

		String usuario = "admin";
		String senha = "admin";


		// Construímos a URL específica para o Item 8 da lista

        String url = "https://" + usuario + ":" + senha + "@the-internet.herokuapp.com/digest_auth";


        // 2. AÇÃO: Navegar diretamente para a página já autenticada
        driver.get(url);

        // 3. LOCALIZAR: Encontrar a mensagem de sucesso
        // Usamos o seletor da tag 'p', que contém a mensagem de confirmação

        WebElement mensagem = driver.findElement(By.cssSelector("p"));

        // 4. VALIDAÇÃO: Verificar se o texto esperado aparece na tela
        String texto = mensagem.getText();
        assertTrue(texto.contains("Congratulations!"),
         "ERRO: A autenticação Digest falhou ou a mensagem mudou. Encontrado: " + texto);

        System.out.print("Atenticação Digest realizada com sucesso!");

	}
}
