import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class GridGate {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//Open TATOC url
		driver.get("http://10.0.1.86/tatoc");
		//Select BASIC COURSE in TATOC page
		List<WebElement> results = driver.findElements(By.className("page"));
		results.get(0).findElement(By.cssSelector("a")).click();
		//Find and select Greenbox
		driver.findElement(By.className("greenbox")).click();
		//Capture the color of first Box
		driver.switchTo().frame("main");
		String s = driver.findElement(By.id("answer")).getAttribute("class");
		boolean check = true;
		//Capturing the color of second box and matching it with first box.And if matched proceding further.
		while (check) {
			driver.switchTo().frame("child");
			String s1 = driver.findElement(By.id("answer")).getAttribute("class");
		
			if (s.equals(s1)) {
				
			check=false;
			driver.switchTo().parentFrame();
			WebElement link = driver.findElement(By.partialLinkText("Proceed"));
			link.click();
			}
			else {
				driver.switchTo().parentFrame();
				WebElement link = driver.findElement(By.partialLinkText("Repaint"));
				link.click();
			}

		}
		//find the dragable element
	WebElement From=driver.findElement(By.className("ui-draggable"));
	//Dragging it to the required area
	Actions ac=new Actions(driver);
	ac.dragAndDropBy(From, 20,-76).build().perform();
	//After dragging the element proceeding to further page
	driver.findElement(By.linkText("Proceed")).click();
	//finding and clicking the "Launch Popup Window" element
	driver.findElement(By.linkText("Launch Popup Window")).click();
	//filling and submitting the form
	
	WebElement form=driver.findElement(By.id("name"));
	form.sendKeys("Vinayak");
	form.submit();
	
	}

}
