package pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.`$$`

class ResultsPage {
    private val firstResultText = `$$`("span>em")
    private val resultLinks = `$$`("cite[role=\"text\"]")

    fun checkFirstSearchResult(searchRequestText: String): ResultsPage {
        firstResultText.first().shouldHave(text(searchRequestText))
        resultLinks.first().shouldHave(text(searchRequestText))
        return this
    }
}