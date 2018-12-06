package com.fangfangxu.repository.u;

import com.fangfangxu.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
