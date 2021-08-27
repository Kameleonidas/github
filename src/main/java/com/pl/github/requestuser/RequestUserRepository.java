package com.pl.github.requestuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RequestUserRepository extends JpaRepository<RequestUser,Long> {

        RequestUser findByLogin(String login);
}
