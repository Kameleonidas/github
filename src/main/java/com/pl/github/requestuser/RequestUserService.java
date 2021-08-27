package com.pl.github.requestuser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestUserService {

    private final RequestUserRepository requestUserRepository;

    public List<RequestUserDto> getRequestList(){
        return requestUserRepository.findAll().stream()
                .map(RequestUser::toDto)
                .collect(Collectors.toList());
    }

    public void addRequest(String login){
        RequestUser requestUser = requestUserRepository.findByLogin(login);
        if(requestUser == null){
            RequestUser newRequestUser = new RequestUser();
            newRequestUser.setLogin(login);
            newRequestUser.setRequestCount(1L);
            requestUserRepository.save(newRequestUser);
        } else {
            requestUser.setRequestCount(requestUser.getRequestCount() + 1);
            requestUserRepository.save(requestUser);
        }
    }

}
