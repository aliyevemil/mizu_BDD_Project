package step_definitions;

import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Login_page;

import java.lang.module.Configuration;
import java.util.Properties;

public class Login_stepDefinition {

    Login_page login_page = new Login_page();



    @Given("Kullanici Web uygulamasinin ana sayfasini acmalidir.")
    public void kullanici_web_uygulamasinin_ana_sayfasini_acmalidir() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("Kullanici web sayfadaki cerez uyarisini kapatmalidir.")
    public void kullaniciWebSayfadakiCerezUyarisiniKapatmalidir() {
        login_page.popup.click();
    }

    @When("Kullanici Email alanina gecerli bir email girmelidir.")
    public void kullanici_email_alanina_gecerli_bir_email_girmelidir() {
        login_page.username.sendKeys(ConfigurationReader.getProperty("userName"));

    }

    @When("Password alanına gecerli bir password girmelidir.")
    public void password_alanına_gecerli_bir_password_girmelidir() {
        login_page.password.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @When("Sign in düğmesine tiklamalidir.")
    public void sign_in_düğmesine_tiklamalidir() {
        login_page.signin.click();

    }

    @Then("Web sayfasina giren kullanici profilini ekranda gormelidir.")
    public void web_sayfasina_giren_kullanici_profilini_ekranda_gormelidir() {
        BrowserUtils.sleep(2);

        login_page.profile.isDisplayed();
       Driver.closeDriver();


    }


}
