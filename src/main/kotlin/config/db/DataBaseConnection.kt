package config.db

import java.lang.System.getProperty
import java.sql.Connection
import java.sql.DriverManager.getConnection
import java.sql.SQLException

class DataBaseConnection {
    private lateinit var dbConnection: Connection
    private lateinit var dbHost: String
    private lateinit var dbPort: String
    private lateinit var dbUser: String
    private lateinit var dbPassword: String
    private lateinit var dbName: String

    @Throws(ClassNotFoundException::class, SQLException::class)
    fun getDBConnection(): Connection {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("db.properties"))
        dbHost = getProperty("dbHost")
        dbPort = getProperty("dbPort")
        dbName = getProperty("dbName")
        dbUser = getProperty("dbUser")
        dbPassword = getProperty("dbPassword")

        val connection = "jdbc:postgresql://" +
                dbHost + ":" +
                dbPort + "/" +
                dbName

        dbConnection = getConnection(connection, dbUser, dbPassword)
        return dbConnection
    }

    fun getSingleValueQuery(query: String): String {
        var result = ""
        try {
            getDBConnection().prepareStatement(query).executeQuery().use { resultSet ->
                if (resultSet.next()) {
                    result = resultSet.getString(1)
                }
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } catch (e: ClassNotFoundException) {
            throw RuntimeException(e)
        } finally {
            closeConnection()
        }
        return result
    }

    private fun closeConnection() {
        try {
            dbConnection.close()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }
}