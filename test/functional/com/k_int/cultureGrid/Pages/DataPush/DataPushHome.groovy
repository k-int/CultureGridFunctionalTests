package com.k_int.cultureGrid.Pages.DataPush

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class DataPushHome extends Page {
	static url = "push/list"
	static at = {title.endsWith("Data Push instruction list")};
	
	static content = {
		menu {module MenuOptions}
	}
}
