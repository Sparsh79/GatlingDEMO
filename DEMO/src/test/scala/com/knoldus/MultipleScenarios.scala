package com.knoldus
import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
class MultipleScenarios extends Simulation {
  /*
    val config: Config = ConfigFactory.load("application.conf")
    val url: String = config.getString("url")
    val AtOnceUsers: Int = config.getInt("atOnceUsers")
    val RampUsers: Int = config.getInt("rampUsers")
    val RampFrequency: Int = config.getInt("rampFrequency")
    val ConstantUsers: Int = config.getInt("constantUsers")
    val ConstantUsersFrequency: Int = config.getInt("constantUsersFrequency")
    val RampUsersPerStartingRate: Int = config.getInt("rampUsersPerSecond")
    val RampUsersPerTargetRate: Int = config.getInt("rampUsersPerSecondTarget")

 If we need to take input from the terminal, we can use the above code.
   */
  val url: String = "https://reqres.in/api/users?page=2"
  val AtOnceUsers: Int = 30
  val RampUsers: Int = 10
  val RampFrequency: Int = 5
  val ConstantUsers: Int = 10
  val ConstantUsersFrequency: Int = 5
  val RampUsersPerStartingRate: Int = 10
  val RampUsersPerTargetRate: Int = 100

  val OK = 200
  def createScenarioBuilder(scenarioName: String, requestName: String, path: String, pauseDuration: Int): ScenarioBuilder = {
    /**
     * generic method for creating a scenario
     */
    val scene: ScenarioBuilder = scenario(scenarioName) // creating the scenario on which simulation will happen.
      .exec(http(requestName)
        .get(url).check(status.is(OK)) // status code assertion
        .check(jsonPath(path).findAll)) // asserting JSON
      .pause(pauseDuration)
    scene
  }
  def setUp(): Unit = {
    /**
     * to set up the scenario and to inject the number of users.
     */
    val atOnceScenario = createScenarioBuilder("at once users", "request1", "$..page", 0)
    val rampUpUsersScenario = createScenarioBuilder("ramp users", "request2", "$..page", 0)
    val constantUserPerSecScenario = createScenarioBuilder("constant users per second", "request3", "$..page", 0)
    val rampUserPerSecScenario = createScenarioBuilder("ramp users per second", "request4", "$..page", 0)
    val httpProtocol: HttpProtocolBuilder = http.baseUrl(url)
    setUp(atOnceScenario.inject(atOnceUsers(AtOnceUsers)).protocols(httpProtocol),
      // atOnceScenario -> Injects a given number of users at once.
      rampUpUsersScenario.inject(rampUsers(RampUsers) during RampFrequency).protocols(httpProtocol),
      // rampUsers -> Injects a given number of users distributed evenly on a time window of a given duration.
      constantUserPerSecScenario.inject(constantUsersPerSec(ConstantUsers) during ConstantUsersFrequency).protocols(httpProtocol),
      // constantUsersPerSec ->  Injects users at a constant rate, defined in users per second, during a given duration. Users will be injected at regular intervals.
      rampUserPerSecScenario.inject(rampUsersPerSec(RampUsersPerStartingRate) to RampUsersPerTargetRate during RampFrequency).protocols(httpProtocol))
      // rampUsersPerSec -> Injects users from starting rate to target rate, defined in users per second, during a given duration. Users will be injected at regular intervals.
  }
  setUp()
}