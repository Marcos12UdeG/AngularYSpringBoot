package com.example.proyectoinventario2.Controller;

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

    @PostMapping()
}
