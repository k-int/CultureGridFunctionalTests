package com.k_int.cultureGrid.Generic;

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class BasePage extends Page {
	static def ELEMENT_ANCHOR = "a"
	static def ELEMENT_FORM   = "form"
	static def ELEMENT_OPTION = "option"
	
	static def TYPE_INPUT    = "input"
	static def TYPE_SELECT   = "select"

	static content = {
		// Content that can be used by all the pages
		menu {module MenuOptions}
		getField {type, fieldName ->
				$(ELEMENT_FORM).find(type, name: fieldName)
		}
		getInputField {fieldName ->
			getField(TYPE_INPUT, fieldName)
		}
		getSelectField {fieldName ->
			getField(TYPE_SELECT, fieldName)
		}
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
		getSetInput {fieldName, value ->
			getSetType(TYPE_INPUT, fieldName, value)
		} 
		getSetSelect {fieldName, value ->
			getSetType(TYPE_SELECT, fieldName, value)
		}
		getSelectOptions {fieldName ->
			getSelectField(fieldName).find(ELEMENT_OPTION)
		}
		setSelectFromPosition {fieldName, position ->
			def options = getSelectOptions(fieldName)
			getSetSelect(fieldName, options[position].@value)
		}
		link(required: false) {id ->
			$(ELEMENT_ANCHOR, text: id)
		}
		select {
			id, detailsPage -> link(id).click(detailsPage)
		}
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
		createOrSelect {id, fieldMap, selectMap, createButtonName, homePage, detailsPage ->
			if (link(id).size() == 0) {
				createBase(fieldMap, selectMap, createButtonName, homePage)
				select(id, detailsPage)
			} else {
				select(id, detailsPage)
			}
		}
		createBase {fieldMap, selectMap, createButtonName, homePage ->
			populateFields(fieldMap, selectMap, false)
			clickButtonWait(createButtonName, homePage)
		}
		updateDetailsBase {fieldMap, selectMap, updateButton, pauseAfterSelectUpdate ->
			populateFields(fieldMap, selectMap, pauseAfterSelectUpdate)
			sleep(500)
			clickButton(updateButton)
		} 
		verifyDetailsBase {fieldMap ->
			def result = true
			fieldMap.each() {fieldName, value ->
				if (!value.equals(getSetInput(fieldName, null))) {
					result = false
				}
			}
			return(result)
		}
		clickButtonWait {buttonName, page ->
			if (page == null) {
				getInputField(buttonName).click()
			} else {
				getInputField(buttonName).click(page)
			}
		}
		clickButton {buttonName ->
			clickButtonWait(buttonName, null)
		}
 	}
}
