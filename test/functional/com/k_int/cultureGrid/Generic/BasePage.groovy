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
					field.value(value)
				}
				field.value()
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
		populateFields {fieldMap ->
			fieldMap.each() {fieldName, value ->
				getSetInput(fieldName, value)
			}
		}
		createOrSelect {id, fieldMap, createButtonName, homePage, detailsPage ->
			if (link(id).size() == 0) {
				populateFields(fieldMap)
				clickButton(createButtonName)
				waitFor 30D, {at homePage}
				select(id, detailsPage)
			} else {
				select(id, detailsPage)
			}
		}
		updateDetailsBase {fieldMap, updateButton ->
			populateFields(fieldMap)
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
		clickButton {buttonName ->
			getInputField(buttonName).click()
		}
 	}
}
