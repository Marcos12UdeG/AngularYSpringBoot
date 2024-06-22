package com.example.proyectoinventario2.Controller;

import com.example.proyectoinventario2.model.Category;
import com.example.proyectoinventario2.response.CategoryResponseRest;
import com.example.proyectoinventario2.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
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

    @PutMapping("/actualizar/{id}")
    private ResponseEntity<CategoryResponseRest> Update(@RequestBody Category category,@PathVariable Long id)
    {
        ResponseEntity<CategoryResponseRest> response = categoryServicesIMPL.Update(category,id);
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<CategoryResponseRest> Eliminar(@PathVariable Long id)
    {
        ResponseEntity<CategoryResponseRest> response = categoryServicesIMPL.Delete(id);
        return response;
    }

}
