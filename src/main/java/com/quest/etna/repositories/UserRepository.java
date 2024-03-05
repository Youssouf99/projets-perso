package com.quest.etna.repositories;

import com.quest.etna.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
        boolean existsUserByUsername(String username);

}
