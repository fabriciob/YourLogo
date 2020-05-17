package suitetest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import resources.Base;

public class SearchSuiteTest extends Base {
	
	//metodo será executado assim sempre antes de um caso de teste iniciar
	@BeforeMethod
	public void iniciaDriver() throws IOException {
		//recebendo driver instanciado pelo metodo da classe pai e atribuindo a variavel local
		driver = inicializaDriver();
		
		//carregando a pagina Your Logo
		driver.get(url);
		
		//maximizando a pagina
		driver.manage().window().maximize();
	}
	
	@Test
	public void validaBusca() {
		//instanciando um objeto do tipo HomePage para que possamos usar os elementos mapeados na classe com o PageFactory 
			// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
		HomePage hp = new HomePage(driver);
		
		//Caso de teste: Busca simples na página inicial clicando no botão buscar
		
		//Clicar na caixa de texto "Search"
		hp.searchBox().click();
		
		//Entrar com o texto "blouses"
		hp.searchBox().sendKeys("blouses");
		
		//Clicar no botão search (lupa)
		hp.searchButton().click();
		
		//instanciado um objeto do tipo SearchPage para validar o carregamento da página
		SearchPage sp = new SearchPage(driver);
		
		//validando se o titulo da página corresponde a página search page
		if (sp.getTitleSearchPage().equals(driver.getTitle())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//Fechando o navegador
		//driver.close();
	}
	
	@Test
	public void validaBuscaComEnter() {
		//instanciando um objeto do tipo HomePage para que possamos usar os elementos mapeados na classe com o PageFactory 
			// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
		HomePage hp = new HomePage(driver);
		
		//Caso de teste: Busca simples na página inicial pressionando Enter no teclado
		
		//Clicar na caixa de texto "Search"
		hp.searchBox().click();
		
		//Entrar com o texto "blouses"
		hp.searchBox().sendKeys("blouses");
		
		//O botão enter do teclado deve ser pressionado
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform(); 
		//Poderia ser utilizado:
		//hp.searchBox().sendKeys(Keys.ENTER);
		//mas pela finalidade de demonstração utilizei a classe Actions que nos permite executar ações realizadas com mouse ou teclado.
		
		//instanciado um objeto do tipo SearchPage para validar o carregamento da página
		SearchPage sp = new SearchPage(driver);
				
		//validando se o titulo da página corresponde a página search page
		if (sp.getTitleSearchPage().equals(driver.getTitle())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

		//Fechando o navegador
		//driver.close();
	}
	
	@Test
	public void validaBuscaComCampoVazio() {
		//instanciando um objeto do tipo HomePage para que possamos usar os elementos mapeados na classe com o PageFactory 
			// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
		HomePage hp = new HomePage(driver);
		
		//Caso de teste: Busca simples na página inicial com campo vázio
		
		//Clicar na caixa de texto "Search"
		hp.searchBox().click();
		
		//Clicar no botão search (lupa)
		hp.searchButton().click();
		
		//instanciado um objeto do tipo SearchPage para validar o texto exibido na pagina
		SearchPage sp = new SearchPage(driver);
		
		//definindo um explicit wait para garantir que a mensagem de keywork deve ser usada vai aparecer
		WebDriverWait dw = new WebDriverWait(driver, 5);
		dw.until(ExpectedConditions.visibilityOf(sp.alertEmptyMessage()));
		
		//validando se o texto apresentado corresponde ao alerta esperado
		if (sp.alertEmptyMessage().getText().equals("Please enter a search keyword")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//Fechando o navegador
		//driver.close();
	}
	
	@Test
	public void validaBuscaComPalavraSemResult() {
		//instanciando um objeto do tipo HomePage para que possamos usar os elementos mapeados na classe com o PageFactory 
			// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
		HomePage hp = new HomePage(driver);
	
		//Caso de teste: Busca simples na página inicial com uma palavra sem resultado
	
		//Clicar na caixa de texto "Search"
		hp.searchBox().click();
	
		//Entrar com o texto "zzzzz"
		hp.searchBox().sendKeys("zzzzz");
	
		//O botão enter do teclado deve ser pressionado
		hp.searchBox().sendKeys(Keys.ENTER);
	
		//instanciado um objeto do tipo SearchPage para validar se o resultado resultante é 0
		SearchPage sp = new SearchPage(driver);
		
		//definindo um explicit wait para garantir que a mensagem de keywork deve ser usada vai aparecer
		WebDriverWait dw = new WebDriverWait(driver, 5);
		dw.until(ExpectedConditions.visibilityOf(sp.resultSizeFound()));
		
		//validando se o texto apresentado corresponde ao alerta esperado
		if (sp.resultSizeFound().getText().equals("0 results have been found.")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//Fechando o navegador
		//driver.close();
	}
	
	@Test
	public void validaResultadosDaBusca() throws InterruptedException, IOException {
		//instanciando um objeto do tipo HomePage para que possamos usar os elementos mapeados na classe com o PageFactory 
			// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
		HomePage hp = new HomePage(driver);
		
		//Caso de teste: Busca simples na página inicial - verificação de resultados correspondentes a busca
		
		//Palavra utilizada na busca
		String busca = "dress";
		
		//Entrar com o texto "dress"
		hp.searchBox().sendKeys(busca);
		
		//O botão enter do teclado deve ser pressionado
		hp.searchBox().sendKeys(Keys.ENTER);
		
		//instanciado um objeto do tipo SearchPage para validar se os resultados correspondem a palavra da busca
		SearchPage sp = new SearchPage(driver);
		
		//inserindo delay para todos os resultados carregarem na página
		Thread.sleep(3000);
		
		//fazendo a verificação se a descrição dos elementos retornados tem a palavra dress 
		
		//carregando resultados individualmente em uma lista para interagir separadamente com cada um deles
		List<WebElement> resultados = sp.getListItemDescricoes();
		//Criando um iterador para correr os resultados da busca
		Iterator<WebElement> it = resultados.iterator();
		
		//criando uma estrutura de repetição para correr os elementos
		while (it.hasNext()) {
			//proximo resultado da lista (se for a primeira iteração move para o primeiro)
			WebElement resultado = it.next();
			//armazena a descrição do produto (em letras minusculas) em uma variavel
			String descricao = (resultado.getText().toLowerCase());
			
			//verifica se o texto da busca não está contido na descrição do produto
			if(!(descricao.contains(busca))) {
				
				//salvando um screenshot do bug na pasta do projeto no diretório \test-output\screenShotErrors\
				getScreenshot("SearchSuiteTest5");
				
				//Definindo esse caso de teste como falha
				Assert.assertFalse(true);
			}	
		}
		//definindo esse caso de teste como pass
		Assert.assertTrue(true);
	}
	
	@AfterClass
	public void fecharNavegadores() {
		//fechando os navegadores
		driver.quit();
	}
	
}
