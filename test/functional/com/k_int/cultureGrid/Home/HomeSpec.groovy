package com.k_int.cultureGrid.Home

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Home.Pages.NotLoggedInHome;

@Stepwise
class HomeSpec extends GebReportingSpec {
    def "Home page displays"() {
		given:
			to NotLoggedInHome
		expect:
			at NotLoggedInHome	
	}
}
