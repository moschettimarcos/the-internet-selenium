package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends BaseTest {

	private static final By DROPDOWN_LINK = By.linkText("Dropdown");
	private static final By DROPDOWN_ELEMENT = By.id("dropdown");

	@Test
	@DisplayName("Deve selecionar opções no menu dropdown via texto e índice")
	public void testarSelecaoNoDropdown() {
		driver.findElement(DROPDOWN_LINK).click();
		
		Select dropdown = new Select(driver.findElement(DROPDOWN_ELEMENT));
		dropdown.selectByVisibleText("Option 1");
		String opcaoSelecionada = dropdown.getFirstSelectedOption().getText();
		assertEquals("Option 1", opcaoSelecionada, "A Opção 1 não foi selecionada com sucesso.");

		dropdown.selectByIndex(2);
		String novaOpcao = dropdown.getFirstSelectedOption().getText();
		assertEquals("Option 2", novaOpcao, "A Opção 2 não foi selecionada pelo índice com sucesso.");
	}
}
