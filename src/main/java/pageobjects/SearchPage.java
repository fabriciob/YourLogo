package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	private String title = "Search - My Store";
	
	
	public SearchPage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//mapeando os resultados da busca
	@FindBy(id = "center_column")
	private WebElement searchResultElements;
	
	//mapeando o alerta sobre a necessidade de se usar uma palavra na busca
	@FindBy(xpath="//p[@class='alert alert-warning']")
	private WebElement alertEmptyMessage;
	
	//mapeando a mensagem de quantidade de resultados encontrados
	@FindBy(xpath="//span[@class='heading-counter']")
	private WebElement resultSizeFound;
	
	//mapeando o botão x da janela de confirmação de item add
	@FindBy(xpath="//span[@class='cross']")
	private WebElement botaoFecharPopUp;
	
	//mapeando o menu do carrinho no canto superior esquerdo
	@FindBy(xpath="//b[contains(text(),'Cart')]")
	private WebElement menuCarrinho;
	
	
	
	
	
	//Metodo que retorna o alerta sobre a necessidade de se usar uma palavra na busca
	public WebElement alertEmptyMessage() {
		return alertEmptyMessage;
	}
	
	//Metodo que retorna o menu do carrinho no canto superior esquerdo
	public WebElement menuCarrinho() {
		return menuCarrinho;
	}
	
	//Metodo que retorna o elemento que contem os resultados da busca
	public WebElement searchResultElements() {
		return searchResultElements;
	}
	
	//Metodo que retorna a mensagem de quantidade de resultados encontrados
	public WebElement resultSizeFound() {
		return resultSizeFound;
	}
	
	//metodo que retorna o titulo da pagina (para validação)
	public String getTitleSearchPage() {
		return title;
	}
	
	//retorna os resultados completos individuais da busca
	public List<WebElement> getListItem(){
		List<WebElement> list = searchResultElements.findElements(By.xpath("//div[@class='product-container']"));
		return list;
	}
	
	//retorna os botões add to cart da lista de resultados
	public List<WebElement> getListItemBotaoAdd(){
		List<WebElement> list = searchResultElements.findElements(By.xpath("//div[@class='product-container']//span[contains(text(),'Add to cart')]"));
		return list;
	}
	
	//retorna os preços da lista de resultados
	public List<WebElement> getListItemPrecos(){
		List<WebElement> list = searchResultElements.findElements(By.xpath("//div[@class='product-container']//span[@class='price product-price']"));
		return list;
	}
	
	//retorna as descrições da lista de resultados
	public List<WebElement> getListItemDescricoes(){
		List<WebElement> list = searchResultElements.findElements(By.xpath("//div[@class='product-container']//span[@class='price product-price']"));
		return list;
	}	
	
	//retorna as descrições da lista de resultados
	public List<WebElement> getListItemMenuCarrinho(){
		List<WebElement> list = menuCarrinho.findElements(By.xpath("//dt[@class='first_item last_item']"));
		return list;
	}
	
	//Metodo que retorna o botão x da janela de confirmação de item add
	public WebElement botaoFecharPopUp() {
		return botaoFecharPopUp;
	}
	
}
