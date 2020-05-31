package com.developers.perspective.scenarios

import io.gatling.core.Predef.{scenario, _}
import io.gatling.http.Predef.{http, status}

object GetAllWatchlists {
  val getAllWatchlistHttp = http("get all watchlists")
    .get("/watchlists")
    .check(status is 200)

  val getWatchlists = scenario("get all watchlists")
    .exec(getAllWatchlistHttp)
}
