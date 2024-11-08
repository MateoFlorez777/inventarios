package softwares.inventarios.service;

import java.util.List;

import softwares.inventarios.entities.entities;
public interface Id_ProductoServicio {

    public List<entities> listarProductos();

    public entities buscarProductoPorId(Integer Id_Producto);

    public entities guardarProductos(entities entities);

    public void eliminarProducto(Integer Id_Producto);

}
