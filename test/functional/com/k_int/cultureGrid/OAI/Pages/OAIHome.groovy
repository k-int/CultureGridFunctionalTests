package com.k_int.cultureGrid.OAI.Pages

import com.k_int.cultureGrid.Generic.BasePage

class OAIHome extends BasePage {
	static url = "oai-mgr/list"
	static at = {title.endsWith("OAI management")};
	
	static content = {
		enable {link("Click to enable harvesting")}
		disable { link("Click to disable future harvesting")}

		isActive (required:false) { $("b",text:"Harvesting is active")}
		isDisabled (required:false) { $("b",text:"Harvesting is not active")}
		
		addNewInstruction { $("input",value:"Add new harvest Instruction") }

		selectInstruction { name -> link(name) }
		harvestNew {name -> selectInstruction(name).parent().parent().next("8").getChild()}
		harvestAll {name -> selectInstruction(name).parent().parent().find("a",2)}

		editInstruction { name -> selectInstruction(name).closest("tr").find("a").last()}
		frame { action -> withFrame("oai_frame") { action } }

		status { name -> selectInstruction(name).closest("tr").find("td",1).text()}
		progress { name -> selectInstruction(name).closest("tr").find("td",2).text()}
		lastRun { name -> selectInstruction(name).closest("tr").find("td",3).text()}
		nextDue { name -> selectInstruction(name).closest("tr").find("td",4).text()}

		suspend { name -> selectInstruction(name).closest("tr").find("td",5).children()}
	}
}