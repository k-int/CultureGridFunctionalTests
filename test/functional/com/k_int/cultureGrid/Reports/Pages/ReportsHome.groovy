package com.k_int.cultureGrid.Reports.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class ReportsHome extends Page {
	static url = "reports/list"
	static at = {title.endsWith("Reports")};
	
	static content = {
		menu {module MenuOptions}
	}
}
