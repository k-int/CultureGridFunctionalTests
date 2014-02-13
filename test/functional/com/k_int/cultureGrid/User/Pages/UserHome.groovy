package com.k_int.cultureGrid.User.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class UserHome extends Page {
	static url = "admin/users"
	static at = {title.endsWith("User Administration")};
	
	static content = {
		menu {module MenuOptions}
	}
}
