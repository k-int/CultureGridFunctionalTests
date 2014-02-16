package com.k_int.cultureGrid.OAI.Pages

import com.k_int.cultureGrid.Generic.BasePage

class OAIHome extends BasePage {
	static url = "oai-mgr/list"
	static at = {title.endsWith("OAI management")};
	
	static content = {
	}
}
