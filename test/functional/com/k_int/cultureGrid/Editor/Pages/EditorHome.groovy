package com.k_int.cultureGrid.Editor.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class EditorHome extends Page {
	static url = "edit/home"
	static at = {title.endsWith("Editor Home")};
	
	static content = {
		menu {module MenuOptions}
	}
}
