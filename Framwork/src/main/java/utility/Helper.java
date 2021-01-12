package utility;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Helper {

	public static String CaptureScreenshot(WebDriver driver, String testcasename) {

		TakesScreenshot screens = ((TakesScreenshot) driver);
		File screenFiles = screens.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				System.getProperty("user.dir") + "//Screenshot//" + GetCurrentTime()+" " +testcasename + ".PNG");
		System.out.println("------ Screenshot Taken ------");
		try {
			Files.copy(screenFiles, DestFile);
		} catch (Exception e) {
			System.out.println("Unable to Capture Screenshot" + e.getMessage());
		}

		String screenshotPath = DestFile.toString();
		return screenshotPath;
	}

	public static String GetCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return (dtf.format(now));
	}

}
