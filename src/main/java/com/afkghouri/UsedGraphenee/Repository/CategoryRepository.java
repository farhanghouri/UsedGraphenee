package com.afkghouri.UsedGraphenee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afkghouri.UsedGraphenee.Model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
	public CategoryModel findByName(String name);
}
