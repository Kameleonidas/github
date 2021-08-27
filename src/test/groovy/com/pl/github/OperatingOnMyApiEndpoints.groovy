package com.pl.github

import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

trait OperatingOnMyApiEndpoints implements EndpointActions {

    ResultActions getUser(String login) {
        perform(MockMvcRequestBuilders.get("/api/users/${login}"))
    }

}
