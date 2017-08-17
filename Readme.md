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

### Loglevel
* Trace
* Debug
* Info
* Warn
* Error
* Off

### Change Loglevel

Call `LogFactory.loglevel(Regex(".*"), Level.DEBUG)` before creating the logger.
The highest level from all matching levels is used!
