package com.k_int.cultureGrid.Provider;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.data.Data
import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.Provider.Pages.ProviderDetails;
import com.k_int.cultureGrid.Provider.Pages.ProviderHome;

@Stepwise
class ProviderSpec extends GebReportingSpec {

	def "Provider list display"() {
		given:
			to LoggedInHome
		expect:
			at LoggedInHome
			menu.provider.click();
			
		// May take a while to display, so we will give it at least 30 seconds to display
		waitFor 30D, {at ProviderHome}
	}
	
	def "Provider Edit Func Test 1"() {
		// It appears That we cannot carry on from where the previous test left off
		// except that we are still logged in
		given:
			to ProviderHome
		expect:
			at ProviderHome
			
			// Select our test provider, creating if need be
			createSelect(Data.PROVIDER_TEST_1_ID, Data.PROVIDER_TEST_1_NAME)
		and:
			at ProviderDetails
			checkId(Data.PROVIDER_TEST_1_ID)
			
			// Update the details now
			updateDetails(Data.PROVIDER_TEST_1_EMAIL, Data.PROVIDER_TEST_1_EUROPEANA_ID, Data.PROVIDER_TEST_1_EUROPEANA_NAME, Data.PROVIDER_TEST_1_MEDIA_PATH, Data.PROVIDER_TEST_1_EDITED_NAME)
		and:
			at ProviderDetails
			verifyDetails(Data.PROVIDER_TEST_1_ID, Data.PROVIDER_TEST_1_EMAIL, Data.PROVIDER_TEST_1_EUROPEANA_ID, Data.PROVIDER_TEST_1_EUROPEANA_NAME, Data.PROVIDER_TEST_1_MEDIA_PATH, Data.PROVIDER_TEST_1_EDITED_NAME)
			
			// Associate out test user with this provider
			addUser(Data.USER_TEST_1_ID)
			verifyUser(Data.USER_TEST_1_ID)
			removeUser(Data.USER_TEST_1_ID)
	}
}
