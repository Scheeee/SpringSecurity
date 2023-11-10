package com.uniamerica.AtividadeSpringSecurity.Repository;

import com.uniamerica.AtividadeSpringSecurity.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Long> {


    UserEntity findByUsername(String username);
}
