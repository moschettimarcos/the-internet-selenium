package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest; // Importa a nossa base de configuração
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

// O 'extends BaseTest' faz toda a mágica: ele abre o navegador antes de começar 

public class ABTestingTest extends BaseTest {

	@Test
	public void testarConteudoDinamicoAB() {
	
		// 1. LOCALIZAR E CLICAR: Encontra o link na home
		// By.linkText é ideal para os nomes de listas do Herokuapp
		
		WebElement linkAB = driver.findElement(By.linkText("A/B Testing"));
		linkAB.click();
	

		// 2. COMANDO: Capturar o texto do título (tag h3)
		// Usamos getText() para ler o que está escrito no elemento
		String textoH3 = driver.findElement(By.tagName("h3")).getText();


		// 3. VALIDAÇÃO FLEXÍVEL:
		// Como o QA sabe que o título muda (Control vs Variation)m usamos o .contains()
		// Isso garante que o teste seja resiliente a mudanças dinâmicas
		
		assertTrue(textoH3.contains("A/B Test"),"ERRO: O título não contém 'A/B Test'. Encontrado: " + textoH3);
		
		System.out.println("Validação da Seção 1 concluída com sucesso!");


	}	
}
