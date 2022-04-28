package br.ce.pavila.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class buscarFaixaPage {

	public WebDriver driver;
	
	public void acessarUrl() {
		driver = new ChromeDriver();
		driver.get("https://www.spotify.com/br/");
		driver.manage().window().maximize();
	}
		
	public void logarConta(String email, String senha) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-password")).sendKeys(senha);
		driver.findElement(By.id("login-button")).click();
	}

	public void validarUsuarioLogado(String usuario) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'Type__TypeElement-goli3j-0 eHCcSU EeWTFG_vxLI5QJc1TH4F']")));
		String userName = driver.findElement(By.xpath("//span[@class = 'Type__TypeElement-goli3j-0 eHCcSU EeWTFG_vxLI5QJc1TH4F' and contains(text , '')]")).getText();
		Assert.assertEquals(usuario, userName);
	}

	public void fecharModal(){
		String modal = "//button[@class = 'Button-sc-1dqy6lx-0 ksogXh x_mFp6qsLw0AgSON4gdy aS3WvPBqyZdP1S28pn6r' and contains(text , '')]";
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modal)));
		driver.findElement(By.xpath(modal)).click();
	}

	public void buscarFaixa(String faixa){
		driver.findElement(By.linkText("Buscar")).click();
		driver.findElement(By.xpath("//input[@class = 'Type__TypeElement-goli3j-0 ebHsEf QO9loc33XC50mMRUCIvf']")).sendKeys(faixa);
	}

	public void validaFaixaTocando(String status){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@class = 'mMx2LUixlnN_Fu45JpFB rkw8BWQi3miXqtlJhKg0']")).click();
		if(status == "Tocando"){
			driver.findElement(By.xpath("//button[@class = 'vnCew8qzJq3cVGlYFXRI' and @aria-label = 'Pausar']")).isEnabled();
		}else{
			driver.findElement(By.xpath("//button[@class = 'vnCew8qzJq3cVGlYFXRI' and @aria-label = 'Play']")).isEnabled();
		}
	}

	public void fecharBrowser(){
		driver.quit();
	}
}
