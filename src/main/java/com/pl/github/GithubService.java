package com.pl.github;

import com.pl.github.client.GithubClient;
import com.pl.github.infrastructure.FeignClientException;
import com.pl.github.requestuser.RequestUserService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.String.format;

@Slf4j
@Component
@RequiredArgsConstructor
public class GithubService {

    private final GithubClient githubClient;
    private final RequestUserService requestUserService;

    public User getUser(String login) {
        return buildCharacter(getCharacterDto(login));
    }

    private User buildCharacter(UserDto userDto) {

        return User.builder()
            .id(userDto.getId())
            .login(userDto.getLogin())
            .name(userDto.getName())
            .type(userDto.getType())
            .avatarUrl(userDto.getAvatarUrl())
            .createdAt(userDto.getCreatedAt())
            .calculations(calculationsResult(userDto))
            .build();
    }

    private UserDto getCharacterDto(String login) {
        UserDto characterDto;
        try {
            characterDto = githubClient.getUser(login);
            requestUserService.addRequest(login);
        } catch (FeignException fe) {
            log.error(format("User with login = %s not found", login));
            throw new FeignClientException(fe.status(), format("User with login = %s not found", login));
        }
        return characterDto;
    }

    private BigDecimal calculationsResult(UserDto userDto){

        if (userDto.getFollowers() != 0){
            return BigDecimal.valueOf(6)
                    .divide(BigDecimal.valueOf(userDto.getFollowers()),new MathContext(5))
                    .multiply(BigDecimal.valueOf(2).add(BigDecimal.valueOf(userDto.getPublicRepository())));
        } else {
            return BigDecimal.ZERO;
        }

    }

}
