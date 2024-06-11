package helpers

import config.db.DataBaseConnection
import exceptions.WrongUserStatusInDBException
import io.qameta.allure.Step

class DataBaseHelper {
    @Step("Get random user Id")
    fun getCitizenIdByPassport(): String {
        val query = "SELECT citizenid FROM reg_office.citizens ORDER BY RANDOM() LIMIT 1"
        return DataBaseConnection().getSingleValueQuery(query)
    }

    @Step("Get random application id")
    fun getApplicationIdByCitizenId(): String {
        val query = "SELECT applicationId FROM reg_office.applications ORDER BY RANDOM() LIMIT 1"
        return DataBaseConnection().getSingleValueQuery(query)
    }

    @Step("Get application status from database")
    fun getApplicationStatus(): String {
        val query = "SELECT statusofapplication FROM reg_office.applications " +
                "WHERE statusofapplication = 'approved' ORDER BY RANDOM() LIMIT 1"
        return DataBaseConnection().getSingleValueQuery(query)
    }

    @Step("Get application status from database")
    @Throws(WrongUserStatusInDBException::class)
    fun getWrongApplicationStatus(): String {
        val query = "SELECT statusofapplication FROM reg_office.applications " +
                "WHERE statusofapplication != 'approved' ORDER BY RANDOM() LIMIT 1"
        return DataBaseConnection().getSingleValueQuery(query)
    }
}