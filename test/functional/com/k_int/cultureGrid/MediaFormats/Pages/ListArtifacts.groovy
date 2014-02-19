package com.k_int.cultureGrid.MediaFormats.Pages

import com.k_int.cultureGrid.Generic.BasePage

class ListArtifacts extends BasePage {
	static url = "media/*/listArtifacts"
	static at = {driver.getCurrentUrl().endsWith("listArtifacts")};
	
	static content = {
		addNewArtifact { $("input",type:"submit")}	
		editArtifact (required: false) {name -> link(name)}
	}
}
