package com.pl.github

import com.pl.github.infrastructure.ApiErrorResponse

trait ResultSample {

    def resultUser() {
        new User(
                id: 36129650,
                login: "Kameleonidas",
                name: "Kamil \\\"Kameleonidas\\\" Kiepura",
                type: "User",
                avatarUrl: "https://avatars.githubusercontent.com/u/36129650?v=4",
                createdAt: "2018-02-04T12:44:42Z",
                calculations: 0
        )
    }

    def apiErrorResponsePage(){
        new ApiErrorResponse(
            status: 404,
            message: "User with login = dasd not found"
        )
    }
}