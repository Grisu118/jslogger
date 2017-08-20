package ch.grisu118.js.logger

import kotlin.reflect.KFunction1

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

  protected fun log(fn: KFunction1<@ParameterName(
    name = "o") Array<out Any?>, Unit>, level: Level, message: Any?) {
    fn(arrayOf("$level [$name]: $message"))
  }

  protected fun log(fn: KFunction1<@ParameterName(
    name = "o") Array<out Any?>, Unit>, level: Level, message: Any?, t: Throwable) {
    fn(arrayOf("$level [$name]: $message", t))
  }
}