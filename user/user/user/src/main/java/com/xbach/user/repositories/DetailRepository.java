package com.xbach.user.repositories;

import com.xbach.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.xbach.user.models.Detail;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail findByUserId(Long userId);
}
