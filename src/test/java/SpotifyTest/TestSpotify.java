package SpotifyTest;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestSpotify {
    SHAFT.GUI.WebDriver driver;


    //Locators
    By emailInput = By.xpath("//input[@name='username']");
    By NextButton = By.xpath("//button[@data-testid='submit']");
    By passwordInput = By.id("new-password");
    By NameInput = By.xpath("//input[@name='displayName']");
    By DayInput = By.xpath("//input[@name='day']");
    By MonthInput = By.xpath("//select[@name='month']");
    By YearInput = By.xpath("//input[@name='year']");
    By GenderOption = By.xpath("//label[@for='gender_option_female']");
    By checkbox_one = By.xpath("//label[@for='checkbox-marketing']");
    By checkbox_second = By.xpath("//label[@for='checkbox-privacy']");
    By SignupButton = By.xpath("//button[@data-testid='submit']");
    By LoginButton = By.xpath("//button[@id=\"login-button\"]");
    By EmailLoginInput = By.xpath("//input[@id=\"login-username\"]");
    By PassLoginInput = By.xpath("//input[@id=\"login-password\"]");
    By PlayButton = By.xpath("//button[@data-testid='control-button-playpause' and @aria-label='Play']");
    By Postercard =By.xpath("//div[@data-encore-id=\"card\"]");





    //Method
    @Test
    public void SignupSteps() throws InterruptedException  {
        driver.browser().navigateToURL("https://www.spotify.com/eg-ar/signup?forward_url=https%3A%2F%2Fopen.spotify.com%2F");
        driver.element().type(emailInput, "esraauber4@gmail.com")
                .and().click(NextButton)
                .and().type(passwordInput, "E@123456789")
                .and().click(NextButton);
        driver.element().type(NameInput, "EsraaMohammed")
                .and().type(DayInput, "11")
                .and().select(MonthInput, "November")
                .and().type(YearInput, "2000")
                .and().click(GenderOption)
                .and().click(NextButton);
        driver.element().click(checkbox_one)
                .and().click(checkbox_second)
                .and().click(SignupButton);

        Thread.sleep(10000);


    }

    @Test
    public void LoginSteps()throws InterruptedException
    {
        driver.browser().navigateToURL("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
        driver.element().type(EmailLoginInput, "esraamelghorab@gmail.com")
                .and().type(PassLoginInput, "spotify1112000")
                .and().click(LoginButton);
        Thread.sleep(10000);

    }

    @Test
    public void PlaySong() throws InterruptedException {
      driver.browser().navigateToURL("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
      driver.element().type(EmailLoginInput, "esraamelghorab@gmail.com")
              .and().type(PassLoginInput, "spotify1112000")
              .and().click(LoginButton);
      driver.element().click(PlayButton);

        driver.assertThat()
                .element(PlayButton)
                .isEnabled()
                .perform();


      Thread.sleep(90000);

    }

    //Before Method
    @BeforeClass
    public void Setup()
    {
        driver= new SHAFT.GUI.WebDriver();
    }

    //After Method
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
