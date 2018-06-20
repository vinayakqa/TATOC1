import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridGate {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		List<WebElement> results = driver.findElements(By.className("page"));
		results.get(0).findElement(By.cssSelector("a")).click();
		driver.findElement(By.className("greenbox")).click();
		
		driver.switchTo().frame("main");
		String s = driver.findElement(By.id("answer")).getAttribute("class");
		boolean check = true;
		while (check) {
			driver.switchTo().frame("child");
			String s1 = driver.findElement(By.id("answer")).getAttribute("class");
		
			if (s.equals(s1)) {
				System.out.println("matched");
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
	}

}
