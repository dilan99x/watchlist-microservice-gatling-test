package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PostWatchlist {

  val body = "{\"name\":\"WL_1\",\"userId\":\"ADMIN\"}"

  val postWatchlistHttp = http("post watchlist")
    .post("/watchlists")
    .body(StringBody(body))
    .check(status is 201)

  val postWatchlist = scenario("post user")
    .exec(postWatchlistHttp)
}
