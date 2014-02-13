package com.k_int.cultureGrid.Pages.OAI

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class OAIHome extends Page {
	static url = "oai-mgr/list"
	static at = {title.endsWith("OAI management")};
	
	static content = {
		menu {module MenuOptions}
	}
}
