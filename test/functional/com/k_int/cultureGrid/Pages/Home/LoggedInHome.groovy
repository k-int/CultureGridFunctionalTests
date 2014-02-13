package com.k_int.cultureGrid.Pages.Home

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class LoggedInHome extends Page {
	static url = "?__userid__=cgadmin&__password__=cgadmin"
	static at = {(title.endsWith("Home Page")) || (title.endsWith("Registered User Home"))};
	
	static content = {
		menu {module MenuOptions}
	}
}
