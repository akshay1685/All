package facebook;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class login 
{
	@Test
	public void login() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--incognito");
		option.addArguments("start-maximized");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com/");
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("http://Facebook.com");
		//System.out.println(driver.getTitle());
		//driver.navigate().back();
		//System.out.println(driver.getTitle());

		//driver.navigate().forward();
		//System.out.println(driver.getTitle());
		//driver.navigate().refresh();
		//System.out.println(driver.getPageSource());
		 driver.findElement(By.id("email")).sendKeys("Aki");
		 List<WebElement> l= driver.findElements(By.tagName("a"));
		 for(WebElement w:l)
		 {
				if(w.getAttribute("href")!=null)
				{
					String link=w.getAttribute("href");
					HttpURLConnection con= (HttpURLConnection) new URL(link).openConnection();
					con.connect();
					if(con.getResponseCode()>=400)
					{
						System.out.println(link+" Link is broken");
					}
					else
						System.out.println(link+" Link is Working");
				}

		 }
		
		Thread.sleep(4000);
		driver.close();
	}

}
