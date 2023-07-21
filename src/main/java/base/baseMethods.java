package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseMethods {

    static WebDriver driver;
    public baseMethods (WebDriver driver)
    {
        baseMethods.driver = driver;
    }


    public static WebElement waitExpectedCondition (By elementPath , String waitCon)
    {
        WebElement element = null;
        try
        {
            switch (waitCon)
            {
                case "presenceOfElement":
                    element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(elementPath));
                    return element;

                case "elementToBeClickable":
                    element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(elementPath));
                    return element;

                case "visibilityOfElement":
                    element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(elementPath));
                    return element;
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed :" + e.getMessage());
            return null;
        }
        return element;
    }

    public static void navigateToAnyWebsite(String websiteUrl)
    {
        try
        {
            driver.get(websiteUrl);
        }
        catch (Exception e)
        {
            driver.navigate().to(websiteUrl);
        }
    }

    public static void clickOnElement(By elementPath)
    {
        WebElement element;
        try
        {
            // element= waitExpectedCondition(elementPath, "presenceOfElement");
            element= waitExpectedCondition(elementPath, "elementToBeClickable");
            assert element != null;
            element.click();
        }
        catch (Exception e)
        {
            element= waitExpectedCondition(elementPath, "elementToBeClickable");
            assert element != null;
            element.submit();
        }
    }

    public static String getPresentedText(By path)
    {
        WebElement element = null;
        try
        {
            return driver.findElement(path).getText();
        }
        catch (Exception e)
        {
            System.out.println("Failed to get text ...");
            return null;
        }
    }

    public static void enterText(WebElement textField , String text)
    {
        try
        {
            textField.sendKeys(text);
        }
        catch (Exception e)
        {
            System.out.println("Failed to enter text in field ...");
        }
    }

    public boolean checkIfWordsAreExactOrNot(String word1 , String word2) {

        if (word1.equals(word2)) {
                return true;
            }
        else{
            System.out.println("Failed to check if first name and last name are exact or not ...");
        }

        return false;
    }}
