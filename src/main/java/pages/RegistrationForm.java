package pages;


import base.baseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationForm {

    static WebDriver driver;

    public RegistrationForm(WebDriver driver)
    {
        RegistrationForm.driver = driver;
    }

    public void navigateToRegistrationForm(String WebsiteURL) {

        //Navigate to Registration Form
        new baseMethods(driver).navigateToAnyWebsite(WebsiteURL);
    }
    public void EnterValidDataInForm(String fName , String lName , String userEmail , String userPhone){

        //Locators of Registration fields
        WebElement fNamePath = driver.findElement(By.xpath("//input[@name='fname']"));
        WebElement lNamePath = driver.findElement(By.xpath("//input[@name='lname']"));
        WebElement emailPath = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement phonePath = driver.findElement(By.xpath("//input[@name='nf-field-20']"));



        //Sending valid data in each field of Registration
        new baseMethods(driver).enterText(fNamePath, fName);
        new baseMethods(driver).enterText(lNamePath, lName);
        new baseMethods(driver).enterText(emailPath, userEmail);
        new baseMethods(driver).enterText(phonePath, String.valueOf(userPhone));
        new baseMethods(driver).clickOnElement(By.xpath("//label[text()='LinkedIn']"));

    }

    public void clickOnRegisterCTA(){
        //Click on Register CTA
        WebElement registerCTAPath = driver.findElement(By.xpath("//input[@type='submit']"));
        new baseMethods(driver).clickOnElement(By.xpath("//input[@type='submit']"));
    }

}
