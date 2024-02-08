package Basepkg;


	

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.BeforeTest;

	public class Baseclass {

	public static RemoteWebDriver driver;
		
		@BeforeTest
		public void setup()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.shopsy.co.in/");
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
	}
