package db

import exceptions.WrongUserStatusInDBException
import helpers.DataBaseHelper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DBUserStatusTest {
    private var dataBaseHelper = DataBaseHelper()

    @BeforeEach
    fun initPages() {
        dataBaseHelper = DataBaseHelper()
    }

    @Test
    fun getUserStatusTest() {
        var status = ""
        try {
            status = dataBaseHelper.getWrongApplicationStatus()
            checkUserStatus(status)
        } catch (e: WrongUserStatusInDBException) {
            println("So sad, try later. Current user status is $status")
            status = dataBaseHelper.getApplicationStatus()
        } finally {
            println("User status was changed. Current status is $status")
        }
    }

    @Test
    fun getWrongUserStatusTest() {
        val status: String = dataBaseHelper.getWrongApplicationStatus()
        checkUserStatus(status)
    }

    @Throws(WrongUserStatusInDBException::class)
    fun checkUserStatus(userStatus: String) {
        if (userStatus != "approved") {
            throw WrongUserStatusInDBException("You've got wrong status: $userStatus :(")
        }
    }
}