package com.k_int.cultureGrid.Provider.Pages;

import com.k_int.cultureGrid.Generic.BasePage

class ProviderDetails extends BasePage {

	// Identifier needs to be appended to this
	static url = "admin/sources"
	static at = {title.endsWith("Data Provider Administration")};

	static def createFieldMap(email, europeanaId, europeanaName, mediaStorePath, name) {
		return(["newEmail" : email,
				"newEuropeanaId" : europeanaId,
				"newEuropeanaName" : europeanaName,
				"mediaStorePath" : mediaStorePath,
				"newName" : name])
	}

	static content = {
		checkId {id -> waitFor {($("td", text: id).size() == 1)}}
		updateDetails {newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName ->
			updateDetailsBase(createFieldMap(newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName), "submit_details")
		} 
		verifyDetails {id, newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName ->
			checkId(id) &&
			verifyDetailsBase(createFieldMap(newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName))
		} 
	}
}
