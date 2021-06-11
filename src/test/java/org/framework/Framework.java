package org.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 12 pro max+",Keys.ENTER);
		List<WebElement> productAmount = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		int size = productAmount.size();
		System.out.println("Total Numbers:" +size);
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < productAmount.size(); i++) {
			
			String text = productAmount.get(i).getText();
			String a = text.replace(",","");
			list.add(a);
		}
		
		    Collections.sort(list);
			for (String ascOder : list) {
			System.out.println(ascOder);
			
		}
		
//		File file = new File("C:\\Users\\kamal\\eclipse-workspace\\Framework\\src\\test\\java\\ExcelRead\\Work_book.xlsx");
//		FileInputStream stream = new FileInputStream(file);
//		Workbook workbook = new XSSFWorkbook(stream);
//		Sheet createSheet = workbook.createSheet("iPhone Pro +");
//		for (int i = 0; i < productAmount.size(); i++) {
//			Row createRow = createSheet.createRow(i);
//			for (int j = 0; j==0; j++) {
//				Cell createCell = createRow.createCell(j);
//				String text = productAmount.get(i).getText();
//				createCell.setCellValue(text);
//				
//			}
//			
//			
//			
//		}
//		FileOutputStream outputStream = new FileOutputStream(file);
//		workbook.write(outputStream);
//		System.out.println("EXCEL UPDATED");
//			FileOutputStream outputStream = new FileOutputStream(file);
//			workbook.write(outputStream);
//			System.out.println("EXCEL UPDATED");
	}

}
