package com.k_int.cultureGrid.Provider.Pages;

import geb.error.RequiredPageContentNotPresent
import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class ProviderDetails extends Page {

	// Identifier needs to be appended to this
	static url = "admin/sources"
	static at = {title.endsWith("Data Provider Administration")};

	static content = {
		menu {module MenuOptions}
		getSet {fieldName, value ->
			def field = $("form").find("input", name: fieldName)
			if (field.size() == 1) {
				if (value != null) {
					field.value(value)
				}
				field.value()
			}
		}
		checkId {id -> waitFor {($("td", text: id).size() == 1)}}
		email {value -> getSet("newEmail", value)}
		europeanaId {value -> getSet("newEuropeanaId", value)}
		europeanaName {value -> getSet("newEuropeanaName", value)}
		mediaStorePath {value -> getSet("mediaStorePath", value)}
		name {value -> getSet("newName", value)}
		deailsButton {$("form").submit_details()}
		updateDetails {newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName ->
			email(newEmail)
			europeanaId(newEuropeanaId)
			europeanaName(newEuropeanaName)
			mediaStorePath(newMediaStorePath)
			name(newName)
			deailsButton.click()
		} 
		verifyDetails {id, newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName ->
			checkId(id) &&
			(newEmail == email) &&
			(newEuropeanaId == europeanaId) &&
			(newEuropeanaName == europeanaName) &&
			(newMediaStorePath == mediaStorePath) &&
			(newName == name)
		} 
	}
}
