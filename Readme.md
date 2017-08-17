# KotlinJS Logger

[ ![Release](https://api.bintray.com/packages/grisu118/kotlin/jslogger/images/download.svg) ](https://bintray.com/grisu118/kotlin/jslogger/_latestVersion)

Simple Logger for KotlinJS

## Usage

````kotlin
class XY {
  val logger = LoggerFactory.logger(this)
  
  fun test() {
    logger.info("Will be evaluated always")
    logger.info{ "Will be evaluated only if info or lower level is active" }
  }
}
````

### Available Loglevels
* Trace
* Debug
* Info
* Warn
* Error
* Off

### Change Loglevel

* `LoggerFactory.loglevel(Regex("XY"), Level.DEBUG)`
  * you can set the loglevel for all loggers created after this call and matching the regex. 
* `LoggerFactory.updateLevel(Regex("XY"), Level.TRACE)`
  * in addition to the effect of the above method. All existing and matching loggers will change their level.
  
In both cases, the logger will use the highest level from all matching levels.
