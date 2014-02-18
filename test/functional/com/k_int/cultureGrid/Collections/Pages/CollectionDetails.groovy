package com.k_int.cultureGrid.Collections.Pages

import geb.Page

import com.k_int.cultureGrid.Generic.BasePage

class CollectionDetails extends BasePage {
	static url = "view/collection/"
	static at = {title.endsWith("Collection Details (read only)")};
	
	static content = {
		
		findResource {match -> $("ul").find("a", text:match)}
		recentResource { $("ul").find("a", alt:"View this resource")}

		editColButton {$("input", value:"Edit this collection")}
	}
}
