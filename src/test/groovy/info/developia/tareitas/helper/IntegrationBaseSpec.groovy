package info.developia.tareitas.helper

import info.developia.tareitas.App
import io.restassured.RestAssured
import spark.Spark

interface IntegrationBaseSpec {

    default def setupSpec() {
        App.main()
        RestAssured.baseURI = 'http://localhost:4567'
    }

    default def cleanupSpec() {
        Spark.stop()
    }
}