package com.uniamerica.AtividadeSpringSecurity.Controller;

import com.uniamerica.AtividadeSpringSecurity.DTO.UserDTO;
import com.uniamerica.AtividadeSpringSecurity.Entity.UserEntity;
import com.uniamerica.AtividadeSpringSecurity.Repository.UserRepository;
import com.uniamerica.AtividadeSpringSecurity.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRep;
    @Autowired
    private UserService userDetailsService;

    private static final String ERRO = "Error: ";

    @GetMapping("/lista")
    public ResponseEntity<List<UserEntity>> findAll(){
        try {
            List<UserEntity> lista = userRep.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/teste")
    public String teste(){
        return "<h1>TESTE</h1>";
    }



    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody final UserEntity user1){
        try {
            //ModelMapper modelMapper = new ModelMapper();
           // UserEntity user1 = modelMapper.map(user, UserEntity.class);

            userRep.save(user1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(ERRO+e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserEntity(@PathVariable(value = "id")Long id, @RequestBody UserDTO user){

        UserEntity userNovo = userRep.getReferenceById(id);
        BeanUtils.copyProperties(user, userNovo, "id");
        userRep.save(userNovo);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")Long id){
        try{
            UserEntity user = userRep.getReferenceById(id);
            userRep.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(ERRO+ e.getMessage());
        }
    }


}
