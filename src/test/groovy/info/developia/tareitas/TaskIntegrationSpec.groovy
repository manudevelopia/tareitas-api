package info.developia.tareitas

import info.developia.tareitas.helper.IntegrationBaseSpec
import io.restassured.RestAssured
import io.restassured.response.Response
import spock.lang.Specification

import static org.hamcrest.core.IsEqual.equalTo

class TaskIntegrationSpec extends Specification implements IntegrationBaseSpec {

    def "Get all tasks should return a list of tasks"() {
        when:
        Response response = RestAssured.given().get("/tasks")
        then:
        response.then().
                assertThat().
                statusCode(200).
                body(equalTo('[{"title":"task1"},{"title":"task2"},{"title":"task3"}]'))
    }

    def "Create a new task should return created task"() {
        given:
        String body = '{\"title\":\"new task\"}'
        when:
        Response response = RestAssured.given().body(body).post("/tasks")
        then:
        response.then().
                assertThat().
                statusCode(201).
                body(equalTo(body))
    }
}
