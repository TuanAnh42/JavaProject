package com.xbach.user.repositories;

import com.xbach.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
    User findById(long id);
    User getUserById(Long id);
}
