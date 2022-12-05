package gatling.sample

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GatlingTests extends Simulation {

	val httpProtocol = http
		.baseUrl("https://seashell-app-gm3fi.ondigitalocean.app")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("application/json, text/plain, */*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")

	val headers_0 = Map(
		"content-type" -> "application/json",
		"origin" -> "https://hammerhead-app-2g6n4.ondigitalocean.app",
		"sec-ch-ua" -> """Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_1 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"sec-ch-ua" -> """Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_2 = Map(
		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyQHVzZXIudXNlciIsImlhdCI6MTY3MDIyMjE4OCwiZXhwIjoxNjcwMzA4NTg4fQ.ITfX0tLzgxpFG9dkPuBfB_TnOo0GkyBMli-ufNWqRF7LsEywH6bMxZQQ8HosLs60BYZgFDfd3dZbW-Rc58sNGw",
		"origin" -> "https://hammerhead-app-2g6n4.ondigitalocean.app",
		"sec-ch-ua" -> """Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_7 = Map(
		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyQHVzZXIudXNlciIsImlhdCI6MTY3MDIyMjE4OCwiZXhwIjoxNjcwMzA4NTg4fQ.ITfX0tLzgxpFG9dkPuBfB_TnOo0GkyBMli-ufNWqRF7LsEywH6bMxZQQ8HosLs60BYZgFDfd3dZbW-Rc58sNGw",
		"content-type" -> "application/json",
		"origin" -> "https://hammerhead-app-2g6n4.ondigitalocean.app",
		"sec-ch-ua" -> """Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_17 = Map(
		"accept" -> "*/*",
		"access-control-request-headers" -> "authorization",
		"access-control-request-method" -> "PUT",
		"origin" -> "https://hammerhead-app-2g6n4.ondigitalocean.app",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_18 = Map(
		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyQHVzZXIudXNlciIsImlhdCI6MTY3MDIyMjE4OCwiZXhwIjoxNjcwMzA4NTg4fQ.ITfX0tLzgxpFG9dkPuBfB_TnOo0GkyBMli-ufNWqRF7LsEywH6bMxZQQ8HosLs60BYZgFDfd3dZbW-Rc58sNGw",
		"content-type" -> "application/x-www-form-urlencoded",
		"origin" -> "https://hammerhead-app-2g6n4.ondigitalocean.app",
		"sec-ch-ua" -> """Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

    val uri2 = "https://hammerhead-app-2g6n4.ondigitalocean.app"

	val scn1 = scenario("scn1")
		.exec(http("SignIn")
			.post("/api/auth/signin")
			.headers(headers_0)
			.body(RawFileBody("gatling/sample/user2/0000_request.json"))
			.resources(http("Profile")
			.get(uri2 + "/profile")
			.headers(headers_1)))
		.pause(5)
		.exec(http("MyAllotment")
			.get("/api/allotment/getMyAllotment/6")
			.headers(headers_2)
			.resources(http("MyReservations")
			.get("/api/reservation/getMyReservation/6")
			.headers(headers_2)))
		.pause(4)
		.exec(http("FindRoom")
			.get(uri2 + "/findroom")
			.headers(headers_1)
			.resources(http("BookableRoom")
			.get("/api/room/all/bookable")
			.headers(headers_2)))
		.pause(1)
		.exec(http("RoomById")
			.get("/api/room/772")
			.headers(headers_2))
		.pause(1)
		.exec(http("ReserveResource")
			.get(uri2 + "/reserveresource")
			.headers(headers_1)
			.resources(http("AllResources")
			.get("/api/resource/getAllResource")
			.headers(headers_2)))
		.pause(1)
		.exec(http("ResourceById")
			.get("/api/resource/getResourceById/969")
			.headers(headers_2))
		.pause(1)

	val scn2 = scenario("scn2")
		.exec(http("SignIn")
			.post("/api/auth/signin")
			.headers(headers_0)
			.body(RawFileBody("gatling/sample/user2/0000_request.json"))
			.resources(http("Profile")
				.get(uri2 + "/profile")
				.headers(headers_1)))
		.pause(5)
		.exec(http("MyAllotment")
			.get("/api/allotment/getMyAllotment/6")
			.headers(headers_2)
			.resources(http("MyReservations")
				.get("/api/reservation/getMyReservation/6")
				.headers(headers_2)))
		.pause(4)
		.exec(http("FindRoom")
			.get(uri2 + "/findroom")
			.headers(headers_1)
			.resources(http("BookableRoom")
				.get("/api/room/all/bookable")
				.headers(headers_2)))
		.pause(1)
		.exec(http("RoomById")
			.get("/api/room/772")
			.headers(headers_2))
		.pause(1)
		.exec(http("ReserveResource")
			.get(uri2 + "/reserveresource")
			.headers(headers_1)
			.resources(http("AllResources")
				.get("/api/resource/getAllResource")
				.headers(headers_2)))
		.pause(1)
		.exec(http("ResourceById")
			.get("/api/resource/getResourceById/969")
			.headers(headers_2))
		.pause(1)

	setUp(scn1.inject(rampUsersPerSec(1).to(100).during(30).randomized)

	).protocols(httpProtocol)
}