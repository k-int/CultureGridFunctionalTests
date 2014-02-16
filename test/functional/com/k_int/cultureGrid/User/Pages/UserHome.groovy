package com.k_int.cultureGrid.User.Pages

import com.k_int.cultureGrid.Generic.BasePage

class UserHome extends BasePage {
	static url = "admin/users"
	static at = {title.endsWith("User Administration")};

	static def createFieldMap(id, name, password, passwordConfirm, email) {
		return(["userName" : id,
			    "personalName" : name,
				"passwordMain" : password,
				"passwordConf" : passwordConfirm,
				"contact" : email])
	}

	static content = {
		createSelect {id, name, password, passwordConfirm, email ->
			createOrSelect(id, createFieldMap(id, name, password, passwordConfirm, email), "submit_create", UserHome, UserDetails) 
		}
	}
}
