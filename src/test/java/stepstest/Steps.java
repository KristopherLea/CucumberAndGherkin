package stepstest;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Steps
{
    private static WebDriver driver = null;

    @Given("^Open Chrome and navigate to a site$")
    public void open_chrome_and_navigate_to_site() throws Throwable
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\krist\\OneDrive\\Desktop\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://harmonymuseum.org/");

        System.out.println("This Step opens Chrome and navigates to a site");
    }

    @When("^Scrolls down the page and clicks on the link at the bottom$")
    public void Scroll_Down_The_Page() throws Throwable
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        js.executeScript("window.scrollTo(0,1500);");

        System.out.println("This step scrolls down the homepage.");
    }

    @Then("^Enters the form information$")
    public void enter_the_Email_and_First_Name(DataTable dt) throws Throwable {

        List<Map<String, String>> userList = dt.asMaps(String.class, String.class);

        for (int i = 0; i < userList.size(); i++) {
            driver.manage().deleteAllCookies();
            WebElement fName = driver.findElement(By.xpath("//input[@name='FNAME']"));
            driver.findElement(By.xpath("//input[@name='FNAME']")).clear();
            fName.sendKeys(userList.get(i).get("fName"));

            WebElement lName = driver.findElement(By.xpath("//input[@name='LNAME']"));
            driver.findElement(By.xpath("//input[@name='LNAME']")).clear();
            lName.sendKeys(userList.get(i).get("lName"));

            WebElement uEmail = driver.findElement(By.xpath("//input[@name='EMAIL']"));
            driver.findElement(By.xpath("//input[@name='EMAIL']")).clear();
            uEmail.sendKeys(userList.get(i).get("userEmail"));

            driver.findElement(By.cssSelector("input[type='submit'][value='Subscribe']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            System.out.println("Form Submitted");
        }

    }
}

