package com.k_int.cultureGrid.Home.Pages

import com.k_int.cultureGrid.Generic.BasePage

class LoggedInHome extends BasePage {
	static url = "?__userid__=XXX&__password__=YYY"
	static at = {(title.endsWith("Home Page")) || (title.endsWith("Registered User Home"))};
	
	static content = {
	}
}
