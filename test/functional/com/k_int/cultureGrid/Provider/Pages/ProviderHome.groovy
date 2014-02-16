package com.k_int.cultureGrid.Provider.Pages;

import geb.error.RequiredPageContentNotPresent

import com.k_int.cultureGrid.Generic.BasePage

class ProviderHome extends BasePage {
	static url = "admin/sources"
	static at = {title.endsWith("Data Provider Administration")};

	static def createFieldMap(id, name) {
		return(["sourceId" : id,
				"sourceName" : name])
	}

	static content = {
		createSelect {id, name ->
			createOrSelect(id, createFieldMap(id, name), "submit_create", ProviderHome, ProviderDetails)
		}
	}
}
