package db

import helpers.DataBaseHelper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import suites.BaseTest

class DBConnectionTest : BaseTest() {
    private var dataBaseHelper = DataBaseHelper()

    @BeforeEach
    fun initPages() {
        dataBaseHelper = DataBaseHelper()
    }

    @Test
    fun testDBConnection() {
        val citizenIdByPassport = dataBaseHelper.getCitizenIdByPassport()
        val applicationIdByCitizenId = dataBaseHelper.getApplicationIdByCitizenId()
        println("$citizenIdByPassport $applicationIdByCitizenId")
    }
}