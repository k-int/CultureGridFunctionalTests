package com.k_int.cultureGrid;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Pages.HomePageLoggedIn
import com.k_int.cultureGrid.Pages.ProviderPage

@Stepwise
class ProviderSpec extends GebReportingSpec {

	def "Provider list displays"() {
		given:
			to HomePageLoggedIn
		expect:
			at HomePageLoggedIn
			menu.provider.click();
		waitFor {at ProviderPage}
			select("Aberdeen")
	}
}
