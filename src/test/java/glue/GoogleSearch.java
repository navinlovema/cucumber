package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    WebDriver webDriver = null;
    @Given("google chrome is open")
    public void google_chrome_is_open() {
        String userDirPath = System.getProperty("user.dir");
        System.out.println(userDirPath);
        System.setProperty("webdriver.chrome.driver",userDirPath + "/src/test/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        webDriver.manage().window().fullscreen();
        System.out.println("web driver is loaded... successfully!");
    }
    @When("google search engine is searched")
    public void google_search_engine_is_searched() {
        webDriver.navigate().to("https://www.google.com");
    }
    @When("user pass the input what he wanted to search")
    public void user_pass_the_input_what_he_wanted_to_search() {
        webDriver.findElement(By.name("q")).sendKeys("https://id.atlassian.com");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        webDriver.navigate().to(webDriver.findElement(By.className("g")).findElement(By.tagName("a")).getAttribute("href"));

    }

    @And("user will pass his username and password")
    public void userWillPassHisUsernameAndPassword() {
        webDriver.findElement(By.name("username")).sendKeys("your email");
        webDriver.findElement(By.id("login-submit")).sendKeys(Keys.ENTER);
        webDriver.findElement(By.name("password")).sendKeys("your password");

    }

    @Then("user is navigated to the next page")
    public void userIsNavigatedToTheNextPage() {
        webDriver.findElement(By.id("login-submit")).sendKeys(Keys.ENTER);
        webDriver.close();
    }


}
