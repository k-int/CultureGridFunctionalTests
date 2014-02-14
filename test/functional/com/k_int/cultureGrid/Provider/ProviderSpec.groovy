package com.k_int.cultureGrid.Provider;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.Provider.Pages.ProviderDetails;
import com.k_int.cultureGrid.Provider.Pages.ProviderHome;

@Stepwise
class ProviderSpec extends GebReportingSpec {

	def FUNC_TEST_1_ID = "_functest1_"
	def FUNC_TEST_1_EMAIL = "email@func1a"
	def FUNC_TEST_1_EUROPEANA_ID = "func1EuropeanaId"
	def FUNC_TEST_1_EUROPEANA_NAME = "func1EuropeanaName"
	def FUNC_TEST_1_MEDIA_PATH = "/func1/media/store/path"
	def FUNC_TEST_1_EDITED_NAME = "**Edited Functional Test 1**"
	def FUNC_TEST_1_NAME = "**Functional Test 1**"
	
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
			createOrSelect(FUNC_TEST_1_ID, FUNC_TEST_1_NAME)
		and:
			at ProviderDetails
			checkId(FUNC_TEST_1_ID)
			updateDetails(FUNC_TEST_1_EMAIL, FUNC_TEST_1_EUROPEANA_ID, FUNC_TEST_1_EUROPEANA_NAME, FUNC_TEST_1_MEDIA_PATH, FUNC_TEST_1_EDITED_NAME)
		and:
			at ProviderDetails
			verifyDetails(FUNC_TEST_1_ID, FUNC_TEST_1_EMAIL, FUNC_TEST_1_EUROPEANA_ID, FUNC_TEST_1_EUROPEANA_NAME, FUNC_TEST_1_MEDIA_PATH, FUNC_TEST_1_EDITED_NAME)
	}
}
