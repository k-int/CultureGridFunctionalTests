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

			Data.COLLECTIONS.each() {collection ->			
				menu.collection.click();
				
				and:
					at CollectionSearch
					// Create the parent collections that various tests are going to use
					if (createIfNotExists(collection.get(Data.COLLECTION_ID))) {
						waitFor {at CollectionEdit}
						create(collection.get(Data.COLLECTION_ID), collection.get(Data.COLLECTION_NAME), collection.get(Data.COLLECTION_NAME), collection.get(Data.COLLECTION_PARENT), "",
							   collection.get(Data.COLLECTION_TYPE), Data.TRUE, Data.TRUE, Data.TRUE, Data.TRUE, Data.TRUE, Data.TRUE)
					} else {
						// Delete all the records
						select(collection.get(Data.COLLECTION_ID), CollectionDetails)
						editColButton.click(CollectionEdit)
						withConfirm {deleteRecords.click()}
					}
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
