package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class UpdateRequestAdministration extends Page {
	static url = "admin/updates"
	static at = {title.endsWith("Update Request administration")};
	
	static content = {
		menu {module MenuOptions}
	}
}
