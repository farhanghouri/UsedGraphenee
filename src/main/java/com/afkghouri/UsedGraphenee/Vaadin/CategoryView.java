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

@SpringView(name = CategoryView.VIEW_NAME)
@Scope("prototype")
public class CategoryView extends AbstractDashboardPanel implements TRView {

	public static final String VIEW_NAME = "category";

	@Autowired
	CategoryListPanel categoryListPanel;

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
		manageMenu.addItem("Category", event -> {
			resourceListPanel.setVisible(false);
			categoryListPanel.setVisible(true);
			categoryListPanel.refresh();
		});
		manageMenu.addItem("Resources", event -> {
			categoryListPanel.setVisible(false);
			resourceListPanel.setVisible(true);
			resourceListPanel.refresh();
		});
		addComponentsToToolbar(menuBar);
		addComponent(categoryListPanel.build().withVisible(true));
		addComponent(resourceListPanel.build().withVisible(false));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (categoryListPanel.isVisible()) {
			categoryListPanel.refresh();
		} else if (resourceListPanel.isVisible()) {
			resourceListPanel.refresh();
		}
	}

	@Override
	protected boolean shouldShowHeader() {
		return true;
	}

}
