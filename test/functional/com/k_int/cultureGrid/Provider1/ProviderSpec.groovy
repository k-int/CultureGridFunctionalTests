package com.k_int.cultureGrid.Provider1;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.provider.Pages.ProviderHome;

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
