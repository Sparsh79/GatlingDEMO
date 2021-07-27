package com.knoldus
import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
/**
 * galting test for Demo API's .
 */
class IndividualAPI extends Simulation {
//  val config: Config = ConfigFactory.load("application.conf")
//  val url: String = config.getString("url")
//  val users: Int = config.getInt("users")
  val url: String = "https://reqres.in/api/users?page=2"
  val users: Int = 100
  val OK = 200
  def createScenarioBuilder(scenarioName: String, requestName: String, path: String, pauseDuration: Int): ScenarioBuilder = {
    /**
     * generic method for creating a scenario
     */
    val scene: ScenarioBuilder = scenario(scenarioName)
      .exec(http(requestName)
        .get(url).check(status.is(OK))
        .check(jsonPath(path).findAll))
      .pause(pauseDuration)
    scene
  }
  def setUp(): Unit = {
    /**
     * to set up the scenario and to inject the number of users.
     */
    val scenarioBuilder = createScenarioBuilder("Sample api test", "IndividualRequest", "$..page", 1)
    val httpProtocol: HttpProtocolBuilder = http.baseUrl(url)
    setUp(scenarioBuilder.inject(atOnceUsers(users)).protocols(httpProtocol))
  }
  setUp()
}


