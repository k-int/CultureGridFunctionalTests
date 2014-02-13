package com.k_int.cultureGrid.Home.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class LoggedInHome extends Page {
	static url = "?__userid__=XXX&__password__=YYY"
	static at = {(title.endsWith("Home Page")) || (title.endsWith("Registered User Home"))};
	
	static content = {
		menu {module MenuOptions}
	}
}
