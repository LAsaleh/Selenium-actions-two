package techlistic.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

public class TechListicDemo {

    final public static String URL = "https://www.techlistic.com/p/selenium-practice-form.html";


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        //initial configuration of our web driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        driver.manage().window().maximize(); //this another method doing the same function.
        driver.manage().window().fullscreen();


//      can you hack this site and bring it down, i dont like it
        //we should be good now
        //i cannot hack it, because i am not a super villian :) hahhh but you are a ninja
        //ninjas proejct not BREAK !!! i want you try for
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        // driver.navigate().to(URL); another method do the same function

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        WebElement mainHeader = driver.findElement(By.xpath("//h3[contains(text(), 'Demo Sign-Up')]"));


        String expectedMainHeaderTxt = "Demo Sign-Up Selenium Automation Practice Form";
        String actualMainHeaderTxt = mainHeader.getText();

        if (expectedMainHeaderTxt.equals(actualMainHeaderTxt)) {
            System.out.println("Main Header text is correct");

        } else {
            System.out.println("Main Header text is not correct");
        }

        WebElement automationHeader = driver.findElement(By.xpath("//span[text()='AUTOMATION PRACTICE ME']"));

        String actualAutomationHeaderTxt = automationHeader.getText();
        String expectedAutomationHeaderTxt = "AUTOMATION PRACTICE ME";

        if (expectedAutomationHeaderTxt.equals(actualAutomationHeaderTxt)) {
            System.out.println("Automation hearer is correct");

        } else {
            System.out.println("Automation hearer is not correct");

        }


        WebElement firstnameInput = driver.findElement(By.name("firstname"));
        firstnameInput.sendKeys("kevin");

        WebElement lastnameInput = driver.findElement(By.name("lastname"));
        lastnameInput.sendKeys("lee");

        int random = (int) (Math.random() * (2 - 0) + 0);
        WebElement genderBtn = driver.findElement(By.id("sex-" + random));
        genderBtn.click();

        random = (int) (Math.random() * (7 - 0) + 0);
        WebElement expBtn = driver.findElement(By.id("exp-" + random));
        expBtn.click();


        WebElement dateInput = driver.findElement(By.id("datepicker"));
        String timeStamp = new SimpleDateFormat("mm=dd-yyyy").format(Calendar.getInstance().getTime());
        dateInput.sendKeys(timeStamp);

        random = (int) (Math.random() * (2 - 0) + 0);
        WebElement checkAutomationTester = driver.findElement(By.id("profession-" + random));
        checkAutomationTester.click();

        List<WebElement> tools = driver.findElements(By.name("tools"));
        //this is shortening method to iterate the elements instead of fori or foreach loop.
//        tools.stream().forEach(t -> t.click());
        for (int i = 0; i < tools.size(); i++) {
            tools.get(i).click();

        }

        WebElement continentsLeb = driver.findElement(By.id("continents"));
        Select select = new Select(continentsLeb);
        select.selectByVisibleText("Australia");


        WebElement seleniumCommands = driver.findElement(By.id("selenium_commands"));
        select = new Select(seleniumCommands);
        select.selectByVisibleText("Wait Commands");

        driver.findElement(By.id("submit")).click();







    }
}