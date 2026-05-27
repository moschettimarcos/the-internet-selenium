package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // COMANDO NOVO: Para ações complexas de mouse
import org.openqa.selenium.Alert;              // COMANDO NOVO: Para lidar com alertas
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextMenuTest extends BaseTest {


	@Test
	public void testarCliqueDireitoEAlerta() {

		// 1. AÇÃO: Navegar para a paǵina de Context Menu
		driver.findElement(By.linkText("Context Menu")).click();


		// 2. LOCALIZAR: Encontrar a área (o quadrado pontilhado) obde clicaremos
		WebElement areaDeClique = driver.findElement(By.id("hot-spot"));

		// 3. COMANDO NOVO: Class Actions
		// O Selenium precisa dessa classe para simular movimentos que não são cliques simples

		Actions acao = new Actions(driver);

		// Realiza o clique com o botão direito (contextClick) no elemento e executa (.perform)

		acao.contextClick(areaDeClique).perform();
		System.out.println("Clique com o botão direito realizado.");


		// 4. COMANDO NOVO: Lidar com o Alerta (Pop-up do navegador)
		// Quando o alerta aparece, o Selenium perde o foco do HTML. Precisamos "mudar" para o alerta.

		Alert alerta = driver.switchTo().alert();

		// 5. VALIDAÇÃO: Verificar o texto dentro do alerta
		String textoDoAlerta = alerta.getText();
		assertEquals("You selected a context menu", textoDoAlerta, "ERRO: O texto do alerta está incorreto!");

		// 6. AÇÃO: Aceitar (Clicar no OK) do alerta
		alerta.accept();

		System.out.print("Alerta aceito com sucesso.");



	}

}