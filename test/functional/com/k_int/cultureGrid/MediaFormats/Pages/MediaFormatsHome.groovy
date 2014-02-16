package com.k_int.cultureGrid.MediaFormats.Pages

import com.k_int.cultureGrid.Generic.BasePage

class MediaFormatsHome extends BasePage {
	static url = "media/listFormats"
	static at = {title.endsWith("Media format editor")};
	
	static content = {
	}
}
