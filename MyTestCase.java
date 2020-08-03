package com.seleniumtestingpractice.webdriver;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//Test cases on wordpress login and signup for assignment purpose

public class MyTestCase
{
    private WebDriver driver;
    private String link = "https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F";

    public MyTestCase()
    {
        //Change the address according yours
        System.setProperty("webdriver.chrome.driver", "D:\\Directory\\RadioActiveElements\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void testCaseOne()
    {
        //Login with valid credentials pass
        this.driver.navigate().to(this.link);
        //Finding email textbox
        this.driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("khan760li");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Finding Next button
        this.driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button")).click();
        //Finding Password textbox
        this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("bmw760li");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Finding Next Button
        this.driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button")).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //This means successfullt logged in
        Assert.assertEquals("Following ‹ Reader — WordPress.com", this.driver.getTitle());
        this.driver.close();
    }

    @Test
    public void testCaseTwo()
    {
        //Login with valid username and invalid password failed
        this.driver.navigate().to(this.link);
        //Finding email textbox
        this.driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("khan760li");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Finding Next button
        this.driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button")).click();
        //Finding Password textbox
        this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("760li760li");
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Finding Next Button
        this.driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button")).click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //This means failed login attempt
        Assert.assertEquals("Following ‹ Reader — WordPress.com", this.driver.getTitle());
        this.driver.close();
    }

    @Test
    public void testCaseThree()
    {
        //Sign up passed test case
        this.driver.navigate().to("https://wordpress.com/start/user");
        //Email Input
        this.driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jangijahazf16@gmail.com");
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Choose Username
        this.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("JangiJahaz");
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Entering Password
        this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("fighterf16");
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Create Account Button
        this.driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/form/div[2]/button")).click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //This mean successful sign up
        Assert.assertEquals("https://wordpress.com/start/domains", this.driver.getCurrentUrl());
    }

    @Test
    public void testCaseFour()
    {
        //Sign up failed test case
        this.driver.navigate().to("https://wordpress.com/start/user");
        //Email Input
        this.driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jangijahazf16@gmail.com");
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Choose Username
        this.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Entering Password
        this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("fighterf16");
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Create Account Button
        this.driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/form/div[2]/button")).click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //This mean successful sign up
        Assert.assertEquals("https://wordpress.com/start/domains", this.driver.getCurrentUrl());
    }
}
