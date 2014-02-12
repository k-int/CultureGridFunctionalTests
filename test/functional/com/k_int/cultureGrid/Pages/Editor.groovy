package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class Editor extends Page {
	static url = "edit/home"
	static at = {title.endsWith("Editor Home")};
	
	static content = {
		menu {module MenuOptions}
	}
}
