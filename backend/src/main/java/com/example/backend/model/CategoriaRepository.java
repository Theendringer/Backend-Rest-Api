package com.example.backend.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
essa classe usa o mecanismo de ferramentas do Spring para
prover uma forma fácil de interagir com dados da nossa aplicação  


a anotação Repository insere uma classe anônima gerenciada pela aplicação que traz métodos para inserir, excluir etc entidades
do tipo Tarefa
 
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
