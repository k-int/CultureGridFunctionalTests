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

	static def createSelectMap(canUploadMedia) {
		return(["newCanUploadMedia" : canUploadMedia])
	}

	static content = {
		checkId {id -> waitFor {($("td", text: id).size() == 1)}}
		updateDetails {newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName, canUploadMedia ->
			updateDetailsBase(createFieldMap(newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName),
							  createSelectMap(canUploadMedia), "submit_details")
		} 
		verifyDetails {id, newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName ->
			checkId(id) &&
			verifyDetailsBase(createFieldMap(newEmail, newEuropeanaId, newEuropeanaName, newMediaStorePath, newName))
		}
		addUser {userId ->
			getSetSelect("userId", userId)
			clickButton("submit_grant_user")
		}
		verifyUser {userId ->
			waitFor {($("a", text: userId).size() == 1)}
		}
		removeUser {userId ->
			$("a", text: "revoke", href: endsWith("/" + userId)).click()
		}
		addSchema {schemaPosition -> 
			setSelectFromPosition("schemaId", schemaPosition)
			clickButton("submit_schema")
		}
		verifySchema {
			waitFor {getInputField("removeSchemaId")}
		}
		removeSchema {
			getSetInput("removeSchemaId", true)
			clickButton("submit_schema")
		}
		addCollection {collectionName ->
			getSetSelect("newCollectionIdentifier", collectionName)
			clickButton("submit_collection")
		}
		verifyCollection {collectionName ->
			waitFor {link(collectionName) && link("remove")}
		}
		removeCollection {collectionName ->
			// First <td> is the link to the collection, the 2nd <td> is the link to remove it 
			link(collectionName).parent().next().children().click()
		}
	}
}
