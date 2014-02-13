package com.k_int.cultureGrid.Depositor.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class DepositorHome extends Page {
	static url = "provider/home"
	static at = {title.endsWith("Depositor Home")};
	
	static content = {
		menu {module MenuOptions}
	}
}
