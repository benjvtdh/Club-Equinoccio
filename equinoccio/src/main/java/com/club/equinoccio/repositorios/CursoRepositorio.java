
package com.club.equinoccio.repositorios;

import com.club.equinoccio.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepositorio extends JpaRepository<Curso, String> {
   
}
