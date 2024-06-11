package suites

import com.codeborne.selenide.Selenide.closeWebDriver
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll

open class UITest : BaseTest() {

    companion object {
        @JvmStatic
        @BeforeAll
        fun init() {
            val url = "https://www.google.com/"
            open(url)
        }

        @JvmStatic
        @AfterAll
        fun quit() {
            closeWebDriver()
        }
    }
}