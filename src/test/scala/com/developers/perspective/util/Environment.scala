/**
  * Created by dmumma on 11/19/15.
  */

package com.developers.perspective.util

import java.util

object Environemnt {
  val baseURL = scala.util.Properties.envOrElse("baseURL", "http://localhost:8080/api")
  val users = scala.util.Properties.envOrElse("numberOfUsers", "50")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "500") // in milliseconds

}
