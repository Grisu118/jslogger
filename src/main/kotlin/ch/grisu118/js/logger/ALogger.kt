package ch.grisu118.js.logger

abstract class ALogger(protected val name: String, protected var level: Level) : ILogger {
  override val isTrace: Boolean
    get() = level >= Level.TRACE
  override val isDebug: Boolean
    get() = level >= Level.DEBUG
  override val isInfo: Boolean
    get() = level >= Level.INFO
  override val isWarn: Boolean
    get() = level >= Level.WARN
  override val isError: Boolean
    get() = level >= Level.ERROR

  protected fun log(level: Level, message: Any?) {
    val msg = LoggerConfig.replace(level = level, message = message, name = name)
    when (level) {
      Level.TRACE, Level.DEBUG -> console.log(msg)
      Level.INFO -> console.info(msg)
      Level.WARN -> console.warn(msg)
      Level.ERROR -> console.error(msg)
      else -> throw IllegalArgumentException("Invalid level $level")
    }
  }

  protected fun log(level: Level, message: Any?, t: Throwable) {
    val msg = LoggerConfig.replace(level = level, message = message, name = name)
    when (level) {
      Level.TRACE, Level.DEBUG -> console.log(msg, t)
      Level.INFO -> console.info(msg, t)
      Level.WARN -> console.warn(msg, t)
      Level.ERROR -> console.error(msg, t)
      else -> throw IllegalArgumentException("Invalid level $level")
    }
  }

}