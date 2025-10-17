package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Cross_browser{

WebDriver driver;
@SuppressWarnings("deprecation")
@Parameters ({"browser"})
@Test

public void browserTest (@Optional("chrome")String browser) throws MalformedURLException, InterruptedException
{
	
System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
	
if (browser.equalsIgnoreCase ("chrome"))
{

WebDriverManager.chromedriver().setup();
ChromeOptions options=new ChromeOptions();
//driver=new ChromeDriver(); 
driver=new RemoteWebDriver (new URL("http://localhost:4444"), options); 
System.out.println("Connection Established with Chrome Browser on grid");
}

if (browser.equalsIgnoreCase ("firefox"))
{
FirefoxOptions options=new FirefoxOptions();
//driver=new FirefoxDriver(); 
driver=new RemoteWebDriver (new URL("http://localhost:4444"), options); 
System.out.println("Connection Established with Firefox Browser on grid");
}

if (browser.equalsIgnoreCase ("edge"))
{
EdgeOptions options = new EdgeOptions();
//driver=new EdgeDriver(); 
driver=new RemoteWebDriver (new URL("http://localhost:4444"), options); 
System.out.println("Connection Established with Edge Browser on grid");
}

Thread.sleep(5000);
System.out.println("Remote driver connectivity is established");
driver.get("https://www.amazon.in");
Thread.sleep(3000);
System.out.println("Application Executing Parallelly on grid..!!");
//driver.quit();
}
}