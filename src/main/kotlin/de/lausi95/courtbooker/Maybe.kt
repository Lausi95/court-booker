package de.lausi95.courtbooker

data class Maybe<T>(
  val result: T?,
  val error: String?
) {

  companion object {

    fun <U> error(message: String): Maybe<U> {
      return Maybe(null, message)
    }

    fun <U> success(value: U): Maybe<U> {
      return Maybe(value, null)
    }
  }

  inline fun onError(errorHandler: (message: String) -> Unit): T {
    if (error != null) {
      errorHandler(error)
    }
    if (result == null) {
      errorHandler("There is no error, but also no value")
    }
    return result!!
  }
}
