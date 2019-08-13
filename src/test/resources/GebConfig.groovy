import org.openqa.selenium.chrome.ChromeDriver

waiting {
    timeout = 5
    retryInterval = 0.5
}

baseUrl="http://localhost:8081/"
baseNavigatorWaiting = true
requirePageAtCheckers = true
atCheckWaiting = true

driver = { new ChromeDriver() }