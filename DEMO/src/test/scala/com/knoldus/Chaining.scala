package com.knoldus
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scala.concurrent.duration.DurationInt

class Chaining extends  Simulation{

  val httpProtocol: HttpProtocolBuilder = http.baseUrl("https://reqres.in/api/")

  val GetFirstUser = group("1st User")
  {
    exec(http("GET 1 User Only Request")
      .get("users/2")
      .check(status.is(200)))
      .pause(1)
  }
  val GetChainedUsers = group("GET user request chaining") // Create group of requests to model process or requests in a same page and groups can be nested.
  {
    exec(http("request_1")
      .get("users/2"))
      .pause(1)
      .exec(http("request_2")
        .get("users/2").check(status.is(200)))
      .pause(2)
      .exec(http("request_3")
        .get("users/23").check(status.is(404)))
      .pause(3)
      .exec(http("request_4")
        .get("unknown"))
      .pause(4)
  }
  val updateUserChained = group("Update user Chaining")
  {
    exec(http("request_6")
      .post("users").check(status.is(201))
      .formParam("/name", "/morpheus")
      .formParam("/job", "/lead"))
      .pause(2)
      .exec(http("request_7")
        .put("users/2").check(status.is(200))
        .formParam("/name", "/morpheus")
        .formParam("/job", "zion resident"))
      .pause(2)
      .exec(http("request_7")
        .patch("users/2").check(status.is(200))
        .formParam("name", "morpheus")
        .formParam("job", "zion resident"))
      .pause(1)
      .exec(http("request_8")
        .delete("users/2").check(status.is(204)))
      .pause(2)
  }

  //  Define Scenario
  val firstSimulation = exec(GetFirstUser)
  val secondSimulation = exec(GetChainedUsers,updateUserChained)
  val thirdSimulation = exec(updateUserChained)

 //Injection simulation
  val scn: ScenarioBuilder = scenario("Load_Test_Scenario").exec(exec(firstSimulation).during(60 seconds)
  {
    pace(10) // If you want to control how frequently an action is executed, to target iterations per hour type volumes. Gatling support a dedicated type of pause: pace, which adjusts its wait time depending on how long the chained action took
    exec(secondSimulation)
  })

  setUp(scn.inject(atOnceUsers(50))).protocols(httpProtocol)
}

