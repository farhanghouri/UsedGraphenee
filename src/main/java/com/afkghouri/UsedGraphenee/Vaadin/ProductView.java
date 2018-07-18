package com.afkghouri.UsedGraphenee.Vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

import io.graphenee.core.vaadin.GxNamespaceListPanel;
import io.graphenee.core.vaadin.GxResourceListPanel;
import io.graphenee.core.vaadin.SystemView;
import io.graphenee.vaadin.AbstractDashboardPanel;
import io.graphenee.vaadin.TRView;

@SpringView(name = ProductView.VIEW_NAME)
@Scope("prototype")
public class ProductView extends AbstractDashboardPanel implements TRView {

	public static final String VIEW_NAME = "product";

	@Autowired
	ProductListPanel productListPanel;

	@Autowired
	GxResourceListPanel resourceListPanel;

	@Override
	protected String panelTitle() {
		return "Category";
	}

	@Override
	protected void postInitialize() {
		MenuBar menuBar = new MenuBar();
		MenuItem manageMenu = menuBar.addItem("Manage", null);
		manageMenu.addItem("Product", event -> {
			resourceListPanel.setVisible(false);
			productListPanel.setVisible(true);
			productListPanel.refresh();
		});
		manageMenu.addItem("Resources", event -> {
			productListPanel.setVisible(false);
			resourceListPanel.setVisible(true);
			resourceListPanel.refresh();
		});
		addComponentsToToolbar(menuBar);
		addComponent(productListPanel.build().withVisible(true));
		addComponent(resourceListPanel.build().withVisible(false));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (productListPanel.isVisible()) {
			productListPanel.refresh();
		} else if (resourceListPanel.isVisible()) {
			resourceListPanel.refresh();
		}
	}

	@Override
	protected boolean shouldShowHeader() {
		return true;
	}

}
