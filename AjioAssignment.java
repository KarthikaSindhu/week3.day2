package week3.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioAssignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1. Launch the URL https://www.ajio.com/
		driver.get("https://www.ajio.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		// 2. In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("bags");
		driver.findElement(By.className("ic-search")).click();

		// 3. To the left of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);

		// 4. Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(2000);

		// 5. Print the count of the items Found.
		System.out.println(driver.findElement(By.xpath("//div[@class='length']")).getText());

		// 6. Get the list of brand of the products displayed in the page and print the
		// list.
		List<WebElement> brandElements = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("The no. of brands are :" + brandElements.size());

		for (WebElement wb : brandElements) {
			System.out.println("The Brand is " + wb.getText());
		}

		// 7. Get the list of names of the bags and print it
		List<WebElement> bagnames = driver.findElements(By.xpath("//div[@class='nameCls']"));
		System.out.println("Number of bags is :" + bagnames.size());

		for (WebElement b : bagnames) {
			System.out.println("Bag names are : " + b.getText());
		}

	}

}
