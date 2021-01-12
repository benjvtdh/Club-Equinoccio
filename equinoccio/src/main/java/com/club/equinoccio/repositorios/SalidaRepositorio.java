/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.club.equinoccio.repositorios;

import com.club.equinoccio.entidades.Salida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

 SalidaRepositorio para importar funciones, de persistencia, actualización y eliminación de registros
 de la entidad Salida

 */

@Repository
public interface SalidaRepositorio extends JpaRepository <Salida , String > {
    
}
