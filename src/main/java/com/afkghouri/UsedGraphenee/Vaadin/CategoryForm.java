package com.afkghouri.UsedGraphenee.Vaadin;

import org.springframework.context.annotation.Scope;
import org.vaadin.viritin.fields.MCheckBox;
import org.vaadin.viritin.fields.MTextArea;
import org.vaadin.viritin.fields.MTextField;

import com.afkghouri.UsedGraphenee.Model.CategoryModel;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.FormLayout;

import io.graphenee.core.model.bean.GxNamespaceBean;
import io.graphenee.vaadin.TRAbstractForm;
@SpringComponent
@Scope("prototype")
public class CategoryForm extends TRAbstractForm<CategoryModel> {

	MTextField name; 

	@Override
	protected void addFieldsToForm(FormLayout form) {
		name = new MTextField("Name").withRequired(true); 
		form.addComponents(name);
	}

	@Override
	protected boolean eagerValidationEnabled() {
		return true;
	}

	@Override
	protected String formTitle() {
		return "Category";
	}

}
