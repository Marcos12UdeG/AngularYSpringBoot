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
import java.util.ArrayList;
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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> SearchById(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();
        try{
            Optional<Category> categoryDAOById= categoryDAO.findById(id);
            if(categoryDAOById.isPresent())
            {
                list.add(categoryDAOById.get());
                response.getCategoryResponse().setCategoryList(list);
                response.setMetadata("Respuesta OK","00","Categoria encontrada");
            }else {
                response.setMetadata("Respuesta no ok","-1","Categoria no encontrada");
                return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e)
        {
            response.setMetadata("Respuesta no ok","-1","Error al consultar por ID");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.OK);
    }

    @Override

    public ResponseEntity<CategoryResponseRest> Agregar(Category category) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try{
            Category categorysaved = categoryDAO.save(category);
            if(categorysaved != null)
            {
                list.add(categorysaved);
                response.getCategoryResponse().setCategoryList(list);

            }else {
                response.setMetadata("Respuesta no ok","-1","categoria no guardada");
                return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e)
        {
            response.setMetadata("Respuesta mala","-1","Error al agregar la categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseRest> Eliminar(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        Category category = new Category();
        List<Category> list = new ArrayList<>();
        try{
            if(category.getId() == id)
            {

                categoryDAO.deleteById(id);
                response.setMetadata("Respuesta okei","1","Elemento eliminado");


            }
        }catch(Exception e)
        {
            response.setMetadata("Respuesta mala","-1","Error al agregar la categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response,HttpStatus.OK);
    }


}
