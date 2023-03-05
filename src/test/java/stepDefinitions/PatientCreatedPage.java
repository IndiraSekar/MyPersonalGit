package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class PatientCreatedPage {

	
WebDriver driver;

@Given("Verify Successful Patient creation and capture email and RegistrationNumber")
public void verifyPatientCreation_captureEmailRegistrationNo() 
{
	
	boolean actualState = driver.findElement(By.className("registration-number")).isDisplayed();
	Assert.assertTrue(actualState);
	String regNo = driver.findElement(By.className("registration-number")).getText();
	System.out.println("Registration Number : " + regNo);
	String patientName_Email_PhoneNo= driver.findElement(By.className("summary")).getText();
	System.out.println("patientName_Email_PhoneNo : " + patientName_Email_PhoneNo);
    
}

@Then("Click on Expand icon and take snaps")
public void clickOnExpandIconAndTakeSnaps() throws IOException 
{
    
	driver.findElement(By.xpath("//div[@class='panel-title']//span[@class='icon-InfoOutlined']")).click();
	 //Snap Shot of Patient creation Model
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("./snaps/PatientCreationModel/patientCreatedModel.png");
	FileUtils.copyFile(source, dest);
}

@Then("Verify Images and Text strings")
public void verifyImagesAndTextStrings() 
{
	
	WebElement image1=driver.findElement(By.xpath("(//div[@class='image-container'])[1]"));
	boolean imageone= image1.isDisplayed();
	Assert.assertTrue(imageone);
	
	WebElement image2=driver.findElement(By.xpath("(//div[@class='image-container'])[2]"));
	boolean imagetwo= image2.isDisplayed();
	Assert.assertTrue(imagetwo);
	
	String expectedMsg1="Download and install the MS app on the patient's phone";
	String actualMsg1= driver.findElement(By.xpath("(//div[@class='guide-container']//div[@class='description'])[1]")).getText();
	Assert.assertEquals(actualMsg1, expectedMsg1);
	
	String expectedMsg2="Download and install the MS app on the patient's phone";
	String actualMsg2= driver.findElement(By.xpath("((//div[@class='guide-container']//div[@class='description'])[2]")).getText();
	Assert.assertEquals(actualMsg2, expectedMsg2);
		
}

@Then("Click on icon for screen collapse and take snapshot")
public void clickOnIconAndScreenCollapse() throws IOException 
{
	driver.findElement(By.xpath("//div[@class='panel-title']//span[@class='icon-ExpandLess']")).click();
	 //Snap Shot of Patient model collapse
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/PatientCreationModel/patientCreatedModel.png");
		FileUtils.copyFile(source, dest);
		
		
    
	
}
	
}