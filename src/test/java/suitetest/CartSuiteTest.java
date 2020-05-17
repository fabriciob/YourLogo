package suitetest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
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
import pageobjects.OrderPage;
import pageobjects.SearchPage;
import pageobjects.SummerDressesCatPage;
import resources.Base;

public class CartSuiteTest extends Base{

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
			public void validaInsercaoDeItem() throws InterruptedException {
				//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
					// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
				HomePage hp = new HomePage(driver);
				
				//posicionando cursor no campo de busca
				hp.searchBox().click();
				
				//Caso de teste: Inclusão de 1 produto no carrinho de compra
				
				//Buscar pela palavra "shirt"
				hp.searchBox().sendKeys("shirt");
				hp.searchButton().click();
				
				//instancia da pagina search
				SearchPage sp = new SearchPage(driver);
				
				//obtendo os itens para manipulação
				WebElement itemResult = sp.getListItem().get(0);
				WebElement botaoAdd = sp.getListItemBotaoAdd().get(0);
				
				//movendo o cursor em cima do resultado para o botão add aparecer
				Actions act = new Actions(driver);
				act.moveToElement(itemResult).build().perform();
				
				//Clicar no botão "Add to cart"
				botaoAdd.click();
				
				//fechando o pop up de confirmação de item adicionado ao carrinho
				WebDriverWait dw = new WebDriverWait(driver, 5);
				dw.until(ExpectedConditions.visibilityOf(sp.botaoFecharPopUp()));
				
				sp.botaoFecharPopUp().click();
				
				//Verificando se o item está adicionado ao carrinho
				//Clicar no botão "Cart"
				sp.menuCarrinho().click();
				
				//instancia da pagina Order
				OrderPage op = new OrderPage(driver);			
				
				//delay de 2 segundos
				Thread.sleep(2000);
				
				//verificando se existe 1 item no carrinho
				if (op.descricoesItems().size() == 1) {
					//teste passou
					Assert.assertTrue(true);
				} else {
					//teste não passou
					Assert.assertTrue(false);
				}
				
				//Fechando o navegador
				//driver.close();
			}
			
			@Test
			public void validaSomaQuantidadeNoCarrinho() throws InterruptedException {
				//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
					// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
				HomePage hp = new HomePage(driver);
				
				//Caso de teste: Incluir itens ao carrinho e verificar se o valor total da compra está correto
				
				//Acessar a categoria Summer Dresses no menu principal
				Actions act = new Actions(driver);
				act.moveToElement(hp.menuDresses()).build().perform();
				
				//definindo um explicit wait para garantir que o elemento vai estar vísivel na pagina
				WebDriverWait dw = new WebDriverWait(driver, 5);
				dw.until(ExpectedConditions.visibilityOf(hp.menuSummerDresses()));
				
				hp.menuSummerDresses().click();
				
				//instancia da pagina summer dresses
				SummerDressesCatPage sdcp = new SummerDressesCatPage(driver);
				
				//calculando o preço dos produtos somados para comparação
				//adicionando produtos ao carrinho
				
				//Obtendo a lista de preços dos produtos encontrados para calcular e comparar no final
				List<WebElement> precos = sdcp.precosProduto();
				Iterator<WebElement> itp = precos.iterator();
				
				//Obtendo a lista de botoes de add ao carrinho que serão clicados
				List<WebElement> botoes = sdcp.botoesAdd();
				Iterator<WebElement> itb = botoes.iterator();
				
				//variavel utilizada para somar o valor dos produtos adicionados
				double valorTotal = 0;
				
				//steps que serão realizados a baixo
				//Clicar no botão "Add to cart" do primeiro item
				//Clicar no botão fechar
				//Clicar no botão "Add to cart" do segundo item
				//Clicar no botão fechar
				//Clicar no botão "Add to cart" do terceiro item
				//Clicar no botão fechar

				while (itp.hasNext()) {
					//obtendo os elementos preço e botão individualmente para interagir individualmente com eles nessa iteração
					WebElement precoProduto = itp.next();
					WebElement botaoProduto = itb.next();
					
					//removendo o $ do preço para fazer o calculo e	
					//somando o valor atual da soma dos produtos com o valor do produto que sera adicionado ao carrinho
					valorTotal += Double.parseDouble(precoProduto.getText().substring(1));
					
					//criando um objeto actions para mover o cursor do mouse sobre o elementos quando for necessário
					Actions a = new Actions(driver);
					
					//movendo o cursor sobre o preço para fazer o botão add to cart ficar visível
					a.moveToElement(precoProduto).build().perform();
					
					//clicando no botão add to cart
					botaoProduto.click();
					
					//usando um explicit wait para garantir que o botão fechar da tela de confirmação de produto adicionado apareça
					dw.until(ExpectedConditions.visibilityOf(sdcp.botaoFecharPopUp()));
					//fechando a janela de confirmação de produto adiocionado
					sdcp.botaoFecharPopUp().click();
					
					//movendo o cursor do mouse para outro elemento da página para que o preço do proximo produto fique visivel novamente.
					a.moveToElement(sdcp.searchBox()).build().perform();
				}
				
				//Acessar o carrinho de compras e verificar o valor total
				//clicando no menu carrinho
				sdcp.menuCarrinho().click();
				
				//instancia da pagina Order
				OrderPage op = new OrderPage(driver);
				
				//somando valor total ao valor do frete
				valorTotal += Double.parseDouble(op.valorFrete().getText().substring(1));
				
				//validando se o valor total somado é igual ao valor totoal da compra
				if ((Double.parseDouble(op.valorTotalCompra().getText().substring(1))) == valorTotal) {
					// teste passou
					Assert.assertTrue(true);
				} else {
					// teste não passou
					Assert.assertTrue(false);
				}
				
				//Fechando o navegador
				//driver.close();
			}
			
			@Test
			public void validaInclusaoEExclusaoItens() throws InterruptedException {
				//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
					// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
				HomePage hp = new HomePage(driver);
			
				//Caso de teste: Incluir itens ao carrinho e esvaziar o carrinho
			
				//Acessar a categoria Summer Dresses no menu principal
				Actions act = new Actions(driver);
				act.moveToElement(hp.menuDresses()).build().perform();
			
				//definindo um explicit wait para garantir que o elemento vai estar vísivel na pagina
				WebDriverWait dw = new WebDriverWait(driver, 5);
				dw.until(ExpectedConditions.visibilityOf(hp.menuSummerDresses()));
			
				hp.menuSummerDresses().click();
				
				//instancia da pagina Summer Dresses
				SummerDressesCatPage sdcp = new SummerDressesCatPage(driver);
				
				//Obtendo a lista de botoes de add ao carrinho que serão clicados
				List<WebElement> botoes = sdcp.botoesAdd();
				Iterator<WebElement> itb = botoes.iterator();
				
				//Obtendo a lista de preços dos produtos encontrados para posicionar o cursor e fazer o botão add aparecer
				List<WebElement> precos = sdcp.precosProduto();
				Iterator<WebElement> itp = precos.iterator();
				
				//contador para controlar o numero de itens adicionado ao carrinho
				int count = 1;
				
				//steps que serão realizados a baixo
				//Clicar no botão "Add to cart" do primeiro item
				//Clicar no botão fechar
				//Clicar no botão "Add to cart" do segundo item
				//Clicar no botão fechar
				
				while (itb.hasNext() || count == 2) {
					
					//obtendo os elementos dos botões e preços individualmente para interagir com eles nessa iteração
					WebElement botaoProduto = itb.next();
					WebElement precoProduto = itp.next();
					
					//criando um objeto actions para mover o cursor do mouse sobre o elementos quando for necessário
					Actions a = new Actions(driver);
					
					//movendo o cursor sobre o preço para fazer o botão add to cart ficar visível
					a.moveToElement(precoProduto).build().perform();
					
					//clicando no botão add to cart
					botaoProduto.click();
					
					//usando um explicit wait para garantir que o botão fechar da tela de confirmação de produto adicionado apareça
					dw.until(ExpectedConditions.visibilityOf(sdcp.botaoFecharPopUp()));
					//fechando a janela de confirmação de produto adiocionado
					sdcp.botaoFecharPopUp().click();
					
					//movendo o cursor do mouse para outro elemento da página para que o preço do proximo produto fique visivel novamente.
					a.moveToElement(sdcp.searchBox()).build().perform();
					
					//incrementando a variável count
					count++;
				}
				
				//Acessar carrinho de compras
				//clicando no menu carrinho
				sdcp.menuCarrinho().click();
				
				//instancia da pagina Order
				OrderPage op = new OrderPage(driver);
				
				//obtendo a lista de botões de excluir os produtos
				List<WebElement> botoesExcluir = op.botoesExcluir();
				itb = botoesExcluir.iterator();
				
				//steps que serão realizados a baixo
				//Clicar no botão "remover item" (lixeira) do primeiro item adicionado
				//Clicar no botão "remover item" (lixeira) do segundo item adicionado
				
				while (itb.hasNext()) {
					//obtendo os elementos dos botões individualmente para interagir com eles nessa iteração
					WebElement botao = itb.next();
					
					//clicando no botão excluir
					botao.click();
					
					//delay para a exclusão ser feita
					Thread.sleep(2000);
				}
				
				//verificando se a mensagem de carrinho vazio está aparecendo
				
				//usando um explicit wait para garantir que o botão fechar da tela de confirmação de produto adicionado apareça
				dw.until(ExpectedConditions.visibilityOf(op.carrinhoVazioMsg()));
				
				//validando se a mensagem de carrinho vazio está sendo exibido
				if ((op.carrinhoVazioMsg().getText().equals("Your shopping cart is empty."))) {
					// teste passou
					Assert.assertTrue(true);
				} else {
					// teste não passou
					Assert.assertTrue(false);
				}
				
			}
			
			@AfterClass
			public void fecharNavegadores() {
				//fechando os navegadores
				driver.quit();
			}
	
}
