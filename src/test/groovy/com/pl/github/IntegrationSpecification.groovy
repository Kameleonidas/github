package com.pl.github

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [GithubApplication, TestsConfig], webEnvironment = SpringBootTest.WebEnvironment.MOCK)
abstract class IntegrationSpecification extends Specification {

}
