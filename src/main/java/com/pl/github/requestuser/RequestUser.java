package com.pl.github.requestuser;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private Long requestCount;

    public RequestUserDto toDto(){
        return RequestUserDto.builder()
                .id(id)
                .login(login)
                .requestCount(requestCount)
                .build();
    }
}
