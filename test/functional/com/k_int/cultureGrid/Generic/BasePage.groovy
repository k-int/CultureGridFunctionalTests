package com.k_int.cultureGrid.Generic;

import geb.Page

import com.k_int.cultureGrid.Modules.MenuOptions

class BasePage extends Page {
	static content = {
		// Content that can be used by all the pages
		menu {module MenuOptions}
		getField {type, fieldName ->
				$("form").find(type, name: fieldName)
		}
		getInputField {fieldName -> getField("input", fieldName)}
		getSetType {type, fieldName, value -> 
			def field = getField(type, fieldName)
			if (field.size() == 1) {
				if (value != null) {
					field.value(value)
				}
				field.value()
			}
		}
		getSetInput {fieldName, value -> getSetType("input", fieldName, value)} 
		getSetSelect {fieldName, value -> getSetType("select", fieldName, value)}
		link(required: false) {id -> $("a", text: id)}
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
				getInputField(createButtonName).click()
				waitFor 30D, {at homePage}
				select(id, detailsPage)
			} else {
				select(id, detailsPage)
			}
		}
		updateDetailsBase {fieldMap, updateButton ->
			populateFields(fieldMap)
			getInputField(updateButton).click()
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
	}
}
