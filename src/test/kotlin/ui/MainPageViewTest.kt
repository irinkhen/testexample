package ui

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pages.GoogleStartPage
import suites.UITest

class MainPageViewTest : UITest() {
    private lateinit var googleStartPage: GoogleStartPage

    @BeforeEach
    fun initPages() {
        googleStartPage = GoogleStartPage(baseUrl)
    }

    @Test
    fun checkMainPageView() {
        googleStartPage.pageIsLoaded()
    }
}