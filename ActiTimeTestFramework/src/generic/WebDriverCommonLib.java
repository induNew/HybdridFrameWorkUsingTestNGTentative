package generic;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverCommonLib extends BaseTest{

	public String getTheTitleOfTheWebPage(String pageName)
	{
		String titleOfTheWebPage = driver.getTitle();
		System.out.println("the title of the "+pageName+" page is "+titleOfTheWebPage+"");
		return titleOfTheWebPage;
	}

	public void verifyTheTitle(String expectedTitle,String pageName)
	{
		String actualtitleOfThWebPage = driver.getTitle();
		if(actualtitleOfThWebPage.equals(expectedTitle))
		{
			System.out.println("The title of the "+pageName+" page is verified ! TEST CASE IS PASS");
		}

		else
		{
			System.out.println("The title of the "+pageName+" page is  not verified ! TEST CASE IS FAILED");
		}
	}

	public void waitForTheWebELement()
	{
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}

	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public void takeTheScreenShotOfTheWebPage(String fileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(SCREENSHOT_PATH+fileName+".png");
		Files.copy(src, dest);
	}
	
	
	//overloaded methods
	//________________________________________________________________
	public void selectTheOption(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	
	public void selectTheOption(WebElement element,String visibleText)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void selectTheOption(String value,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	//______________________________________________________________
	
	//overloaded methods 
	//______________________________________________________________
	public void switchToframe(int index)
	{
		
		driver.switchTo().frame(index);
	}
	
	public void switchToframe(WebElement element)
	{
		
		driver.switchTo().frame(element);
	}
	
	public void switchToframe(String nameOrId)
	{
		
		driver.switchTo().frame(nameOrId);
	}
	//_____________________________________________________________
	
	public void waitForThePageToLoad(String text,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(text));
	}
	
	public void getAllTheOptionsOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		for(WebElement we: options)
		{
			String option = we.getText();
			System.out.println(option);
		}
		System.out.println("________________________________________");
		
	}
	
	
	public void mouseHover(WebElement target)
	{
		Actions act = new Actions(driver);
		act.moveToElement(target).perform();
	}
	
	
	public void doubleClick(WebElement target)
	{
		Actions act = new Actions(driver);
		act.doubleClick(target).perform();
	}
	
	public void rightClick(WebElement target)
	{
		Actions act = new Actions(driver);
		act.contextClick(target).perform();
		
	}
	
	public void dragAndDropElements(WebElement src,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
		
	}
	
	
	


}
