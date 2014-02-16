package com.k_int.cultureGrid.Home.Pages

import com.k_int.cultureGrid.Generic.BasePage

class NotLoggedInHome extends BasePage {
//	static url = "dpp"
	static at = {(title.endsWith("Home Page")) || (title.endsWith("Registered User Home"))};
	
	static content = {
		login { $("a", text: "Login")}
		provider { $("a", text: "Data Provider Administration")}
	}
}
