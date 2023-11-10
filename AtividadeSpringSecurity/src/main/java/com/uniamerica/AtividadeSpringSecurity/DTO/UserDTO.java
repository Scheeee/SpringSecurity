package com.uniamerica.AtividadeSpringSecurity.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotBlank(message = "Campo não informado")
    @Size(max = 50, message = "A quantidade de caracteres é inválida")
    private String nome;


    @NotBlank(message = "Campo não informado")
    private String senha;

    @Size(max = 15, message = "A quantidade de caracteres é inválida")
    private String role;
}
