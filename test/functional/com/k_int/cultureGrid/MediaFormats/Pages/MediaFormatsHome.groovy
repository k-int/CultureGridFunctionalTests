package com.k_int.cultureGrid.MediaFormats.Pages

import com.k_int.cultureGrid.Generic.BasePage

class MediaFormatsHome extends BasePage {
	static url = "media/listFormats"
	static at = {title.endsWith("Media format editor")};
	
	static content = {
		selectFormat { name -> link(name)}

		selectFormatArtifact {name -> link(name).parent().parent().find("a",text:"artifacts")}

		createNewFormat { $("input",type:"submit")}
	}
}
