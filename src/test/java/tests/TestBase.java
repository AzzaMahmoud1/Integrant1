package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(TestBase.class);
	
	public void OpenBrowser() {		
		logger = Logger.getLogger("Open browser ");
		String URL = "https://subscribe.stctv.com/sa-en";
		try {
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
	
			}
		catch (Exception ex) {
			logger.error("Open browser " + ex.getMessage());
		}
		
		logger.info("Opening Browser ...");
		logger.info("Open URL = " + URL);
		driver.get(URL);
		driver.manage().window().maximize();;
	}
	
		
	public static void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
		logger.info("Refresh Current Page ");

	}
	
	public static void CloseBrowser() {
			
			logger = Logger.getLogger("Close browser ");
			try {
				driver.quit();
				logger.info("Close Browser ...");
			} catch (Exception ex) {
				logger.error("Close browser " + ex.getMessage());

			}

		}
	
	
	
}