package facebook;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handlewindows
{
	@Test
 public  void handlewindows() throws InterruptedException
 {
 
 System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
 WebDriver driver= new ChromeDriver();
 driver.get("http://demo.guru99.com/popup.php");
 driver.findElement(By.xpath("//*[contains(@href,'articles_popup.php')]")).click();
 String mainwindow= driver.getWindowHandle();
 System.out.println("1st window: "+mainwindow);
 Set<String> windows= driver.getWindowHandles();
 Iterator <String> itr=windows.iterator();
 while(itr.hasNext())
 {
 String child = itr.next();
 if(!mainwindow.equals(child))
 {
 driver.switchTo().window(child);
 System.out.println("2nd window: "+child);
 driver.findElement(By.name("emailid")).sendKeys("Akki");
 driver.close();
 System.out.println(driver.getWindowHandle());

 }
 driver.switchTo().window(mainwindow);
 System.out.println(driver.getWindowHandle());

 }
 Thread.sleep(3000);
 driver.quit();
 }
}
