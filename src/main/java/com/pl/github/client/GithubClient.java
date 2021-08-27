package com.pl.github.client;

import com.pl.github.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value = "swapiclient", url = "https://api.github.com/users/", configuration = ClientConfig.class, primary = false)
public interface GithubClient {

    @GetMapping(value = "{login}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    UserDto getUser (@PathVariable("login") String login);

}
