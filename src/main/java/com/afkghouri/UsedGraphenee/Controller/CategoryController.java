package com.afkghouri.UsedGraphenee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afkghouri.UsedGraphenee.Model.CategoryModel;
import com.afkghouri.UsedGraphenee.Repository.CategoryRepository;

@Component
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryModel findByName(String name){ 
		return categoryRepository.findByName(name);
	}
	
	public void save(CategoryModel categoryModel){
		System.out.println("Category saveCall():");
		categoryRepository.save(categoryModel);
	}
	
	public List<CategoryModel> findAll(){
		System.out.println("Category findAll():");  
		return categoryRepository.findAll();
		
	}

	public void delete(CategoryModel categoryModel) {
		System.out.println("Category delete():");
		categoryRepository.delete(categoryModel);
	}
}
