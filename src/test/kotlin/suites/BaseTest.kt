package suites

import com.codeborne.selenide.Configuration.*

abstract class BaseTest {
    val baseUrl: String = "https://www.google.com/"

    fun setUp() {
        browser = "chrome"
        webdriverLogsEnabled = true
        headless = true //display is visible
    }
}