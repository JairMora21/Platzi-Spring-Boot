package com.proyecto.jav.domain.repository;

import com.proyecto.jav.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //con esto ya definimos la reglas que tendra nuestro dominio al momento que cualquier repositorioquiera
    //utilizar o quiera acceder a productos dentro de la base de datos
    //Esto ayuda a no acomplarnos a una base de datos especifica
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);

}
