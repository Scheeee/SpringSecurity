package com.uniamerica.AtividadeSpringSecurity.Service;

import com.uniamerica.AtividadeSpringSecurity.DTO.UserDTO;
import com.uniamerica.AtividadeSpringSecurity.Entity.UserEntity;
import com.uniamerica.AtividadeSpringSecurity.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var userEntity = userRepository.findByUsername(username);
            System.out.println(userEntity.getUsername());
            return (UserDetails) userEntity;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não localizado");
        }
    }
}

