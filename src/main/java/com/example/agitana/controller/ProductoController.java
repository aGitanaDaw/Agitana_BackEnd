package com.example.agitana.controller;

import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.models.Producto;
import com.example.agitana.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = "/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    //furula
    @GetMapping(value = "/listar")
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }
    //furula
    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Integer id) {
        ProductoDTO productoDTO = productoService.listarProductoPorId(id);

        if (productoDTO != null) {
            return ResponseEntity.ok(productoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/crear")
    public ProductoDTO createProducto(@RequestBody ProductoDTO dto){
        return productoService.createProducto(dto);
    }

    @PutMapping(value = "/modificar")
    public Producto modificarProducto(@RequestBody ProductoDTO productoDTO){
        return productoService.modificarProducto(productoDTO);
    }

    //furula
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarProductoPorId(@PathVariable Integer id) {
        String resultado = productoService.eliminarProducto(id);

        if ("Datos eliminados correctamente".equals(resultado)) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
    }
}
