package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest; // Importa a nossa configuração de navegador
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

// O 'extends BaseTest' faz a magina de abrir o navegador e o site na home

public class ChallengingDomTest extends BaseTest {


	@Test
	public void testarElementosComIdsDinamicos() {

		// 1. AÇÃO: Navegar para a página "Challenging DOM"
		driver.findElement(By.linkText("Challenging DOM")).click();

		// 2. DESAFIO DE QA: Se você inspecionar os botões laterais, verá IDs malucos como id="09823-asdf"
		// Eles mudam a cada F5!
		// Solução: Vamos ignorar o ID e focar na Classe ou no Texto.


		// 3. AÇÃO: Clicar no botão azul (o primeiro da lista)
		// Usamos By.className pois a classe "button" é fixa, o ID não.

		WebElement botaoAzul = driver.findElement(By.className("button"));
		botaoAzul.click();
		System.out.println("Botão Azul clicado com sucesso usando classe fixa.");

		// 4. AÇÃO: Clicar no botão vermelho (que tem a classe 'alert')
		// Usamos XPath com "contains" para achar um elemento que tenha 'alert' na classe

		WebElement botaoVermelho = driver.findElement(By.xpath("//a[contains(@class, 'alert')]"));
		botaoVermelho.click();
		System.out.println("Botão Vermelho clicado usando XPath parcial.");

		// 5. AÇÃO: Clicar no botão verde (que tem a classe 'sucess')

		WebElement botaoVerde = driver.findElement(By.xpath("//a[contains(@class, 'success')]"));
		botaoVerde.click();
		System.out.println("Botão Verde clicado usando XPath parcial.");


		// 6. VALIDAÇÃO: Verificar se a tabela de dados está visível
		// Mesmo com os botões budando, a estrutura da tabela é estável.

		boolean tabelaVisivel = driver.findElement(By.tagName("table")).isDisplayed();
		assertTrue(tabelaVisivel, "ERRO: A tabela deveria estar visível na página!");

		System.out.println("Teste de DOM desafiador finalizado com sucesso!");

	}

}