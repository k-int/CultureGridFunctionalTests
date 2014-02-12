package com.k_int.cultureGrid.Pages

import geb.Page

class HomePageNotLoggedIn extends Page {
//	static url = "dpp"
	static at = {(title.endsWith("Home Page")) || (title.endsWith("Registered User Home"))};
	
	static content = {
		login { $("a", text: "Login")}
		provider { $("a", text: "Data Provider Administration")}
	}
}
