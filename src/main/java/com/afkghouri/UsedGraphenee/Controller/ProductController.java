package com.afkghouri.UsedGraphenee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afkghouri.UsedGraphenee.Model.ProductModel;
import com.afkghouri.UsedGraphenee.Repository.ProductRepository;

@Component
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    
    public void save(ProductModel productModel){
    	System.out.println("save() call:");
    	productRepository.save(productModel);
    }
    public void delete(ProductModel productModel){
    	System.out.println("deleteById() call:");
    	productRepository.delete(productModel);
    }
    public List<ProductModel> findAll(){
    	System.out.println("findAll() call: "); 
    	return productRepository.findAll();
    	 
    }
    
    
    
}
