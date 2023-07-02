package com.alunoonline.api.repository;

import com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long> {

    public List<Aluno>findAlunoByNome(String nome);

    public List<Aluno>
    findAlunoByNomeAndEmail(String nome, String email);

    public List<Aluno> findAlunoByNomeOrderByNomeAsc(String nome);

    List<Aluno>findByNomeContainingIgnoreCase(String nome);


    @Query("select u from Aluno u where u.nome=:nome")
    public List<Aluno> buscarPorNome(@Param("nome") String nome);

    @Query("select u from Aluno u where u.email=:email")
    public List<Aluno> buscarPorEmail(@Param("email") String email);

    public Aluno findUsarioByEmail(String email);

}
