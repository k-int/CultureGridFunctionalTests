package com.k_int.cultureGrid.Pages.MediaFormats

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class MediaFormatsHome extends Page {
	static url = "media/listFormats"
	static at = {title.endsWith("Culture Grid - Media format editor")};
	
	static content = {
		menu {module MenuOptions}
	}
}
