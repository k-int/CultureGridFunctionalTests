package com.k_int.cultureGrid.Pages

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class Upload extends Page {
	static url = "media/mediaUpload"
	static at = {title.endsWith("Culture Grid - Upload")};
	
	static content = {
		menu {module MenuOptions}
	}
}
