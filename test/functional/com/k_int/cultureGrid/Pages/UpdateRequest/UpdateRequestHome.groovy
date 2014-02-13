package com.k_int.cultureGrid.Pages.UpdateRequest

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class UpdateRequestHome extends Page {
	static url = "admin/updates"
	static at = {title.endsWith("Update Request administration")};
	
	static content = {
		menu {module MenuOptions}
	}
}
