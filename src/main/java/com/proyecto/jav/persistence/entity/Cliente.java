package com.proyecto.jav.persistence.entity;

import javax.persistence.*;
import java.util.List;

//Se debe poner que es una entidad para que se identifique que es una tabla
@Entity
//Ponemos el nombre de la tabla (el nombre exacto que en la base de datos )
@Table(name = "clientes")
public class Cliente {

    //Se pone el primary key
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Integer celular;
    private String direccion;

    //El column se pone cuando llamamos la variable en java distinta que la variable en la base de datos, en el
    //apartado de column se pone como realmente en el nombre de la variable
    @Column(name = "correo_electronico")
    private String correoElectronico;

    //Se hace la relacion con la variable cliente
    @OneToMany(mappedBy = "cliente")
    private List <Compra> compras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
