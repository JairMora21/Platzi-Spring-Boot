package com.proyecto.jav.persistence;

import com.proyecto.jav.persistence.crud.ProductoCrudRepository;
import com.proyecto.jav.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //nos devuelve datos importantes de la base  de datos, en este caso toda la lista de producto de Productos
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //Regresan la lista de productos que pertenecen a una categoria ordenados en orden alfabetico
    public  List<Producto> getByCategoria(int idCategoria){
        return  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);    }

    //Busca los articulos que tengan menos stock y esten disponibles
    public Optional <List<Producto>> getEscasos(int cantidad){
        return  productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }
}
