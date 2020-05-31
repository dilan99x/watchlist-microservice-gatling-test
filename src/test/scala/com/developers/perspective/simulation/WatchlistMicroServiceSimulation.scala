package com.developers.perspective.simulation

/**
 * Created by dilan on 31/05/20.
 */

import com.developers.perspective.util._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import com.developers.perspective.scenarios.{GetAllWatchlists, GetWatchlist, PostWatchlist}

class WatchlistMicroServiceSimulation extends Simulation {

  val httpConf = http.baseURL(Environemnt.baseURL)
    .headers(Headers.commonHeader)

  val watchlistMicroServiceScenarios = List(

    PostWatchlist.postWatchlist.inject(atOnceUsers(Environemnt.users.toInt))
      .throttle(reachRps(6) in (2 seconds), holdFor(6 seconds)),

    GetWatchlist.getWatchlistById.inject(atOnceUsers(Environemnt.users.toInt))
      .throttle(reachRps(6) in (2 seconds), holdFor(6 seconds)),

    GetAllWatchlists.getWatchlists.inject(atOnceUsers(Environemnt.users.toInt))
      .throttle(reachRps(6) in (2 seconds), holdFor(6 seconds))

  )

  setUp(watchlistMicroServiceScenarios)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lessThan(Environemnt.maxResponseTime.toInt)
    )
}