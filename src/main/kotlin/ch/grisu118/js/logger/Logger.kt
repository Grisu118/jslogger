package ch.grisu118.js.logger

class Logger(name: String, level: Level) : ALogger(name, level) {

  override fun trace(message: Any?) {
    if (isTrace) {
      log(Level.TRACE, message)
    }
  }

  override fun debug(message: Any?) {
    if (isDebug) {
      log(Level.DEBUG, message)
    }
  }

  override fun info(message: Any?) {
    if (isInfo) {
      log(Level.INFO, message)
    }
  }

  override fun warn(message: Any?) {
    if (isWarn) {
      log(Level.WARN, message)
    }
  }

  override fun error(message: Any?) {
    if (isError) {
      log(Level.ERROR, message)
    }
  }

  override fun trace(t: Throwable, message: Any?) {
    if (isTrace) {
      log(Level.TRACE, message, t)
    }
  }

  override fun debug(t: Throwable, message: Any?) {
    if (isDebug) {
      log(Level.DEBUG, message, t)
    }
  }

  override fun info(t: Throwable, message: Any?) {
    if (isInfo) {
      log(Level.INFO, message, t)
    }
  }

  override fun warn(t: Throwable, message: Any?) {
    if (isWarn) {
      log(Level.WARN, message, t)
    }
  }

  override fun error(t: Throwable, message: Any?) {
    if (isError) {
      log(Level.ERROR, message, t)
    }
  }

  override fun levelUpdate(level: Level) {
    this.level = level
  }

}