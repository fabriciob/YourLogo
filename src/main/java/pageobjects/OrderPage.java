package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	private String title = "Order - My Store";
	
	
	public OrderPage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//mapeando o valor total da compra
	@FindBy(xpath = "//span[@id='total_price']")
	private WebElement valorTotalCompra;
	
	//mapeando o valor total dos itens da compra
	@FindBy(xpath = "//td[@id='total_product']")
	private WebElement valorTotalItensCompra;
	
	//mapeando a lista de descrições dos itens
	@FindBy(xpath = "//td[@class='cart_description']//p[@class='product-name']")
	private List<WebElement> descricoesItems;
	
	//mapeando a lista de valores unitarios
	@FindBy(xpath = "//td[@class='cart_unit']//span[@class='price']")
	private List<WebElement> valoresUnitarios;
	
	//mapeando a lista de valor total do numero do mesmo item na lista
	@FindBy(xpath = "//td[@class='cart_total']//span[@class='price']")
	private List<WebElement> valorTotalDeCadaItem;
	
	//mapeando a lista de quantidade total de cada item na lista
	@FindBy(xpath = "//td[@class='cart_quantity text-center']//input[@class='cart_quantity_input form-control grey']")
	private List<WebElement> quantTotalDeCadaItem;;
	
	//mapeando a lista de botoes excluir itens da lista
	@FindBy(xpath = "//td[@class='cart_delete text-center']//i[@class='icon-trash']")
	private List<WebElement> botoesExcluir;
	
	//mapeando o valor total do frete
	@FindBy(xpath = "//td[@id='total_shipping']")
	private WebElement valorFrete;
	
	//mapeando a mensagem de carrinho vazio
	@FindBy(xpath = "//p[@class='alert alert-warning']")
	private WebElement carrinhoVazioMsg;
	
	
	
	
	//Metodo que retorna a mensagem de carrinho vazio
	public WebElement carrinhoVazioMsg() {
		return carrinhoVazioMsg;
	}
	
	//Metodo que retorna o valor total da compra
	public WebElement valorTotalCompra() {
		return valorTotalCompra;
	}
	
	//Metodo que retorna o valor total do frete
	public WebElement valorFrete() {
		return valorFrete;
	}
	
	//Metodo que retorna o valor total dos itens da compra
	public WebElement valorTotalItensCompra() {
		return valorTotalItensCompra;
	}
	
	//Metodo que retorna a lista de descrições dos itens
	public List<WebElement> descricoesItems() {
		return descricoesItems;
	}
	
	//Metodo que retorna a lista de valores unitarios
	public List<WebElement> valoresUnitarios() {
		return valoresUnitarios;
	}
	
	//Metodo que retorna a lista de valor total do numero do mesmo item na lista
	public List<WebElement> valorTotalDeCadaItem() {
		return valorTotalDeCadaItem;
	}
	
	//Metodo que retorna a lista de quantidade total de cada item na lista
	public List<WebElement> quantTotalDeCadaItem() {
		return quantTotalDeCadaItem;
	}
	
	//Metodo que retorna a lista de botoes excluir itens da lista
	public List<WebElement> botoesExcluir() {
		return botoesExcluir;
	}
	
}
