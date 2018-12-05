package com.fangfangxu.jpaeccess;

import com.fangfangxu.pojo.JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<JpaEntity,Long> {

    JpaEntity findByUsername(String username);

    JpaEntity findByUsernameAndAge(String username, Integer age);

    @Query("from JpaEntity u where u.username=:username")
    JpaEntity findJpaEntity(@Param("username") String username);


}
