package com.developers.perspective.scenarios

import io.gatling.core.Predef.{scenario, _}
import io.gatling.http.Predef.{http, status}

object GetWatchlist {

  val getWatchlistHttp = http("get watchlist by id")
    .get("/watchlists/1")
    .check(status.is(200))

  val getWatchlistById = scenario("Get watchlist by id")
    .exec(
      getWatchlistHttp
    )
}
