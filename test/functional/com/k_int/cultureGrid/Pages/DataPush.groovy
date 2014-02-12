package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class DataPush extends Page {
	static url = "push/list"
	static at = {title.endsWith("Data Push instruction list")};
	
	static content = {
		menu {module MenuOptions}
	}
}
