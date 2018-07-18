package com.afkghouri.UsedGraphenee.Vaadin;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.afkghouri.UsedGraphenee.Controller.CategoryController;
import com.afkghouri.UsedGraphenee.Model.CategoryModel;
import com.afkghouri.UsedGraphenee.Repository.CategoryRepository;
import com.vaadin.spring.annotation.SpringComponent;

import io.graphenee.core.model.api.GxDataService;
import io.graphenee.core.model.bean.GxNamespaceBean;
import io.graphenee.core.vaadin.GxNamespaceForm;
import io.graphenee.vaadin.AbstractEntityListPanel;
import io.graphenee.vaadin.TRAbstractForm;

@SpringComponent
@Scope("prototype")
public class CategoryListPanel extends AbstractEntityListPanel<CategoryModel> {

	@Autowired
	GxDataService dataService;

	@Autowired
	CategoryForm editorForm;
	
	@Autowired
	CategoryController categoryController;

	@PostConstruct
	public void init(){  
	}
	public CategoryListPanel() {
		super(CategoryModel.class);
	}

	@Override
	protected boolean onSaveEntity(CategoryModel entity) {
		categoryController.save(entity);
		return true;
	}

	@Override
	protected boolean onDeleteEntity(CategoryModel entity) {
		categoryController.delete(entity); 
		return true;
	}

	@Override
	protected String panelCaption() {
		return "Categories";
	}

	@Override
	protected List<CategoryModel> fetchEntities() {
		return categoryController.findAll();
	}

	@Override
	protected String[] visibleProperties() {
		return new String[] { "name" };
	}

	@Override
	protected TRAbstractForm<CategoryModel> editorForm() {
		return editorForm;
	}

}
