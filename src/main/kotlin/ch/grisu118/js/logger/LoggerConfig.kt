package ch.grisu118.js.logger

import ch.grisu118.js.api.Date

object LoggerConfig {

  /**
   * The template for the log messages.
   * The following Placeholders exists:
   * + **%l** - Will be replaced with the level of this message
   * + **%n** - Will be replaced with the name of the logger
   * + **%m** - Will be replaced with the message
   * + **%t** - Will be replaced with the current time
   * + **%dt** - Will be replaced with the iso datetime string
   * + **%%** - Will be replaced with with a single `%`
   */
  var messageTemplate = "%l [%n]: %m"

  internal fun replace(level: Level, name: String, message: Any?): String {
    val date = Date()
    var msg = messageTemplate.replace("%l", level.toString())
    msg = msg.replace("%n", name)
    msg = msg.replace("%m", message.toString())
    msg = msg.replace("%dt", date.toISOString())
    msg = msg.replace("%t", date.toTimeString())
    msg = msg.replace("%%", "%")
    return msg
  }
}