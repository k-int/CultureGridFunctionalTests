package com.k_int.cultureGrid.Pages;

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class ProviderPage extends Page {

	static at = {title.endsWith("Data Provider Administration")};

	static content = {
		menu {module MenuOptions}
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
