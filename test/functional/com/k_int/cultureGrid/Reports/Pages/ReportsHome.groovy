package com.k_int.cultureGrid.Reports.Pages

import com.k_int.cultureGrid.Generic.BasePage

class ReportsHome extends BasePage {
	static url = "reports/list"
	static at = {title.endsWith("Reports")};
	
	static content = {
	}
}
