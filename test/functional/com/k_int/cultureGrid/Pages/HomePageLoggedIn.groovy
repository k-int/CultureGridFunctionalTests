package com.k_int.cultureGrid.Pages

import geb.Page

class HomePageLoggedIn extends Page {
	static url = "?__userid__=cgadmin&__password__=cgadmin"
	static at = {(title == "Culture Grid Administration - Home Page") || (title == "Culture Grid Administration - Registered User Home")};
	
	static content = {
		provider { $("a", text: "Data Provider Administration")}
	}
}
