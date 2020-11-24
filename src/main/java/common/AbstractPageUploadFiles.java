package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AbstractPageUploadFiles extends AbstractPage {
	WebDriver driver;
	private String osName = System.getProperty("os.name");

	public AbstractPageUploadFiles(WebDriver driver) {
		this.driver = driver;
	}
	public String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public boolean isWindow() {
		return (osName.toLowerCase().indexOf("window") >= 0);
	}

	public boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	public boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0
				|| osName.toLowerCase().indexOf("aix") > 0);
	}

	public boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	public void uploadMutilFiles(WebDriver driver,String locator, String folderName, String... files) {
		String fullFilePath = "";
		for (String File : files) {
			fullFilePath = fullFilePath + GlobalConstants.FOLDER_NAME + getDirectorySlash(folderName) + File + "\n";
		}
		fullFilePath = fullFilePath.trim();
		senkeyToElement(driver,locator, fullFilePath);

	}

	public boolean areFileUploadDisplay(WebDriver driver, String locatorFile, String... filesName) {
		boolean status = false;
		int number = filesName.length;

		waitForElementVisible(driver, locatorFile);
		List<WebElement> images = findElementsByXpath(driver, locatorFile);
		List<String> imageValues = new ArrayList<String>();
		int i = 0;
		for (WebElement Image : images) {
			imageValues.add(Image.getAttribute("src"));
			i++;
			if (number == i) {
				break;
			}
		}

		for (String fileName : filesName) {
			String[] files = fileName.split("\\.");
			String FileName = files[0].toLowerCase();

			for (i = 0; i < imageValues.size(); i++) {
				if (!imageValues.get(0).contains(FileName)) {
					status = false;
					if (i == imageValues.size() - 1) {
						return status;
					}
				} else {
					status = true;
					;
				}
			}
		}

		return status;
	}

	public void uploadFileByClipboardRobot(String folderName, String fileName) throws AWTException {
		String fullFilePath = " ";
		fullFilePath = GlobalConstants.FOLDER_NAME + getDirectorySlash(folderName) + fileName;
		StringSelection select = new StringSelection(fullFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		sleepInSecond(4);

		// nhan enter rui nha enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// giu Ctrl +V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		// bỏ Ctrl +V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		// nhan enter rui nha enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
