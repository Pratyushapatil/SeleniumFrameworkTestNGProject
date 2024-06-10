package SeleniumFrameworkTestProjectTestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumFrameworkTestProjectPageobeject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver ;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();  //to get values from porp file
		FileInputStream fis = new FileInputStream("C:\\Users\\Pratyusha\\eclipse-workspace\\SeleniumFrameworkTestProject\\src\\main\\java\\Resources\\GlobalData.properties");   // to read file and user.dir->get the user directory dynamically 
	    prop.load(fis);   // loading file via object
	    String browserName = prop.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome"))
	    {    
	    	WebDriverManager.chromedriver().setup(); // automatically  latest chromedriver would be downloaded
	    	 driver = new ChromeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	//firefox driver path
	    }
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.manage().window().maximize();
	    	return driver;
	    }
/* this will execute the launch application process */	
@BeforeMethod
public LandingPage launchApplication() throws IOException
{
	 landingPage = new LandingPage(driver);
	landingPage.goTo();
	return landingPage;
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
