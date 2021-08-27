package com.pl.github.requestuser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/requestUser")
@RequiredArgsConstructor
public class RequestUserController {

    private final RequestUserService requestUserService;

    @GetMapping
    public List<RequestUserDto> getRequestUserList() {
        return requestUserService.getRequestList();
    }

}
