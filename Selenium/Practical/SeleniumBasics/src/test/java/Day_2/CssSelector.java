package Day_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CssSelector {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        // Throughout the usage of cssSelector() tag can be optional if the element can be identified uniquely 
//        //Css selector using tag and id
//        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Mo");
        driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Mo");
        
//        //Css selector using tag and id
//        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("bi");
        driver.findElement(By.cssSelector(".search-box-text")).sendKeys("bi");
        
//        //Css selector using tag, id and attribute
//        driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("les");
        driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("les");

        driver.quit();
    }
}
