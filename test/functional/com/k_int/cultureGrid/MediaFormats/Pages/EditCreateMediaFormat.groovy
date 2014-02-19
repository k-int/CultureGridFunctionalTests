package com.k_int.cultureGrid.MediaFormats.Pages

import com.k_int.cultureGrid.Generic.BasePage

class EditCreateMediaFormat extends BasePage {
	static url = "media/*/editFormat"
	static at = {title.endsWith("Media Format Editor")};
	
	static content = {
		formatTitle { title -> getSetInput("formatDTO.name",title)}
		applyTo {providerCode -> getSetSelect("selectedProvider",providerCode) }
		removeFrom {providerCode -> getSetSelect("providerToRemove",providerCode)}

		providerList {providerCode -> $("ul").find("li",value:providerCode)}

		submit { $("input",value:"Save format")}

		deleteFormat (required:false) { link("Delete this format")}

		editError { $("div", class: "error")}


	}
}
