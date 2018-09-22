import org.openqa.selenium.Cookie
import org.openqa.selenium.chrome.ChromeDriver

import io.github.bonigarcia.wdm.WebDriverManager

WebDriverManager.chromedriver().setup()

baseUrl = "https://id.g2a.com/"
System.setProperty("webdriver.chrome.driver", WebDriverManager.chromedriver().getBinaryPath())
chromeDriver = new ChromeDriver()
chromeDriver.manage().window().maximize()
chromeDriver.get(baseUrl)
chromeDriver.manage().addCookie(new Cookie("gdpr_cookie","%5B%5D"))
chromeDriver.navigate().refresh()
driver = { chromeDriver }

//baseUrl = "https://id.g2a.com/"

reportsDir = new File("target/geb-reports")
reportOnTestFailureOnly = true
