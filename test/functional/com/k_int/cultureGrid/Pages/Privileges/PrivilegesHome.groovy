package com.k_int.cultureGrid.Pages.Privileges

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class PrivilegesHome extends Page {
	static url = "admin/grants"
	static at = {title.endsWith("Privilege Administration")};
	
	static content = {
		menu {module MenuOptions}
	}
}
