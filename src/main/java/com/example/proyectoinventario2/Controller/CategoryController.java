package com.example.proyectoinventario2.Controller;

import com.example.proyectoinventario2.model.Category;
import com.example.proyectoinventario2.response.CategoryResponseRest;
import com.example.proyectoinventario2.services.CategoryServices;
import com.example.proyectoinventario2.services.CategoryServicesIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServicesIMPL;

    @GetMapping("/categories")
    private ResponseEntity<CategoryResponseRest> GetAllCategories()
    {
        ResponseEntity<CategoryResponseRest> response = categoryServicesIMPL.Search();
        return response;

    }

    @GetMapping("/categories/{id}")
    private  ResponseEntity<CategoryResponseRest> searchbyId(@PathVariable Long id)
    {
        ResponseEntity<CategoryResponseRest> response = categoryServicesIMPL.SearchById(id);
                return response;
    }

    @PostMapping("/guardar")
    private ResponseEntity<CategoryResponseRest> Agregar(@RequestBody Category category)
    {
        ResponseEntity<CategoryResponseRest> response = categoryServicesIMPL.Agregar(category);
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<CategoryResponseRest> Eliminar(@PathVariable Long id)
    {
        ResponseEntity<CategoryResponseRest> response = categoryServicesIMPL.Eliminar(id);
        return response;
    }

}
