package com.pl.github

import com.pl.github.client.GithubClient
import com.pl.github.infrastructure.FeignClientException
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class GithubRestControllerTest extends IntegrationControllerSpec implements TestUserSamples, ResultSample, OperatingOnMyApiEndpoints{

    @Autowired
    private GithubClient githubClient

    def setup() {
        githubClient.getUser("Kameleonidas") >> sampleUser()
        githubClient.getUser("dasd") >> {responseNotFound()}
    }

    def "should get user with specify login = Kameleonidas"() {
        given:
        def login = "Kameleonidas"

        when:
        def response = getUser(login)

        then:
        response.andExpect(status().isOk())

        and:
        def expectedCharacterJson = asJsonString(resultUser())
        def jsonResponse = extractResponseAsString(response)
        assert jsonResponse == expectedCharacterJson
    }

    def "should not get user with specify login = dasd and throw feign exception"() throws FeignClientException {
        given:
        def login = "dasd"

        when:
        def response = getUser(login)

        then:
        response.andExpect(status().isNotFound())

        and:
        def jsonResponse = extractResponseAsString(response)
        def apiErrorResponse = asJsonString(apiErrorResponsePage())
        assert jsonResponse == apiErrorResponse
    }
}
