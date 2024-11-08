package softwares.inventarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softwares.inventarios.entities.entities;
import softwares.inventarios.repository.ProductRepository;

@Service
public class ProductService implements Id_ProductoServicio{


    @Autowired
    private ProductRepository productoRepositorio;



    @Override
    public List<entities> listarProductos() {
        this.productoRepositorio.findAll();
        return this.productoRepositorio.findAll();
        
    }


    @Override
    public entities buscarProductoPorId(Integer Id_Producto) {
        entities producto = this.productoRepositorio.findById(Id_Producto).orElse(null);
        return producto;
    }

    @Override
    public void eliminarProducto(Integer Id_Producto) {
        this.productoRepositorio.deleteById(Id_Producto);
    }

    @Override
    public entities guardarProductos(entities entities) {
        return this.productoRepositorio.save(entities);
        
    }

    

}
