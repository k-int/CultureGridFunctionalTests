package com.k_int.cultureGrid.OAI;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.data.Data
import com.k_int.cultureGrid.Home.Pages.LoggedInHome
import com.k_int.cultureGrid.OAI.Pages.OAIHome
import com.k_int.cultureGrid.OAI.Pages.EditOAIInstruction
import com.k_int.cultureGrid.OAI.Pages.ViewOAIInstruction




@Stepwise
class OAISpec extends GebReportingSpec {
	def "list available instructions"() {
		given:
			to LoggedInHome
		expect:
			menu.oai.click(OAIHome)
		driver.switchTo().frame("oai_frame")

	}
	
	def "Enable/Disable harvesting" (){
		given:
			at OAIHome
		expect:
			2.times{
		if(isActive.isEmpty()){
			withConfirm { enable.click() }
			isActive.isEmpty() == false
		}else{
			withConfirm {disable.click()}
			isDisabled.isEmpty() == false
		}
	}
	}
	
	def "Add Instruction" () {
		given:
			at OAIHome
			addNewInstruction.click()
		expect:
			at EditOAIInstruction

		when: 
			populateForm(Data.OAI_INSTRUCTION_NAME, "base_url", "pnds_dc", "PN",
			"UTF-16", "8", "4", "6", "default_namespace", 
			"unlimited", "offset attr","11",Data.PROVIDER_GENERAL_ID,"YEAR",Data.USER_GENERAL_ID,Data.COLLECTION_TEST_ID,"XML")
		then:
			at OAIHome

	}

	def "Verify edit values"() {
		given:
			at OAIHome
		expect:
			editInstruction(Data.OAI_INSTRUCTION_NAME).click(EditOAIInstruction)
			validateDetails(Data.OAI_INSTRUCTION_NAME, "base_url", "pnds_dc", "PN",
			"UTF-16", "8", "4", "6", "default_namespace", 
			"unlimited", "offset attr","11",Data.PROVIDER_GENERAL_ID,"YEAR",Data.USER_GENERAL_ID,Data.COLLECTION_TEST_ID,"XML")

		listAllInstructions.click(OAIHome)
	}

	def "Verify status"() {
		given:
			at OAIHome
		expect:
			def statusValue = status(Data.OAI_INSTRUCTION_NAME)
			statusValue.equals("IDLE") || statusValue.equals("AWAITING_RETRY")
			progress(Data.OAI_INSTRUCTION_NAME).equals("0 / 0 / 0")
			lastRun(Data.OAI_INSTRUCTION_NAME).equals("")

	}
	
	def "Suspend instruction" (){
		given:
			at OAIHome
			suspend(Data.OAI_INSTRUCTION_NAME).click()
		expect:
			status(Data.OAI_INSTRUCTION_NAME).equals("SUSPENDED")
	}

		def "harvest new "(){
		given:
			at OAIHome
			status(Data.OAI_INSTRUCTION_NAME).equals("SUSPENDED")

		when:
			harvestNew(Data.OAI_INSTRUCTION_NAME).click()
		then:
			def statusValue = status(Data.OAI_INSTRUCTION_NAME)
			statusValue.equals("IDLE") || statusValue.equals("AWAITING_RETRY")
	}
		
	def "Harvest all" (){
		given:
			at OAIHome

		when:
			suspend(Data.OAI_INSTRUCTION_NAME).click()
			harvestAll(Data.OAI_INSTRUCTION_NAME).click()
		then:
			def statusValue = status(Data.OAI_INSTRUCTION_NAME)
			statusValue.equals("IDLE") || statusValue.equals("AWAITING_RETRY")
	}
	
	def "Delete Testing instruction" (){
		given:
			at OAIHome

		selectInstruction(Data.OAI_INSTRUCTION_NAME).click(ViewOAIInstruction)
		withConfirm {deleteInstruction.click(OAIHome) }


	}
	
}