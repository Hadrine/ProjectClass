package org.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
//	BrowserLaunch
	public static WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		return driver;
	}
//	URL Launch
	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
//wait
	public static void implicityWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
//	getURL
	private static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
//	getTitle
	private static String  getTitle() {
		String title = driver.getTitle();
		return title;
	}
//	quit
	public static void quit() {
		driver.quit();
	}
//	sendKeys
	public static void sendKeys(WebElement e,String user) {
		e.sendKeys(user);
	}
//	click
	public static void click(WebElement e) {
		e.click();
	}
//	findElement
	public static WebElement findElement(String locatorName,String locatorValue) {
		WebElement value=null;
		if(locatorName.equals("id")) {
			 value = driver.findElement(By.id(locatorValue));
		}
		else if(locatorName.equals("name")) {
			value= driver.findElement(By.name(locatorValue));
		}
		else if(locatorName.equals("xpath")) {
			value=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorName.equals("tagName")) {
			driver.findElement(By.tagName(locatorValue));
	}
		return value;
	}
//	getText
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
//	getAttribute
	public String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
//	Actions
//	moveToElement
	public static void movetToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
//	contextClick
	public static void contextClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}
//	dragAnddrop
	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
//	doubleClick
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}
//	clickAndHold
	private void clickAndHold(WebElement scr,WebElement des) {
		Actions a=new Actions(driver);
		a.clickAndHold(scr).release(des).perform();
	}
//	clear
	public static void clear(WebElement e) {
		e.clear();
	}
//copyText
	public static void copyText(WebElement e) throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
//		pasteText
	public static void pasteText(WebElement e) throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	
//	selectByValue
	public static void selectByValue(WebElement e,String Value) {
		Select s=new Select(e);
		s.selectByValue(Value);
		}
//	selectByIndex
	public static void selectByIndex(WebElement e, int Value) {
		Select s=new Select(e);
		s.selectByIndex(Value);
	}
//selectByVisibleText
	public static void selectByVisibileText(WebElement e,String Value) {
		Select s=new Select(e);
		s.selectByVisibleText(Value);
	}
//	getFirstSelectedOption
	public static void getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		s.getFirstSelectedOption();
	}
//	deselectByIndex
	public static void deSelectByIndex(WebElement e,int Value) {
		Select s=new Select(e);
		s.deselectByIndex(Value);
	}
//	deSelectByValue
	public static void deSelectByValue(WebElement e,String Value) {
		Select s=new Select(e);
		s.deselectByValue(Value);
	}
//	deSelectByVisibleText
	public static void deSelectByVisibleText(WebElement e,String Value) {
		Select s=new Select(e);
		s.deselectByVisibleText(Value);
	}
//	deSelectAll
	public static void deSelectAll(WebElement e,String Value) {
		Select s=new Select(e);
		s.deselectAll();
	}
// windowHandling
	public static void windowhandling(WebElement e, String Value ) {
		String parentid = driver.getWindowHandle();
		String allIds = driver.getWindowHandle();
		driver.switchTo().window(Value);
	}
//Frames
	public static void frames(WebElement e, String Value) {
		driver.switchTo().frame("Value");
	}
//		Come out of Frames
	private void frame(WebElement e) {
		driver.switchTo().defaultContent();
	}
//dropDown
//	select
	public static void Select(WebElement e, String Value) {
		Select s=new Select(e);
	}
//    select by index
	public static void index (WebElement e, int Value) {
		Select s=new Select(e);
		s.selectByIndex(Value);
	}
//	select by value
	public static void value(WebElement e, String Value) {
		Select s=new Select(e);
		s.selectByValue(Value);
	}
//	select by visible text
	public static void visible(WebElement e, String Value) {
		Select s=new Select(e);
		s.selectByVisibleText(Value);
	}
//	get options
	public static void getOptions(WebElement e, String Value) {
		Select s=new Select(e);
		s.getOptions();
	}
//	getAll Selected Options
	public static void selectedOptions(WebElement e, String Value) {
		Select s=new Select(e);
	s.getAllSelectedOptions();	
	}
//	get First Selected options
	public static void firstSelected(WebElement e, String Value) {
		Select s=new Select(e);
		s.getFirstSelectedOption();
	}
//	isMultiple
	public static void multiple(WebElement e, Boolean Value) {
		Select s=new Select(e);
		s.isMultiple();
	}
//	deSelect by index
	
	public static void deselectbyIndex(WebElement e, int Value) {
		Select s=new Select(e);
		s.deselectByIndex(Value);
	}
//	deSelect by value
	public static void deselectByValue(WebElement e, String Value) {
		Select s=new Select(e);
		s.deselectByValue(Value);
	}
//	deSelect by VisibleText
	public static void deslectByVisibleText(WebElement e, String Value) {
		Select s=new Select(e);
		s.deselectByVisibleText(Value);
	}
//	deSelect All
	public static void deselectAll(WebElement e, String Value) {
		Select s=new Select(e);
		s.deselectAll();
	}
//	Screenshot
	public static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\Abilash\\eclipse-workspace\\BrowserLaunch\\src\\test\\resources"+name+".png");
        FileUtils.copyFile(src,des);
	}
//JS
//	JS Sendkeys
	public static void jsSendkeys(WebElement e, String name) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+name+"')", e);
	}
	
//	JS getAttribute
	public static String jsgetAttribute(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object atUser =(JavascriptExecutor) js.executeScript("return arguments[0].getAttribute('value')", e);
		String st = atUser.toString();
		return st;
	}

	
//	Excel
//	Excel Value
	public static String getExcelData(String name,String sheetName, int rowNo,int cellNo) throws IOException {
	    File loc =new File("C:\\Users\\Abilash\\eclipse-workspace\\BrowserLaunch\\src\\test\\resources\\"+name+".xlsx");
	    FileInputStream fi=new FileInputStream(loc);
	    Workbook w=new XSSFWorkbook(fi);
	    Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rowNo);
		Cell cell = r.getCell(cellNo);
		int type = cell.getCellType();
		String value=null;
		if(type==1) {
			value=cell.getStringCellValue();
		}
		else {
		if(DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat si=new SimpleDateFormat("dd-MMM-yyyy");
			value = si.format(d);
		}
		else {
			double dob = cell.getNumericCellValue();
			long ln =(long) dob;
			value=String.valueOf(ln);
		}
		}
		
		return value;

	}
	
}
