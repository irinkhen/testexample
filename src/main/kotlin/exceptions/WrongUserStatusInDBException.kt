package exceptions

/**
 * This exception does not like when database result returns user not in approved status
 */
class WrongUserStatusInDBException : Exception {
    constructor(message: String?) : super(message)
}