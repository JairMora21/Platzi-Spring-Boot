package com.proyecto.jav.persistence.crud;

import com.proyecto.jav.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Se crea para hacer un repositorio
public interface ProductoCrudRepository  extends CrudRepository <Producto,Integer> {

   //Asi se llama un metodo de manera nativa, es exactamente el mismo codigo que esta abajo
   // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?",nativeQuery = true)

    //Queremos recuparar toda la lista de productos de una categoria en especifico
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Busca los articulos que tengan menos stock y esten disponibles
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);

}
