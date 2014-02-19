package com.k_int.cultureGrid.User.Pages;

import com.k_int.cultureGrid.Generic.BasePage

class UserDetails extends BasePage {

	// Identifier needs to be appended to this
	static url = "admin/users"
	static at = {title.endsWith("User Administration")};

	static def createFieldMap(name, email, password, passwordConfirm) {
		return(["personalName" : name,
				"contact" : email,
				"password" : password,
				"passwordConf" : passwordConfirm])
	}

	static content = {
		checkId {id -> waitFor {($("b", text: "Editing user \"" + id + "\"").size() == 1)}}
		updateDetails {name, email, password, passwordConfirm ->
			updateDetailsBase(createFieldMap(name, email, password, passwordConfirm), null, "submit_details")
		} 
		verifyDetails {id, name, email ->
			checkId(id) &&
			verifyDetailsBase(createFieldMap(name, email, "", ""))
		} 
	}
}
