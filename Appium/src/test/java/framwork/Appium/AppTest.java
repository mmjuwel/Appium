package framwork.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppTest {
    
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) {
		try {
			apptests();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}
	
    public static void apptests() throws Exception
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Mi A2 Lite");
        cap.setCapability("udid", "47046b3d0305");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        
//        cap.setCapability("appPackage", "com.ihadis.ihadis");
//        cap.setCapability("appActivity", "com.ihadis.ihadis.activity.MainActivity");
        
        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url,cap);
        
        System.out.println("Application Started...");
        Thread.sleep(2000);
        
        MobileElement five= driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement eight= driver.findElement(By.id("com.google.android.calculator:id/digit_8"));

        MobileElement plus= driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement equal= driver.findElement(By.id("com.google.android.calculator:id/eq"));
        
        MobileElement result= driver.findElement(By.id("com.google.android.calculator:id/result_preview"));

        five.click();
        plus.click();
        eight.click();
        equal.click();
        
        String res= result.getText();
        
        System.out.println("\n Result: "+res);
        
        
    }

 
}
