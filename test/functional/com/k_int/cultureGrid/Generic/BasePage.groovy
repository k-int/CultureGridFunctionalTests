package com.k_int.cultureGrid.Generic;

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

/** Base Page for all pages, this contains closures in the content that can be used by any of the pages */
class BasePage extends Page {
	static def ELEMENT_ANCHOR = "a"
	static def ELEMENT_FORM   = "form"
	static def ELEMENT_OPTION = "option"
	
	static def TYPE_INPUT    = "input"
	static def TYPE_SELECT   = "select"

	static content = {
		/** Gives access to the menu options */
		menu {module MenuOptions}
		
		/** Retrieves a field within a form given its name */
		getField {type, fieldName ->
				$(ELEMENT_FORM).find(type, name: fieldName)
		}
		
		/** Retrieves an input field within a form given ite name */
		getInputField {fieldName ->
			getField(TYPE_INPUT, fieldName)
		}
		
		/** Retrieves a select field within a form given ite name */
		getSelectField {fieldName ->
			getField(TYPE_SELECT, fieldName)
		}

		/** Retrieves and sets a fields value on a form given its name, if the value is null then the field is not set */		
		getSetType {type, fieldName, value -> 
			def field = getField(type, fieldName)
			if (field.size() == 1) {
				if (value != null) {
					//println "Setting field \"" + fieldName + "\", value: \"" + value + "\""					
					field.value(value)
				}
				//println "field \"" + fieldName + "\", value: \"" + field.value() + "\""					
				field.value()
			} else {
				// println "Not found field: \"" + fieldName + "\", type: \"" + type + "\""					
			}
		}

		/** Retrieves and sets an input field value on a form given its name, if the value is null then the field is not set */		
		getSetInput {fieldName, value ->
			getSetType(TYPE_INPUT, fieldName, value)
		} 

		/** Retrieves and sets a select field value on a form given its name, if the value is null then the field is not set */		
		getSetSelect {fieldName, value ->
			getSetType(TYPE_SELECT, fieldName, value)
		}

		/** Retrieves the options for a select field */		
		getSelectOptions {fieldName ->
			getSelectField(fieldName).find(ELEMENT_OPTION)
		}

		/** Sets the value of a combo field based on the position */		
		setSelectFromPosition {fieldName, position ->
			def options = getSelectOptions(fieldName)
			getSetSelect(fieldName, options[position].@value)
		}

		/** Retrieves a link based on the text for the link */
		link(required: false) {linkText ->
			$(ELEMENT_ANCHOR, text: linkText)
		}

		/**	Selects a link based on the text for the link and checks that it goes tho the specified page */	
		select {linkText, detailsPage ->
			link(linkText).click(detailsPage)
		}
	
		/** Populates the form fields given the supplied field and select maps
		 * The field and select maps, map a field name to its value
		 * If a select field triggers an ajax call then you will want to set pauseAfterSelectUpdate to true, to give the ajax calla chance to execute 
		 */
		populateFields {fieldMap, selectMap, pauseAfterSelectUpdate ->
			fieldMap.each() {fieldName, value ->
				if (value != null) {
					getSetInput(fieldName, value)
				}
			}
			if (selectMap != null) {
				selectMap.each() {fieldName, value ->
					if (value != null) {
						getSetSelect(fieldName, value)
						if (pauseAfterSelectUpdate == true) {
							// Sleep for half a second as there may be an ajax call being triggered
							sleep(500)
						}
					}
				}
			}
			return(true)
		}

		/** If the linkText exists then it will goto that link checking that it arrives at the DetailsPage
		 * If the linkText does not exist, it will populate the fields using the field and select maps,
		 * once create it assumes the linkText exists and will goto that link
		 */
		createOrSelect {linkText, fieldMap, selectMap, createButtonName, homePage, detailsPage ->
			if (link(linkText).size() == 0) {
				createBase(fieldMap, selectMap, createButtonName, homePage)
				select(linkText, detailsPage)
			} else {
				select(linkText, detailsPage)
			}
		}

		/** Populates the form fields using the field and select maps and clicks the button to submit the form then waits for the homePage to appear */
		createBase {fieldMap, selectMap, createButtonName, homePage ->
			populateFields(fieldMap, selectMap, false)
			clickButtonWait(createButtonName, homePage)
		}

		/** Populates the form fields using the field and select maps and clicks the button to submit the form */
		updateDetailsBase {fieldMap, selectMap, updateButton, pauseAfterSelectUpdate ->
			populateFields(fieldMap, selectMap, pauseAfterSelectUpdate)
			clickButton(updateButton)
		}

		/** Verifies that the values in the form match up to the values in the field and select maps */		 
		verifyDetailsBase {fieldMap, selectMap ->
			def result = true
			if(fieldMap !=null){
				fieldMap.each() {fieldName, value ->
					if (!value.equals(getSetInput(fieldName, null))) {
						result = false
					}
				}
			}
			if (selectMap != null) {
				selectMap.each() {fieldName, value ->
					if(!value.equals(getSetSelect(fieldName,null))){
						result = false;
					}						
				}
			}
			return(result)
		}

		/** Clicks the form button with the given name and waits for the specified page to be displayed,
		 * If page is null, then it does not wait 
		 */
		clickButtonWait {buttonName, page ->
			if (page == null) {
				getInputField(buttonName).click()
			} else {
				getInputField(buttonName).click(page)
			}
		}

		/** Clicks the specified form button **/		
		clickButton {buttonName ->
			clickButtonWait(buttonName, null)
		}
 	}
}
