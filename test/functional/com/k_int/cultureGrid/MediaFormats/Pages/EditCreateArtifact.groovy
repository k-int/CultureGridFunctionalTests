package com.k_int.cultureGrid.MediaFormats.Pages

import com.k_int.cultureGrid.Generic.BasePage

class EditCreateArtifact extends BasePage {
	static url = "media/*/*/editArtifact"
	static at = {driver.getCurrentUrl().endsWith("editArtifact")};
	
	static content = {
		updateDetails {name,height,width,aspect_ratio,extension,top,bottom,left,right,type ->
				populateFields(createFieldMap(name,height,width,aspect_ratio,top,bottom,left,right), null, false)
				getSelectField("artifactDTO.extension").value(extension)
				getSelectField("artifactDTO.linkType").value(type)
		}
		verifyDetails {name,height,width,aspect_ratio,extension,top,bottom,left,right,type ->
				verifyDetailsBase(createFieldMap(name,height,width,aspect_ratio,top,bottom,left,right), null)
				getSelectField("artifactDTO.extension").value() == extension
				getSelectField("artifactDTO.linkType").value() == type
			}

		saveArtifact { $("input",type:"submit")}

		deleteArtifact { link("Delete this artifact")}

		errorMessage { $("ul",class:"errorMessage") }

	}

	static def createFieldMap(name, height, width, aspect_ratio,
		top,bottom,left,right){
		return(["artifactDTO.name" : name,
				"artifactDTO.height": height,
				"artifactDTO.width" : width,
				"artifactDTO.ignoreAspectRatio": aspect_ratio,
				"artifactDTO.top" : top,
				"artifactDTO.bottom": bottom,
				"artifactDTO.left" : left,
				"artifactDTO.right" : right])		
	}
}
