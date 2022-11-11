package com.proyecto.jav.persistence;

import com.proyecto.jav.domain.Product;
import com.proyecto.jav.domain.repository.ProductRepository;
import com.proyecto.jav.persistence.crud.ProductoCrudRepository;
import com.proyecto.jav.persistence.entity.Producto;
import com.proyecto.jav.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    //Los objetos que reciban esta anotacion  le cederan el control a spring para que ceda estas instancias
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    //nos devuelve datos importantes de la base  de datos, en este caso toda la lista de producto de Productos
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    //Regresan la lista de productos que pertenecen a una categoria ordenados en orden alfabetico
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    //Busca los articulos que tengan menos stock y esten disponibles
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }
    //Devuelve el producto
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    //Guarda el producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);

        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //Borra el producto
    @Override
    public void delete(int productoId){
        productoCrudRepository.deleteById(productoId);
    }

}
