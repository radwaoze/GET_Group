package steps;
import base.baseMethods;
import base.browserSetup;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.RegistrationForm;
import tests.TestBase;
import java.util.Properties;

import static dataProvider.PropertiesFileReader.readPropertiesFile;

public class UserRegistration extends TestBase{

    Faker fakeData = new Faker();
    String fName = fakeData.name().firstName();
    String lName = fakeData.name().lastName();
    String userEmail = fakeData.internet().emailAddress();
    PhoneNumber userPhone = fakeData.phoneNumber();

    @Given("The user navigates to Registration form")
    public void theUserNavigatesToRegistrationForm() {
        Properties readPropertiesFile = readPropertiesFile("src/main/resources/Config.properties");
        new RegistrationForm(driver).navigateToRegistrationForm(System.getProperty("WebsiteURL", readPropertiesFile.getProperty("WebsiteURL")));
    }

    @When("User enters valid credentials in Registration form")
    public void userEntersValidCredentialsInRegistrationForm() {
        new RegistrationForm(driver).EnterValidDataInForm(fName , lName , userEmail , String.valueOf(userPhone));
        Assert.assertTrue(Character.isUpperCase(fName.charAt(0)));
        Assert.assertTrue(Character.isUpperCase(lName.charAt(0)));
        System.out.println("Check if words are exact or not is " + new baseMethods(driver).checkIfWordsAreExactOrNot(fName, lName));
        Assert.assertFalse(new baseMethods(driver).checkIfWordsAreExactOrNot(fName, lName));


        System.out.println("Registered User Data : " + fName + " " + lName + " " + userEmail + " " + userPhone);

    }

    @And("User clicks Register CTA")
    public void userClicksRegisterCTA()  {
        new browserSetup().waitScreen();
        new RegistrationForm(driver).clickOnRegisterCTA();
    }

    @Then("Registration confirmation message should be displayed")
    public void registrationConfirmationMessageShouldBeDisplayed() {
        new browserSetup().waitScreen();

        System.out.println("registrationConfirm is " + driver.findElement(By.xpath("//*[contains(@aria-label,'Your registration is completed')]")).getText());
        WebElement registrationConfirm = driver.findElement(By.xpath("//*[contains(@aria-label,'Your registration is completed')]"));
        Assert.assertEquals(registrationConfirm.getText() , "Your registration is completed. We will contact with you soon. Thank you !");
    }
}
