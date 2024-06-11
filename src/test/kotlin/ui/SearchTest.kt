package ui

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pages.GoogleStartPage
import pages.ResultsPage
import suites.UITest

class SearchTest : UITest() {
    private lateinit var startGooglePage: GoogleStartPage
    private lateinit var resultsPage: ResultsPage

    @BeforeEach
    fun initPages() {
        startGooglePage = GoogleStartPage(baseUrl)
        resultsPage = ResultsPage()
    }

    @Test
    fun search() {
        val searchText = "abc"

        startGooglePage.typeToSearch(searchText)
        startGooglePage.clickSubmitSearchButton()

        resultsPage.checkFirstSearchResult(searchText)
    }
}