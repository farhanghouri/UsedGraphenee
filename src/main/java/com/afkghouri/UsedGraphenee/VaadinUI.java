package com.afkghouri.UsedGraphenee;

import org.springframework.beans.factory.annotation.Autowired;

import com.afkghouri.UsedGraphenee.Vaadin.WorkshopDashboardSetup;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport; 
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider; 

import io.graphenee.vaadin.AbstractDashboardSetup;
import io.graphenee.vaadin.AbstractDashboardUI; 

@SpringUI
@Theme("graphenee")
@Push(transport = Transport.WEBSOCKET, value = PushMode.MANUAL)
@Viewport(value = "width=device-width")
public class VaadinUI extends AbstractDashboardUI {

	@Autowired
	SpringViewProvider viewProvider;

	@Autowired
	WorkshopDashboardSetup dashboardSetup;

	@Override
	protected AbstractDashboardSetup dashboardSetup() {
		return dashboardSetup;
	}

}
