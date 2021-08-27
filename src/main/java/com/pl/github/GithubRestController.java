package com.pl.github;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
class GithubRestController {

    private final GithubService githubService;

    @GetMapping("/{login}")
    public User getUser(@PathVariable final String login) {
        return githubService.getUser(login);
    }
}
