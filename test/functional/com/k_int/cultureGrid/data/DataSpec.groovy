package com.k_int.cultureGrid.data

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

import com.k_int.cultureGrid.Collections.Pages.CollectionDetails
import com.k_int.cultureGrid.Collections.Pages.CollectionEdit
import com.k_int.cultureGrid.Collections.Pages.CollectionSearch
import com.k_int.cultureGrid.Home.Pages.LoggedInHome
import com.k_int.cultureGrid.Provider.Pages.ProviderDetails
import com.k_int.cultureGrid.Provider.Pages.ProviderHome
import com.k_int.cultureGrid.User.Pages.UserHome

@Stepwise
class DataSpec extends GebReportingSpec {
	
	def "Setup Test Data"() {
		given:
			to LoggedInHome
		expect:
			at LoggedInHome
			menu.user.click();

		and:			
			at UserHome
			
			// Create the user that various tests are going to use
			createSelect(Data.USER_GENERAL_ID, Data.USER_GENERAL_NAME, Data.USER_GENERAL_PASSWORD, Data.USER_GENERAL_PASSWORD, Data.USER_GENERAL_EMAIL)
			menu.collection.click();

		and:
			at CollectionSearch
			
			// Create the collection that various tests are going to use
			if (createIfNotExists(Data.COLLECTION_TEST_ID)) {
				waitFor {at CollectionEdit}
				create(Data.COLLECTION_TEST_ID, Data.COLLECTION_TEST_NAME, Data.COLLECTION_TEST_NAME, Data.COLLECTION_TEST_PARENT_COLLECTION, "",
					   Data.COLLECTION_TYPE_ITEM, Data.TRUE, Data.TRUE, Data.TRUE, Data.TRUE, Data.TRUE, Data.TRUE)
			} else {
				// Delete all the records
				select(Data.COLLECTION_TEST_ID, CollectionDetails)
				editColButton.click(CollectionEdit)
				withConfirm {deleteRecords.click()}
			}			

			menu.provider.click();
			
		and:
			at ProviderHome
			createSelect(Data.PROVIDER_GENERAL_ID, Data.PROVIDER_GENERAL_NAME);
			
		and:
			at ProviderDetails
			addUser(Data.USER_GENERAL_ID)
			addCollection(Data.COLLECTION_TEST_ID)
			updateDetails(null, null, null, Data.PROVIDER_GENERAL_MEDIA_PATH, null, Data.TRUE)
			
	}
}
