package com.uniamerica.AtividadeSpringSecurity.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TESTE {


    @GetMapping("/teste")
    public String teste(){
        return "<h1>TESTE</h1>";
    }


    @GetMapping("/livre")
    public String livre(){
        return "<h2> tá livre </h2>";
    }
}