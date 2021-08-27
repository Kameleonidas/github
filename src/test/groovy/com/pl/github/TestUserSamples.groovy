package com.pl.github

import com.pl.github.infrastructure.FeignClientException

trait TestUserSamples {

    def sampleUser() {
        new UserDto(
                id: 36129650,
                login: "Kameleonidas",
                name: "Kamil \\\"Kameleonidas\\\" Kiepura",
                type: "User",
                avatarUrl: "https://avatars.githubusercontent.com/u/36129650?v=4",
                createdAt: "2018-02-04T12:44:42Z",
                followers: 0,
                publicRepository: 1
        )
    }

    def responseNotFound() {
        throw new FeignClientException(404, "")
    }

}
