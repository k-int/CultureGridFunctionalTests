package com.k_int.cultureGrid.Modules

import geb.Module

class MenuOptions extends Module {
	
	static content = {
		collection { $("a", text: "Collection Administration")}
		dataPush { $("a", text: "Data Push")}
		depositor { $("a", text: "Depositor Home")}
		editor { $("a", text: "Editor Home")}
		home { $("a", text: "Home")}
		mediaFormats { $("a", text: "Media Formats")}
		oai { $("a", text: "OAI Administration")}
		privilege { $("a", text: "Privilege Administration")}
		provider { $("a", text: "Data Provider Administration")}
		reports { $("a", text: "Reports")}
		update { $("a", text: "Update Request Administration")}
		upload { $("a", text: "Upload")}
		user { $("a", text: "User Administration")}
	}
}
