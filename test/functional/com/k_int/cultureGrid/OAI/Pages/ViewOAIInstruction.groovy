package com.k_int.cultureGrid.OAI.Pages

import com.k_int.cultureGrid.Generic.BasePage

class ViewOAIInstruction extends BasePage {

	static at = {title.endsWith("OAI management")};

	static content = {
		deleteInstruction { link("Delete this Instruction")}
		editInstruction { $("input",value:"Edit this instruction")}
		listAllInstructions { $("input", value:"List all available instructions")}
	}

}