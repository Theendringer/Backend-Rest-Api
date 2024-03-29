package com.example.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
cria a classe de entidade que é uma tabela no banco de dados
tem dois campos:
id = chave primária
descricao = coluna do tipo varchar
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Long numero;
}
