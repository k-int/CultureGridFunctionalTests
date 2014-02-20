package com.k_int.cultureGrid.OAI.Pages

import com.k_int.cultureGrid.Generic.BasePage

class EditOAIInstruction extends BasePage {
	static url = "oai-mgr/list"
	static at = {title.endsWith("OAI management")};
	
	static content = {
		populateForm { title, uri, prefix, setSpec, charset,
			interval, maxRetries, retryIncrement, defaultNamespace, limitAttribute, 
			offsetAttribute, fetchSize, 
			providerCode, span, userID, parentCollectionName, harvestType  ->	

			

			populateFields (createFieldMap(title, uri, prefix, setSpec, charset,
			interval, maxRetries, retryIncrement, defaultNamespace, limitAttribute, 
			offsetAttribute, fetchSize) , 
			createSelectMap( providerCode, span, userID, parentCollectionName, harvestType )  )

			$("input",value:"Submit").click()
		}

		validateDetails { title, uri, prefix, setSpec, charset,
			interval, maxRetries, retryIncrement, defaultNamespace, limitAttribute, 
			offsetAttribute, fetchSize, providerCode, span, userID, parentCollectionName, harvestType   ->

			verifyDetailsBase( createFieldMap(title, uri, prefix, setSpec, charset,
				interval, maxRetries, retryIncrement, defaultNamespace, limitAttribute, 
				offsetAttribute, fetchSize) ,
				 createSelectMap( providerCode, span, userID, parentCollectionName, harvestType ))

		}
		listAllInstructions { $("input",value:"List all available instructions")}

	}
 

	static def createFieldMap(title, uri, prefix, setSpec, charset,
		interval, maxRetries, retryIncrement, defaultNamespace, limitAttribute, 
		offsetAttribute, fetchSize){
		return(["instruction.title" : title,
				"instruction.metadataPrefix" : prefix,
				"instruction.uri": uri,
				"instruction.setSpec" : setSpec,
				"instruction.charset": charset,
				"instruction.interval" : interval,
				"instruction.maxRetries": maxRetries,
				"instruction.retryIncrement" : retryIncrement,
				"instruction.defaultNamespace" : defaultNamespace,
				"instruction.limitAttribute" : limitAttribute,
				"instruction.offsetAttribute" : offsetAttribute,
				"instruction.fetchSize" : fetchSize ])		
	}

	static def createSelectMap( providerCode, span, userID, parentCollectionName, harvestType ) {
		return([
		"instruction.providerCode" :providerCode,
		"instruction.span" : span,
		"instruction.uploadUserName" : userID,
		"instruction.parentCollectionName" : parentCollectionName,
		"instruction.harvestType" : harvestType])
	}
}
