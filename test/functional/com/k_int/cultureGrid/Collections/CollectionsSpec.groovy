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
		searchCol(Data.COLLECTION_TEST_ID)
		then:
		at CollectionSearch

	}

	def "View Collection"() {
		when:
			at CollectionSearch
			viewCollection(Data.COLLECTION_TEST_ID)
		then:
			at CollectionDetails

	}

	def "Access Edit collection" (){
		when:
			menu.collection.click(CollectionSearch);
			searchCol(Data.COLLECTION_TEST_ID)
			viewCollection(Data.COLLECTION_TEST_ID)
		then:
			at CollectionDetails

		editColButton.click(CollectionEdit)

	}
	
	def "Authorize/Remove User"(){
			menu.collection.click(CollectionSearch)
			searchCol(Data.COLLECTION_TEST_ID)
			viewCollection(Data.COLLECTION_TEST_ID)
			editColButton.click(CollectionEdit)
		when:
			authorizeNewUser(Data.USER_GENERAL_ID)
		then:
			authorizedUser(Data.USER_GENERAL_ID).isEmpty() == false

		when:
			removeAuthorizedUser(Data.USER_GENERAL_ID)
		then:
			authorizedUser(Data.USER_GENERAL_ID).isEmpty()
	}

	def "Add_Remove Child Collection"() {
		at CollectionEdit
		when:
			addCollectionChild(Data.COLLECTION_TEST_CHILD_ID)
		then:
			children_colls(Data.COLLECTION_TEST_CHILD_ID).isEmpty() == false
			withConfirm { removeChildCol(Data.COLLECTION_TEST_CHILD_ID)}
			children_colls(Data.COLLECTION_TEST_CHILD_ID).isEmpty()
	}

	def "Edit Collection Details"() {
		when:
			menu.collection.click(CollectionSearch)
			searchCol(Data.COLLECTION_TEST_ID)
			viewCollection(Data.COLLECTION_TEST_ID)
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
			searchCol(Data.COLLECTION_TEST_ID)
			viewCollection(Data.COLLECTION_TEST_ID)
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
			searchCol(Data.COLLECTION_TEST_ID)
			viewCollection(Data.COLLECTION_TEST_ID)
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
