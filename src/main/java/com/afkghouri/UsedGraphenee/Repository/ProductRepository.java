package com.afkghouri.UsedGraphenee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afkghouri.UsedGraphenee.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
