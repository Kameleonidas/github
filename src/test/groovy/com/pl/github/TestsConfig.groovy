package com.pl.github

import com.pl.github.client.GithubClient
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import spock.mock.DetachedMockFactory

@TestConfiguration
class TestsConfig {

    private DetachedMockFactory mockFactory = new DetachedMockFactory()

    @Bean
    @Primary
    GithubClient githubClient() {
        return mockFactory.Mock(GithubClient)
    }

}
