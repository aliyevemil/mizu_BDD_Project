package step_definitions;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Login_page;

import java.lang.module.Configuration;

public class WrongLogin_StepDefinition {
    Login_page login_page = new Login_page();

    Faker faker= new Faker();

    @Given("Kullanici login sayfasina giris yapmalidir.")
    public void kullanici_login_sayfasina_giris_yapmalidir() {
        Driver.getDriver().get("https://www.mizu.com/en-mx/login");
    }

    @When("Kullanici Email alanina gecersiz bir email girmelidir.")
    public void kullanici_email_alanina_gecersiz_bir_email_girmelidir() {
        login_page.username.sendKeys(faker.internet().emailAddress());
    }

    @When("Kullanici passsword alanina gecerli bir password girmelidir.")
    public void kullanici_passsword_alalnina_gecerli_bir_password_girmelidir() {
        login_page.password.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @When("Sign in butonuna tiklamalidir.")
    public void sign_in_butonuna_tiklamalidir() {
        login_page.signin.click();

    }

    @Then("Web sayfasina giren kullanici uyari mesaji ile karsilasmalidir.")
    public void web_sayfasina_giren_kullanici_uyari_mesaji_ile_karsilasmalidir() {
        Assert.assertTrue("E-mail address or password is incorrect. Please check your information and try again.", login_page.popup.isDisplayed());

    }

}
