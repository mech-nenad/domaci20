/*

Zadatak je da popunite sva polja (Full Name, email, Current Address, Permanent Address) i da kliknete submit.

Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita, da nije doslo do izmene.
Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.

 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nenad\\Documents\\Driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("Petar Petrovic");

        WebElement useremail = driver.findElement(By.id("userEmail"));
        useremail.sendKeys("petar@gmail.com");

        WebElement currentaddress = driver.findElement(By.id("currentAddress"));
        currentaddress.sendKeys("Dragise Brasovana 10");

        WebElement permanentaddress = driver.findElement(By.id("permanentAddress"));
        permanentaddress.sendKeys("Jovana Cvijica Novi Sad 10");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        buttonSubmit.click();

        WebElement name = driver.findElement(By.id("name"));
        WebElement email = driver.findElement(By.id("email"));


        System.out.println(" Input user name: " + username.getAttribute("value"));
        System.out.println(" Output user name - \"Name :\": " + name.getText().substring(5));
        System.out.println(" Input user email: " + useremail.getAttribute("value"));
        System.out.println(" Output user email - \"Email :\": " + email.getText().substring(6));

        if (name.getText().substring(5).equals(username.getAttribute("value")) && email.getText().substring(6).equals(useremail.getAttribute("value"))) {
            System.out.println("The name and email match the one entered!");
        } else {
            System.out.println("Name and email do not match what was entered!");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
