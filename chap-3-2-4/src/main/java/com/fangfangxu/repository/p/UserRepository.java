package com.fangfangxu.repository.p;

import com.fangfangxu.entity.UserACCC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserACCC, Long> {
}
