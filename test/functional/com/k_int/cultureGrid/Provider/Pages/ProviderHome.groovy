package com.k_int.cultureGrid.Provider.Pages;

import geb.error.RequiredPageContentNotPresent
import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class ProviderHome extends Page {
	static url = "admin/sources"
	static at = {title.endsWith("Data Provider Administration")};

	static content = {
		menu {module MenuOptions}
		link(required: false) {id -> $("a", text: id)}
		createProviderId {id -> $("form", name: "sources").sourceId = id}
		createProviderName {name -> $("form", name: "sources").sourceName = name}
		createButton { $("form").submit_create()}
		createOrSelect {id, name ->
			if (link(id).size() == 0) {
				createProviderId(id)
				createProviderName(name)
				createButton.click(ProviderHome)
				select(id)
			} else {
				select(id)
			}
		}
		select {
			id -> link(id).click(ProviderDetails)
		}
	}
}
