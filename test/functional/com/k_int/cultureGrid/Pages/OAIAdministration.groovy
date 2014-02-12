package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class OAIAdministration extends Page {
	static url = "oai-mgr/list"
	static at = {title.endsWith("OAI management")};
	
	static content = {
		menu {module MenuOptions}
	}
}
