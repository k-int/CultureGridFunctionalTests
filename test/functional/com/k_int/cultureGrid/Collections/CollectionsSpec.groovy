package com.k_int.cultureGrid.Collections;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Collections.Pages.*
import com.k_int.cultureGrid.Home.Pages.*
import com.k_int.cultureGrid.data.Data


@Stepwise
class CollectionsSpec extends GebReportingSpec {

	def "Collection Admin Search"() {
		when:
			to LoggedInHome
		then:
			at LoggedInHome
		
		menu.collection.click();

		when:
		at CollectionSearch
		searchCol(Data.TESTING_COLLECTION)
		then:
		at CollectionSearch

	}

	def "View Collection"() {
		when:
			at CollectionSearch
			viewCollection(Data.TESTING_COLLECTION)
		then:
			at CollectionDetails

	}

	def "Access Edit collection" (){
		when:
			menu.collection.click(CollectionSearch);
			searchCol(Data.TESTING_COLLECTION)
			viewCollection(Data.TESTING_COLLECTION)
		then:
			at CollectionDetails

		editColButton.click(CollectionEdit)

	}
	

	def "Authorize/Remove User"(){
			menu.collection.click(CollectionSearch)
			searchCol(Data.TESTING_COLLECTION)
			viewCollection(Data.TESTING_COLLECTION)
			editColButton.click(CollectionEdit)
		when:
			authorizeNewUser(Data.TESTING_COLLECTION_USER)
		then:
			authorizedUser(Data.TESTING_COLLECTION_USER).isEmpty() == false

		when:
			removeAuthorizedUser(Data.TESTING_COLLECTION_USER)
		then:
			authorizedUser(Data.TESTING_COLLECTION_USER).isEmpty()
	}

	def "Add_Remove Child Collection"() {
		at CollectionEdit
		when:
			addCollectionChild(Data.TESTING_COLLECTION_CHILD)
		then:
			children_colls(Data.TESTING_COLLECTION_CHILD).isEmpty() == false
			withConfirm { removeChildCol(Data.TESTING_COLLECTION_CHILD)}
			children_colls(Data.TESTING_COLLECTION_CHILD).isEmpty()
	}

	


	def "Create New Collection"() {
		when:
			menu.collection.click(CollectionSearch)
			createNewCollection.click(CollectionEdit)
			editedColCode.value(Data.TESTING_COLLECTION)
			editedColName.value("Functional Testing Collection")
			editedColDesc.value("Used for testing")
			editedColType.value("Item")
			editedParentCollection.value("PN")
			editedColEuropeanaName.value("Europeana name here")
			exposeThroughOAI.value("true")
			exposeChildOAI.value("true")
			exposeDataProvOAI.value("true")
			childInSearch.value("true")
			dataProvInSearch.value("true")
			exposeToEuropeana.value("true")
			collDetailsSubmit.click(CollectionEdit)
		then:
			errorMsg.size() == 2
	}

	def "Edit Collection Details"() {
		when:
			menu.collection.click(CollectionSearch)
			searchCol(Data.TESTING_COLLECTION)
			viewCollection(Data.TESTING_COLLECTION)
		then:
			at CollectionDetails
			editColButton.click(CollectionEdit)

		when:
			editedColDesc.value("Used for testing hey")
			editedColEuropeanaName.value("Europeana name there")
			exposeThroughOAI.value("false")
			exposeChildOAI.value("false")
			exposeDataProvOAI.value("false")
			childInSearch.value("false")
			dataProvInSearch.value("false")
			exposeToEuropeana.value("false")
			collDetailsSubmit.click(CollectionEdit)
		then:
			editedColDesc.value()=="Used for testing hey"
			editedColEuropeanaName.value()=="Europeana name there"
			exposeThroughOAI.value()=="false"
			exposeChildOAI.value()=="false"
			exposeDataProvOAI.value()=="false"
			childInSearch.value()=="false"
			dataProvInSearch.value()=="false"
			exposeToEuropeana.value()=="false"

		editedColEuropeanaName.value("Europeana name here")
		editedColDesc.value("Used for testing")
		exposeThroughOAI.value("true")
		exposeChildOAI.value("true")
		exposeDataProvOAI.value("true")
		childInSearch.value("true")
		dataProvInSearch.value("true")
		exposeToEuropeana.value("true")
		collDetailsSubmit.click(CollectionEdit)

	}

	def "Add_Remove Alt identifier"() {
		when:
			menu.collection.click(CollectionSearch)
			searchCol(Data.TESTING_COLLECTION)
			viewCollection(Data.TESTING_COLLECTION)
			editColButton.click(CollectionEdit)
			addNewAltIdentifier("newIdentifier",CollectionEdit)

		then:
			existingAltIdent("\"newIdentifier\"").isEmpty() == false


		when:
			withConfirm {removeAltIdent("\"newIdentifier\"",CollectionEdit)}

		then:
			existingAltIdent("\"newIdentifier\"").isEmpty()
	}

	def "Test Europeana Validation links"() {
		when:
			menu.collection.click(CollectionSearch)
			searchCol(Data.TESTING_COLLECTION)
			viewCollection(Data.TESTING_COLLECTION)
			editColButton.click(CollectionEdit)
			revalidateInvalidRecords.click()
		then:
			at CollectionEdit
		when:
			revalidateCollectionRecords.click()
		then:
			at CollectionEdit

		when:
			retryEDM.click()
		then:
			at CollectionEdit
		when:
			convertToEDM.click()
		then:
			at CollectionEdit		
	}



}
