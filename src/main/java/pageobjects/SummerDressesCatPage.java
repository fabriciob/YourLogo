package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDressesCatPage {

	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	private String title = "Summer Dresses - My Store";
	
	public SummerDressesCatPage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//mapeando os precos dos produtos da pagina
	@FindBy(xpath="//ul[@class='product_list grid row']/li//div/div[2]/div[1]/span[1]")
	private List<WebElement> precosProduto;
			
	
	//mapeando os botoes add to cart
	@FindBy(xpath="//ul[@class='product_list grid row']/li/div/div[2]/div[2]/a[1]")
	private List<WebElement> botoesAdd;
	
	//mapeando botão x fechar do popup da tela de confirmacao de produto add
	@FindBy(xpath="//span[@class='cross']")
	private WebElement botaoFecharPopUp;
	
	//mapeando a caixa de texto de pesquisa
	@FindBy(id="search_query_top")
	private WebElement searchBox;
	
	//mapeando o menu carrinho no canto superior direito
	@FindBy(xpath="//b[contains(text(),'Cart')]")
	private WebElement menuCarrinho;
	
	
	
	//Metodo que retorna o menu carrinho no canto superior direito
	public WebElement menuCarrinho() {
		return menuCarrinho;
	}
	
	//Metodo que retorna os botoes add to cart
	public List<WebElement> botoesAdd() {
		return botoesAdd;
	}
	
	//Metodo que retorna a area dos itens da página
	public List<WebElement> precosProduto() {
		return precosProduto;
	}
	
	//Metodo que retorna a area dos itens da página
	public WebElement botaoFecharPopUp() {
		return botaoFecharPopUp;
	}
	
	//Metodo que retorna a area dos itens da página
	public WebElement searchBox() {
		return searchBox;
	}
	
	
}
