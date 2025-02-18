package softwares.inventarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import softwares.inventarios.entities.entities;
import softwares.inventarios.exception.RecursoNoEncontradoExeption;
import softwares.inventarios.service.ProductService;



@RestController
//http://localhost:8081/productos/
@RequestMapping("/productos")
@CrossOrigin(value = "http://localhost:3000")

public class ProductController {

    private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productoservicio;

    @GetMapping("/productos")
    public List<entities> obtenerProductos() {
        List<entities> productos = this.productoservicio.listarProductos();
        logger.info("Listando todos los productos");
        productos.forEach((entities -> logger.info(entities.toString())));
        return productos;
    }

    @GetMapping("/productos/{id_Producto}")
    public ResponseEntity<entities> obtenerProductoPorId(
        @PathVariable Integer id_Producto){
            entities producto = 
                this.productoservicio.buscarProductoPorId(id_Producto);
            if(producto != null){
                return ResponseEntity.ok(producto);
                
                
            }else {
                throw new RecursoNoEncontradoExeption("No se encontró el producto con id" + id_Producto);
            }
            
    }

    
    @PostMapping("/productos")
    public entities agregarProducto(@RequestBody entities producto) {
        logger.info("Producto a agregar: " + producto);
        return this.productoservicio.guardarProductos(producto);
    }

    @PutMapping("/productos/{id_Producto}")
    public ResponseEntity<entities> actualizarProductoPorId(
            @PathVariable Integer id_Producto,
            @RequestBody entities productoRecibido) {

        entities producto = this.productoservicio.buscarProductoPorId(id_Producto);
        producto.setNombre_Producto(productoRecibido.getNombre_Producto());
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setCantidad_Unidad(productoRecibido.getCantidad_Unidad());
        producto.setPrecio_Unidad(productoRecibido.getPrecio_Unidad());
        producto.setStock(productoRecibido.getStock());
        producto.setEstado_Producto(productoRecibido.getEstado_Producto());
        this.productoservicio.guardarProductos(producto);
        return ResponseEntity.ok(producto);

    }
    
    
    @DeleteMapping("/productos/{id_Producto}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(
    @PathVariable Integer id_Producto) {
        entities producto = productoservicio.buscarProductoPorId(id_Producto);
        if(producto == null)
            throw new RecursoNoEncontradoExeption("No se encontró el producto con id" + id_Producto);
        this.productoservicio.eliminarProducto(producto.getId_Producto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
    
        return ResponseEntity.ok(respuesta);
    }

}   

