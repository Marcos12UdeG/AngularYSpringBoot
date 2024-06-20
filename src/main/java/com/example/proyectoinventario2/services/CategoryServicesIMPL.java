package com.example.proyectoinventario2.services;


import com.example.proyectoinventario2.DAO.CategoryDAO;
import com.example.proyectoinventario2.model.Category;
import com.example.proyectoinventario2.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServicesIMPL implements CategoryServices{

    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> Search() {
        CategoryResponseRest response = new CategoryResponseRest();
        try{
            List<Category> categoryList = (List<Category>) categoryDAO.findAll();
            response.getCategoryResponse().setCategoryList(categoryList);
            response.setMetadata("Respuesta ok","00","Respuesta exitosa");
        }catch(Exception e)
        {
            response.setMetadata("Respuesta no ok","-1","Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);

    }


}
