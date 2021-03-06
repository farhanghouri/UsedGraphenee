/*******************************************************************************
 * Copyright (c) 2016, 2018 Farrukh Ijaz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.afkghouri.UsedGraphenee.Vaadin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.graphenee.core.exception.AuthenticationFailedException;
import io.graphenee.core.vaadin.SystemView; 
import io.graphenee.vaadin.AbstractDashboardSetup;
import io.graphenee.vaadin.TRMenuItem;
import io.graphenee.vaadin.TRSimpleMenuItem;
import io.graphenee.vaadin.domain.DashboardUser;
import io.graphenee.vaadin.domain.MockUser;
import io.graphenee.vaadin.event.DashboardEvent.UserLoginRequestedEvent;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Image;
import io.graphenee.i18n.vaadin.LocalizationView;
import io.graphenee.security.vaadin.SecurityView;

@Service
@UIScope
public class WorkshopDashboardSetup extends AbstractDashboardSetup {

	private ViewProvider viewProvider;

	public WorkshopDashboardSetup(ViewProvider viewProvider) {
		this.viewProvider = viewProvider;
	}

	@Override
	public String applicationTitle() {
		return "Shopping Cart";
	}

	@Override
	public Image applicationLogo() {
		return null;
	}

	@Override
	protected List<TRMenuItem> menuItems() {
		List<TRMenuItem> menus = new ArrayList<>();
		menus.add(TRSimpleMenuItem.createMenuItemForView(MetroStyleDashboardView.VIEW_NAME, "Home", FontAwesome.HOME));
		TRSimpleMenuItem dmMenuItem = TRSimpleMenuItem.createMenuItem("Data Maintenance", FontAwesome.WRENCH);
		dmMenuItem.addChild(TRSimpleMenuItem.createMenuItemForView(SystemView.VIEW_NAME, "System", FontAwesome.SERVER));
		dmMenuItem.addChild(TRSimpleMenuItem.createMenuItemForView(LocalizationView.VIEW_NAME, "Localization", FontAwesome.GLOBE));
		dmMenuItem.addChild(TRSimpleMenuItem.createMenuItemForView(SecurityView.VIEW_NAME, "Security", FontAwesome.USER_SECRET));
		menus.add(dmMenuItem);
		menus.add(TRSimpleMenuItem.createMenuItemForView(CategoryView.VIEW_NAME, "Category", FontAwesome.SERVER));
		menus.add(TRSimpleMenuItem.createMenuItemForView(ProductView.VIEW_NAME, "Product", FontAwesome.SERVER));
		return menus;
	}

	@Override
	protected List<TRMenuItem> profileMenuItems() {
		return null;
	}

	@Override
	public String dashboardViewName() {
		return MetroStyleDashboardView.VIEW_NAME;
	}

	@Override
	public void registerViewProviders(Navigator navigator) {
		navigator.addProvider(viewProvider);
	}

	@Override
	public DashboardUser authenticate(UserLoginRequestedEvent event) throws AuthenticationFailedException {
		return new MockUser();
	}

}
