package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.open

class GoogleStartPage(baseUrl: String) {
    private val title = Selenide.`$x`("//img[@alt=\"Google\"]")
    private val searchField = Selenide.`$x`("//textarea[@title=\"Search\"]")
    private val submitSearchButton = Selenide.`$x`("//input[@value=\"Google Search\"]")
    private val imFeelingLuckyButton = Selenide.`$x`("//input[@value=\"I'm Feeling Lucky\"]")

    init {
        open(baseUrl)
    }

    fun pageIsLoaded(): GoogleStartPage {
        title.shouldBe(Condition.visible)
        searchField.shouldBe(Condition.visible)
        submitSearchButton.shouldBe(Condition.visible)
        imFeelingLuckyButton.shouldBe(Condition.visible)
        return this
    }

    fun typeToSearch(searchRequestText: String?): GoogleStartPage {
        searchField.clear()
        searchField.sendKeys(searchRequestText)
        return this
    }

    fun clickSubmitSearchButton(): ResultsPage {
        submitSearchButton.click()
        return Selenide.page(ResultsPage::class.java)
    }
}