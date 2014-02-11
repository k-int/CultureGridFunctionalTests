package com.k_int.cultureGrid.Pages;

import geb.Page

class ProviderPage extends Page {

	static at = {title == "Culture Grid Administration - Data Provider Administration"};

	static content = {
		createProviderId { $("form", name: "sources").sourceId}
		createProviderName { $("form", name: "sources").sourceName}
		createButton { $("form", name: "sources").sources_0}
		createNew {id, name ->
			createProviderId = id
			createProviderName = name
			createButton.click()
		}
		select { id -> $("a", text: id).click()}
	}
}
