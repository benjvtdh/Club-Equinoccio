
package com.club.equinoccio.entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;



@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true)
    private String id;
    private String username;
    private String password;
    private Integer estado;
    private String nombres;
    private String apellidos;
    private String correo;
    
    // Relación de muchos a muchos entre usuarios y roles
    // - FetchTyoe.EAGER --> Carga todos los perfiles de un usuario 
    @ManyToMany(fetch=FetchType.EAGER)
    // Crear tabla usuario_rol, con las columnas usuario_id y rol_id
    @JoinTable(name="usuario_rol", 
            joinColumns = @JoinColumn(name = "usuario_id" ),
            inverseJoinColumns = @JoinColumn(name="rol_id"))
    private List<Rol> roles;    
    public Usuario() {
    }

    public Usuario(String id, String username, String password, Integer estado, String nombres, String apellidos, String correo, List<Rol> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.roles = roles;
    }
    
    public void agregar(Rol rol){
        if(roles==null){
            roles = new LinkedList<Rol>();
        }
        roles.add(rol);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

   
    
}
