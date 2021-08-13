package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogIn {
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Hello India");
    }
    @When("user must provide username and password")
    public void user_must_provide_username_and_password() {

        System.out.println("Hello India");
    }
    @When("check username and password provided by user")
    public void check_username_and_password_provided_by_user() {

        System.out.println("Hello India");
    }
    @Then("user get logged in")
    public void user_get_logged_in() {

        System.out.println("Hello India");
    }
}
