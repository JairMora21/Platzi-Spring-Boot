package com.proyecto.jav.persistence.entity;

import javax.persistence.*;
import java.util.List;

//Se debe poner que es una entidad para que se identifique que es una tabla
@Entity
//Ponemos el nombre de la tabla (el nombre exacto que en la base de datos )
@Table(name = "categorias")

public class Categoria {


    //Se pone el primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //El column se pone cuando llamamos la variable en java distinta que la variable en la base de datos, en el
    //apartado de column se pone como realmente en el nombre de la variable
    @Column(name = "id_categoria" )
    private Integer idCategoria;

    private String descripcion;
    private Boolean estado;

    //Se hace la relacion con la variable categoria
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    //se crean todos los getters and setters
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
