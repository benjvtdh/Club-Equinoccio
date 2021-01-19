
package com.club.equinoccio.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
    Entidad rol, que delimita las funciones de un usuario
 */

@Entity
public class Rol implements Serializable {
    @Id
    private Integer perfilId;
    private String cargo;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Rol(Integer perfilId, String cargo, List<Usuario> usuarios) {
        this.perfilId = perfilId;
        this.cargo = cargo;
        this.usuarios = usuarios;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
