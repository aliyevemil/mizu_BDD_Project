package Utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void sleep(int seconds){
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

    public static void verifyTitle(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public static WebDriverWait explicitlyWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait;
    }

    public static void verifyUrlContains(String string){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));
    }

    /**

     * @param dropDownElement
     * @return List<String> actualOptionsAsString.
     */
    public static List<String> dropDownOptionsAsString (WebElement dropDownElement) {
        Select select =new Select(dropDownElement);

        //list of all actual months <options> as web element
        List<WebElement> actualOptionsAsWebElement =select.getOptions();

        //list of all actual months <options> as String
        List<String> actualOptionsString=new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsString.add(each.getText());
        }

        return actualOptionsString;
    }



    /**
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement>radioButtons,String attributeValue){

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }


    /**
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().switchTo().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
}
