package com.example.proyectoinventario2.Controller;



import com.example.proyectoinventario2.model.Product;
import com.example.proyectoinventario2.response.ProductResponseRest;
import com.example.proyectoinventario2.services.ProductServicesIMPL;
import com.example.proyectoinventario2.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v2")
public class ProductRestController {

    @Autowired
    private ProductServicesIMPL productServicesIMPL;

    @GetMapping("/Obtener")
    public ResponseEntity<ProductResponseRest> AllCategories() {
        ResponseEntity<ProductResponseRest> response = productServicesIMPL.AllProducts();
        return response;
    }

    @PostMapping("/Agregar")
    public ResponseEntity<ProductResponseRest> SaveCategories(@RequestParam("picture") MultipartFile picture,
                                                              @RequestParam("name") String name, @RequestParam("price") int price,
                                                              @RequestParam("account") int account, @RequestParam("categoryId") long id)
            throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setAccount(account);
        product.setPicture(util.compressZLib(picture.getBytes()));

        ResponseEntity<ProductResponseRest> response = productServicesIMPL.SaveProduct(product, id);

        return response;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductResponseRest> GetById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productServicesIMPL.GetById(id);
        return response;
    }

    @GetMapping("/nombre/filter/{name}")
    public ResponseEntity<ProductResponseRest> GetByName(@PathVariable String name){
        ResponseEntity<ProductResponseRest> response = productServicesIMPL.GetByName(name);
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProductResponseRest> Delete(@PathVariable Long id){
        ResponseEntity<ProductResponseRest> response = productServicesIMPL.DeleteById(id);
        return response;
    }
}

