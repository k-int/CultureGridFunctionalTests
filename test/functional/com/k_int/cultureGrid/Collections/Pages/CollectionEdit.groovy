package com.k_int.cultureGrid.Collections.Pages

import geb.Page

import com.k_int.cultureGrid.Generic.BasePage

class CollectionEdit extends BasePage {
	static url = "admin/collections/"
	static at = {$("b",text:"Collection Details")!=null};
	
	static content = {
 
 		genericSelect {name, value -> $("select",name:name).value(value)}
		genericTableLink (required:false) {name, text -> $("table",name:name).find("a",text:text)}
		collDetails {$("table",name:"collection_details")}
		
		//Error Message	
		errorMsg { collDetails.find("span", class:"errorMessage")}

		//Collection Details
		editedColCode { collDetails.find("input", name:"editedCollectionCode")}
		editedColName { collDetails.find("input", name:"editedCollectionName")}
		editedColDesc { collDetails.find("input", name:"editedCollectionDesc")}
		editedColType { collDetails.find("select", name: "editedCollectionType")}
		editedParentCollection {collDetails.find("input", name: "newParentCollection")}
		editedColEuropeanaName { collDetails.find("input", name: "editedEuropeanaName")}
		exposeThroughOAI {collDetails.find("select", name:"editedManagementPublicOAI")}
		exposeChildOAI {collDetails.find("select", name:"editedManagementOaiShowChildColls")}
		exposeDataProvOAI {collDetails.find("select", name:"editedManagementOaiShowSources")}
		childInSearch {collDetails.find("select", name: "editedManagementShowChildColls")}
		dataProvInSearch {collDetails.find("select", name: "editedManagementShowSources")}
		exposeToEuropeana {collDetails.find("select", name: "editedManagementExposeToEuropeana")}
		collDetailsSubmit { collDetails.find("input", type:"submit")}

		//Alternative Identifiers

		fieldAltIdentifier { ident -> $("input", name:"newAlternativeUrl").value(ident)}
		submitAltIdent { $("input",name:"submitNewAlternativeUrl")}
		addNewAltIdentifier {ident, dest -> fieldAltIdentifier(ident)
											submitAltIdent.click(dest)}

		existingAltIdent (required:false) { ident -> $("table", name:"alt_identifiers").find("td", text:ident)}
		removeAltIdent { ident, dest -> existingAltIdent(ident).parent().find("a").click(dest)}



		//Children collections 
		children_colls(required:false) {col_name -> genericTableLink("children_colls",col_name)}
		
		selectChildCol { col_name -> genericSelect("newChildCollectionCode", col_name ) }
		
		newChildSubmit { $("input",name:"newChildCollectionSubmit")}
		
		removeChildCol {col_name -> children_colls(col_name).parent().next().children().click()}
		
		addCollectionChild { col_name -> selectChildCol (col_name)
										newChildSubmit.click()}

		//Collection Editing
		authorizedUser (required:false) {user -> genericTableLink("users_permission",user)}
		selectUserID {user -> genericSelect("userId", user )}
		submitNewUser {$("input",name:"userIdSubmit")}


		authorizeNewUser {user -> selectUserID(user)
									submitNewUser.click()
						}
		removeAuthorizedUser { user -> authorizedUser(user).parent().parent().find("a",text:"revoke").click() }


		//Collection Deletion
		deleteAll { $("ul",name:"collection_deletion").find("a",0)}
		deleteRecords { $("ul",name:"collection_deletion").find("a",1)}
		deleteAndMove { $("ul",name:"collection_deletion").find("a",2)}

		//Europeana Validation
		revalidateInvalidRecords { $("ul",name:"europeana_validation").find("a",0)}
		revalidateCollectionRecords { $("ul",name:"europeana_validation").find("a",1)}
		retryEDM { $("ul",name:"europeana_validation").find("a",2)}
		convertToEDM { $("ul",name:"europeana_validation").find("a",3)}
	}
}
