package ch.grisu118.js.logger

/**
 * The main factory for managing logger instances.
 * @author Benjamin Leber
 */
object LoggerFactory {

  private val defaultLevel = Level.INFO
  private val levels = mutableMapOf<Regex, Level>()
  private val loggers = mutableMapOf<String, Logger>()

  /**
   * @param owner The owner of this logger.
   * @return Creates or get the logger for the given owner.
   */
  fun logger(owner: Any): ILogger {
    val dyn = owner.asDynamic()
    return dyn.__g118Logger ?: run {
      val logger = logger(owner::class.js.name)
      dyn.__g118Logger = logger
      logger
    }
  }

  /**
   * @param name The name of this logger.
   * @return Creates or get the logger for the given name.
   */
  fun logger(name: String): ILogger {
    return loggers[name] ?: run {
      val logger = Logger(name, level(name))
      loggers[name] = logger
      logger
    }
  }

  /**
   * Set the level for all loggers created after this level is set and which match the given regex.
   * If multiple regex matches, then the highest seen level is used.
   * @param regex the regex to identify associated loggers.
   * @param level the level for the associated loggers.
   */
  fun loglevel(regex: Regex, level: Level) {
    levels.put(regex, level)
  }

  /**
   * Set the level for all loggers.
   * If multiple regex matches, then the highest seen level is used.
   * @param regex the regex to identify associated loggers.
   * @param level the level for the associated loggers.
   */
  fun updateLevel(regex: Regex, level: Level) {
    levels.put(regex, level)
    loggers.forEach {
      it.value.levelUpdate(LoggerFactory.level(it.key))
    }
  }

  private fun level(name: String) = levels.filter { it.key.matches(name) }.maxBy { it.value }?.value ?: defaultLevel

}