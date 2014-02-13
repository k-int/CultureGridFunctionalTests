package com.k_int.cultureGrid;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Pages.Home.LoggedInHome;
import com.k_int.cultureGrid.Pages.Provider.ProviderHome;

@Stepwise
class ProviderSpec extends GebReportingSpec {

	def "Provider list displays"() {
		given:
			to LoggedInHome
		expect:
			at LoggedInHome
			menu.provider.click();
		waitFor 30D, {at ProviderHome}
//			select("Aberdeen")
			createOrSelect("_functest1_", "**Functional Test 1**")
	}
}
