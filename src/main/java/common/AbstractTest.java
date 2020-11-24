package common;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	private WebDriver driver;
	// private String source_folder = System.getProperty("user.dir");
	protected final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());

	}
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	protected static ThreadLocal<String> browserName= new ThreadLocal<String>();

	protected WebDriver getBrowserDriver(String browserName, String url) {

		if (browserName.equalsIgnoreCase("chrome_ui")) {
			// System.setProperty("webdriver.chrome.driver", source_folder +
			// "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			setDriver(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase("firefox_ui")) {
			// System.setProperty("webdriver.geckodriver.driver", source_folder +
			// "\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().arch64().setup();
			setDriver(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge_ui")) {
			// System.setProperty("webdriver.edge.driver", source_folder +
			// "\\browserDriver\\msedgedriver.exe");

			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			// System.setProperty("webdriver.chrome.driver", source_folder +
			// "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size:1920x1080");
			setDriver(new ChromeDriver(chromeOpt));
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			// System.setProperty("webdriver.geckodriver.driver", source_folder +
			// "\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setHeadless(true);
			firefoxOption.addArguments("headless");
			firefoxOption.addArguments("window-size:1920x1080");
			setDriver(new FirefoxDriver(firefoxOption));
		} else if (browserName.equalsIgnoreCase("Coc_Coc")) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions chromeOpt = new ChromeOptions();
//			chromeOpt.setBinary("");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			setDriver(new SafariDriver());

		} else {
			throw new RuntimeException("Vui long nhap dung ten trinh duyet");
		}
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(url);
		return getDriver();
	}

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome_ui")) {
			// System.setProperty("webdriver.chrome.driver", source_folder +
			// "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			setDriver(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase("firefox_ui")) {
			// System.setProperty("webdriver.geckodriver.driver", source_folder +
			// "\\browserDriver\\geckodriver.exe");

			WebDriverManager.firefoxdriver().arch64().setup();
			setDriver(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge_ui")) {
			// System.setProperty("webdriver.edge.driver", source_folder +
			// "\\browserDriver\\msedgedriver.exe");

			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			// System.setProperty("webdriver.chrome.driver", source_folder +
			// "\\browserDriver\\chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size:1920x1080");
			setDriver(new ChromeDriver(chromeOpt));
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			// System.setProperty("webdriver.geckodriver.driver", source_folder +
			// "\\browserDriver\\geckodriver.exe");

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setHeadless(true);
			firefoxOption.addArguments("headless");
			firefoxOption.addArguments("window-size:1920x1080");
			setDriver(new FirefoxDriver(firefoxOption));
		} else if (browserName.equalsIgnoreCase("Coc_Coc")) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions chromeOpt = new ChromeOptions();
//			chromeOpt.setBinary("");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			setDriver(new SafariDriver());

		} else {
			throw new RuntimeException("Vui long nhap dung ten trinh duyet");
		}
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	protected void removeDriver() {
		try {
			// get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			
			// Close browser
			if (getDriver() != null) {
				getDriver().quit();
			}

			// Close service (browser driver)
			if (getDriver().toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (getDriver().toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (getDriver().toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			} else if (getDriver().toString().toLowerCase().contains("edge")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill edgedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq edgedriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		threadLocalDriver.remove();
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	private void setDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
