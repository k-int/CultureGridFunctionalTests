package com.k_int.cultureGrid.UpdateRequest.Pages

import com.k_int.cultureGrid.Generic.BasePage

class UpdateRequestHome extends BasePage {
	static url = "admin/updates"
	static at = {title.endsWith("Update Request administration")};
	
	static content = {
	}
}
