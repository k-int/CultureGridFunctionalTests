package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class Reports extends Page {
	static url = "reports/list"
	static at = {title.endsWith("Reports")};
	
	static content = {
		menu {module MenuOptions}
	}
}
