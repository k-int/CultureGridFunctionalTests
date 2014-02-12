package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class UserAdministration extends Page {
	static url = "admin/users"
	static at = {title.endsWith("User Administration")};
	
	static content = {
		menu {module MenuOptions}
	}
}
