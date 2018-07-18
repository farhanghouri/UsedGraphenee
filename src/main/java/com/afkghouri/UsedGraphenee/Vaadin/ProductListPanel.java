package com.afkghouri.UsedGraphenee.Vaadin;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.afkghouri.UsedGraphenee.Controller.CategoryController;
import com.afkghouri.UsedGraphenee.Controller.ProductController;
import com.afkghouri.UsedGraphenee.Model.CategoryModel;
import com.afkghouri.UsedGraphenee.Model.ProductModel;
import com.afkghouri.UsedGraphenee.Repository.CategoryRepository;
import com.vaadin.spring.annotation.SpringComponent;

import io.graphenee.core.model.api.GxDataService;
import io.graphenee.core.model.bean.GxNamespaceBean;
import io.graphenee.core.vaadin.GxNamespaceForm;
import io.graphenee.vaadin.AbstractEntityListPanel;
import io.graphenee.vaadin.TRAbstractForm;

@SpringComponent
@Scope("prototype")
public class ProductListPanel extends AbstractEntityListPanel<ProductModel> {

	@Autowired
	GxDataService dataService;

	@Autowired
	ProductForm editorForm;
	
	@Autowired
	ProductController productController;

	@PostConstruct
	public void init(){  
	}
	public ProductListPanel() {
		super(ProductModel.class);
	}

	@Override
	protected boolean onSaveEntity(ProductModel entity) {
		productController.save(entity);
		return true;
	}

	@Override
	protected boolean onDeleteEntity(ProductModel entity) {
		productController.delete(entity); 
		return true;
	}

	@Override
	protected String panelCaption() {
		return "Categories";
	}

	@Override
	protected List<ProductModel> fetchEntities() {
		return productController.findAll();
	}

	@Override
	protected String[] visibleProperties() {
		return new String[] { "name","price","quantity" };
	}

	@Override
	protected TRAbstractForm<ProductModel> editorForm() {
		return editorForm;
	}

}
