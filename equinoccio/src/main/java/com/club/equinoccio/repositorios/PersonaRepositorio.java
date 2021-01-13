
package com.club.equinoccio.repositorios;

import com.club.equinoccio.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Persona
**/

@Repository
public interface PersonaRepositorio extends JpaRepository <Persona , String> {
      
}
