package com.k_int.cultureGrid.Collections.Pages

import geb.Page

import com.k_int.cultureGrid.Collections.Pages.CollectionDetails
import com.k_int.cultureGrid.Generic.BasePage


class CollectionSearch extends BasePage {
	static url = "admin/collections"
	static at = {title.endsWith("Collection Administration")};
	
	static content = {
		searchCriteria { search ->$("input", name: "searchCriteria").value(search) }
		submitForm { $("input", id:"collections_0")}
		
		searchCol {id -> 
			searchCriteria(id)
			submitForm.click()
		}

		viewCollection {id -> $("a",text:id).click(CollectionDetails)}	

		createNewCollection { $("input",value:"Create a new collection")}
	}
}
