package com.example.proyectoinventario2.services;

import com.example.proyectoinventario2.model.Category;
import com.example.proyectoinventario2.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface CategoryServices {

    public ResponseEntity<CategoryResponseRest> Search();

}
