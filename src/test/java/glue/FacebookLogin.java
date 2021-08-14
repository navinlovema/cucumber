package glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class FacebookLogin {
    WebDriver webDriver = null;
    String username, password = null;

    @Before
    public void loadDriver(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver" , projectPath + "/src/test/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @Given("facebook page is opened")
    public void facebook_page_is_opened() {
        webDriver.navigate().to("https://www.facebook.com/");
    }
    @When("user has to provide his username and password")
    public void user_has_to_provide_his_username_and_password() {
        username = "";
        password  ="";
    }
    @When("these username and password is passed to the facebook page")
    public void these_username_and_password_is_passed_to_the_facebook_page() {
        webDriver.findElement(By.name("email")).sendKeys(username);
        webDriver.findElement(By.name("pass")).sendKeys(password);
        webDriver.findElement(By.name("login")).sendKeys(Keys.ENTER);
    }
    @Then("user will be able to login to facebook and see the post")
    public void user_will_be_able_to_login_to_facebook_and_see_the_post() {

    }

    @After
    public void closeDriver() {
        webDriver.close();
    }
}
