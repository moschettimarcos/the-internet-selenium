package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.IOException;

public class FileUploadTest extends BaseTest {

	private static final By FILE_UPLOAD_LINK = By.linkText("File Upload");
	private static final By INPUT_ARQUIVO = By.id("file-upload");
	private static final By BTN_SUBMIT = By.id("file-submit");
	private static final By ARQUIVOS_UPLOADED = By.id("uploaded-files");

	@Test
	@DisplayName("Deve fazer upload de um arquivo gerado em tempo de execução")
	public void testarUploadDeArquivo() throws IOException {
		driver.findElement(FILE_UPLOAD_LINK).click();

		File arquivoParaUpload = File.createTempFile("arquivo_teste", ".txt");
		arquivoParaUpload.deleteOnExit();

		driver.findElement(INPUT_ARQUIVO).sendKeys(arquivoParaUpload.getAbsolutePath());
		driver.findElement(BTN_SUBMIT).click();

		String nomeNoSite = driver.findElement(ARQUIVOS_UPLOADED).getText().trim();
		assertEquals(arquivoParaUpload.getName(), nomeNoSite, "O nome do arquivo exibido no site está incorreto.");
	}
}