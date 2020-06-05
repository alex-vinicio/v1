package net.osgg.form;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class FormApplicationTests {

	private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.operadriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new OperaDriver();
        driver.get("http://localhost:8080/registration"); //contenido a verificar
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterAll
    public void teardown() throws InterruptedException {
        if (driver != null) {
        	//Thread.sleep(1000); //no recomendable, sólo como ejemplo
        	driver.close();
            driver.quit();
        }
    }

    @Test //CP01
    public void testAgeVECP01() throws InterruptedException {
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("age")).sendKeys("35");
    	driver.findElement(By.id("age")).submit();	    	

    	WebElement msgElement = driver.findElement(By.id("msg"));
    	
    	//En caso de requerir alguna comparación referente a un valor
    	//numérico
    	
    	//WebElement ageElement = driver.findElement(By.id("age"));
    	/*
    	Boolean isInteger = false;
    	try{
    		  int num = Integer.parseInt(ageElement.getText());
    		  isInteger = true;
    		} catch (NumberFormatException e) {
    		  isInteger = false;
    	}
    	*/
    	
    	assertTrue( msgElement.getText().contains("Welcome") 
    				 //&& isInteger && 
    				//(Integer.valueOf(ageElement.getText()) >= 18 && 
    			     //Integer.valueOf(ageElement.getText()) <= 65) 
    				);
    }

    /*
    @Test //CP02
    public void testAgeNVECP001() throws InterruptedException {
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("age")).sendKeys("a");
    	driver.findElement(By.id("age")).submit();	    	

    	WebElement msgElement = driver.findElement(By.id("msg"));
    	
    	assertTrue(msgElement.getText().contains("Error"));
    }    
    
    
    @Test //CP03
    public void testAgeNVECP02() throws InterruptedException {
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("age")).sendKeys("");
    	driver.findElement(By.id("age")).submit();	    	

    	WebElement msgElement = driver.findElement(By.id("msg"));
    	
    	assertTrue(msgElement.getText().contains("Error"));
    }
    
    
    @Test //CP04
    public void testAgeNVECP03() throws InterruptedException {
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("age")).sendKeys("18.5");
    	driver.findElement(By.id("age")).submit();	    	

    	WebElement msgElement = driver.findElement(By.id("msg"));
    	
    	assertTrue(msgElement.getText().contains("Error"));
    } 
    
    
    @Test //CP05
    public void testAgeNVECP04() throws InterruptedException {
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("age")).sendKeys("15");
    	driver.findElement(By.id("age")).submit();	    	

    	WebElement msgElement = driver.findElement(By.id("msg"));
    	
    	assertTrue(msgElement.getText().contains("Error"));
    } 
    
    
    @Test //CP06
    public void testAgeNVECP05() throws InterruptedException {
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("age")).sendKeys("70");
    	driver.findElement(By.id("age")).submit();	    	

    	WebElement msgElement = driver.findElement(By.id("msg"));
    	
    	assertTrue(msgElement.getText().contains("Error"));
    } 
    

    */
    @Test //para probar ingreso del nombre correcto
    public void testName() throws InterruptedException {
    	driver.findElement(By.id("name")).clear();
    	driver.findElement(By.id("age")).sendKeys("19");
    	driver.findElement(By.id("name")).sendKeys("Alex Andino");
    	driver.findElement(By.id("name")).submit();
    	
    	WebElement idContent = driver.findElement(By.id("name"));
    	assertEquals("Alex Andino", idContent.getText());
    	//Thread.sleep(1500); //no recomendable, sólo como ejemplo
    }
    
    
    @Test // ingresa campo nombre vacio
    public void testAgeNVECP07() throws InterruptedException {
    	driver.findElement(By.id("name")).clear();
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("age")).sendKeys("19");
    	driver.findElement(By.id("name")).sendKeys("");
    	driver.findElement(By.id("age")).submit();	
    	driver.findElement(By.id("name")).submit();	    	

    	WebElement idContent = driver.findElement(By.id("name"));
    	assertEquals("", idContent.getText());
    }    
    
    @Test // ingresa campo nombre vacio
    public void testAgeNVECP06() throws InterruptedException {
    	driver.findElement(By.id("name")).clear();
    	driver.findElement(By.id("age")).clear();
    	driver.findElement(By.id("age")).sendKeys("19");
    	driver.findElement(By.id("name")).sendKeys("a");
    	driver.findElement(By.id("age")).submit();	
    	driver.findElement(By.id("name")).submit();	    	

    	WebElement idContent = driver.findElement(By.id("name"));
    	assertEquals("", idContent.getText());
    }  
    
}


