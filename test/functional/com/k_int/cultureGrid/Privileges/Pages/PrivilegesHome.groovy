package com.k_int.cultureGrid.Privileges.Pages

import com.k_int.cultureGrid.Generic.BasePage

class PrivilegesHome extends BasePage {
	static url = "admin/grants"
	static at = {title.endsWith("Privilege Administration")};
	
	static content = {
	}
}
