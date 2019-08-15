import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver

waiting {
    timeout = 5
    retryInterval = 0.5
}

baseUrl="http://localhost:8081/artifactory/"
baseNavigatorWaiting = true
requirePageAtCheckers = true
atCheckWaiting = true

driver = {
    WebDriverManager.chromedriver().setup()
    new ChromeDriver()
}