package com.k_int.cultureGrid.Pages.Depositor

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class DepositorHome extends Page {
	static url = "provider/home"
	static at = {title.endsWith("Depositor Home")};
	
	static content = {
		menu {module MenuOptions}
	}
}
