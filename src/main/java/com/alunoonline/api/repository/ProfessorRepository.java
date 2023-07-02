package com.alunoonline.api.repository;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository  extends JpaRepository<Professor, Long> {

    public List<Professor>findProfessorByNome(String nome);

    public List<Professor>
    findProfessorByNomeAndEmail(String nome, String email);

    public List<Professor> findProfessorByNomeOrderByNomeAsc(String nome);

    List<Professor>findByNomeContainingIgnoreCase(String nome);

    @Query("select u from Professor u where u.nome=:nome")
    public List<Professor> buscarPorNome(@Param("nome") String nome);

}
