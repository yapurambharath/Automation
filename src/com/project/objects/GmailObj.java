package com.project.objects;

import org.openqa.selenium.By;

public class GmailObj{
	
	public static By objGmail = By.xpath(".//*[contains(text(),'Gmail')]");
	public static By objSignin = By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a");
	public static By objGetMore = By.xpath(".//*[contains(text(),'Get more done')]");

}
