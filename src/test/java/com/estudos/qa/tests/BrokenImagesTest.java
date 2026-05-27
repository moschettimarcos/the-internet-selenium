package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest; // Importa a nossa configuração de navegador (Setup/Teardown)
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

// O "extends BaseTest" garanque que o navegador abra e feche automaticamente com a configuração realizada

public class BrokenImagesTest extends BaseTest {

	@Test
	public void testarImagensQuebradas() {

		// 1. AÇÃO: Navegar até a página "Broken Images"
		// Usar o linkText para encontrar o item 4 da lista na home
		driver.findElement(By.linkText("Broken Images")).click();


		// 2. LOCALIZAR: Pegar todas as imagens da página
		// A Tag HTML 'img' captura todas as fotos do site de uma vez

		List<WebElement> imagens = driver.findElements(By.tagName("img"));

		System.out.println("Total de imagens encontradas: " + imagens.size());

		// 3. LÓGICA DE QA
		// Para o Selenium, a imagem "existe" se a tag <img> estiver no código.
		// Para'nós QAs, ela só está "OK" se o anvegador conseguir mostrar os pixels.
		// O atributo 'naturalWidth' é 0 quando a iamgem está quebrada.

		int contadorQuebrados = 0;

		for (WebElement img : imagens) {
			// Pegamos o valor da largura natural da imagem
			String largura = img.getAttribute("naturalWidth");
			

			if (largura.equals("0")) {
				System.out.println("DEBUG: Imagem quebrada encontrada -> " + img.getAttribute("src"));
				contadorQuebrados++;
			} else {
				System.out.println("DEBUG: Imagem OK -> " + img.getAttribute("src"));
			}
		}

		// 4. VALIDAÇÃO: Garantir que o teste verificou ao menos uma imagem
		assertTrue(imagens.size() > 0, "A paǵina deveria ter imagens para testar.");
		System.out.println("Fim do teste. Total de imagens quebradas: " + contadorQuebrados);



	}
}  