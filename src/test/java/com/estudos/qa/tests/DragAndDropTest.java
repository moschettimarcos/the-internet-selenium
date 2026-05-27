package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // Para movimentos complexos de mouse
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DragAndDropTest extends BaseTest {

	@Test
	public void testarArrastarESoltar() {

		// 1. AÇÃO: Navegar para a página de Drag and Drop

		driver.findElement(By.linkText("Drag and Drop")).click();

		// 2. LOCALIZAR: Identificar os dois quadrados (A e B)

		WebElement colunaA = driver.findElement(By.id("column-a"));
		WebElement colunaB = driver.findElement(By.id("column-b"));


		// 3. COMANDO: Usar a classe Actions para Drag and Drop - pegar e arrastar
		// Dica QA: Criamos o objeto acao passando o nosso driver

		Actions acao = new Actions(driver);

		// 4. EXECUTAR: Arrastar A para cima de B
		// .dragAndDrop(origem, destino) simplifica o processo de clickAndHold + moveToelement + release
		acao.dragAndDrop(colunaA, colunaB).perform();
		System.out.println("Ação de Drag and Drop Executada.");

		// 5. VALIDAÇÃO: Após o arraste, o texto dentro da coluna A deve ter mudado para "B"

		// O site troca o conteúdo dos cabeçalhos (tag <header>) após o movimento bem-sucedido. 

		String textoColunaA = colunaA.findElement(By.tagName("header")).getText();
		assertEquals("B", textoColunaA, "ERRO: O quadrado A não foi trocado pelo B!");

		System.out.println("Validação Concluída: Coluna A agora contém o texto: " + textoColunaA);
	}
}