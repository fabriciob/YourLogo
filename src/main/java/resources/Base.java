package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Base {
	
	public static WebDriver driver = null; //instancia do driver que será utilizado pelas classes de casos de teste (será passado por herança)
	public String url; //variavel de escopo da classe para armazenar a url onde os testes serão feitos
	public Properties prop;
	
	public WebDriver inicializaDriver() throws IOException {
		
		//a variavel prop está "linkada" ao arquivo data.properties que é onde estão definidos os parametros dos testes
		prop = new Properties();
		FileInputStream fis = new FileInputStream(new File(".\\src\\main\\java\\resources\\data.properties").getAbsolutePath()); 
		prop.load(fis);
		
		//Obtendo o tipo de navegador que será utilizado nos testes do arquivo data.properties
		String browser = prop.getProperty("browser");
		
		//setando o valor da url definida no arquivo data.properties na variável de escopo da classe para ser usada nos casos de testes
		setUrl(prop.getProperty("url"));
		
		//Setando as configurações do navegador chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\driversource\\chromedriver.exe");
		
		//bloco de if para verificar qual navegador será utilizado nos testes
		if (browser.equalsIgnoreCase("Chrome(HeadLess)")) {
			
			// definindo as propriedades do navegador no modo HeadLess
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			
			//Instanciando o WebDriver para a versão Headless
			driver = new ChromeDriver(options);
			
		} else if(browser.equalsIgnoreCase("Chrome")) {
			
			//Instanciando o WebDriver
			driver = new ChromeDriver();
		}
		
		//Definindo 10 segundos de implicit wait (delay) para todos os steps caso haja algum elemento carregado via AJAX e que o driver não consiga identificar
		//quando esse elemento concluiu o load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	//metodo para setar a url na variavel url de escopo da classe
	public void setUrl(String url) {
		this.url = url;
	}
	
	//metodo que define o screenshot do navegador
	public void getScreenshot(String info) throws IOException {
		
		//tirando o print da tela usando o AShot
		//A imagem é salva no diretório da aplicação, no path: \test-output\screenShotErrors\<Arquivo>
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\test-output\\screenShotErrors\\"+(new Date(System.currentTimeMillis()))+"_"+info+"_screenshot.png"));
		
		
		//outro metodo para tirar screenshots da pagina seria a forma a baixo, porém o print é feito apenas da área visivel, e no exemplo a cima é da página inteira.
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\test-output\\screenShotErrors\\"+(new Date(System.currentTimeMillis()))+"_"+result+"_screenshot.png"));
	}
}
