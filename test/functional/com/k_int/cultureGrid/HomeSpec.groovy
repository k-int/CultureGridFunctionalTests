package com.k_int.cultureGrid

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Pages.Home.NotLoggedInHome;

@Stepwise
class HomeSpec extends GebReportingSpec {
    def "Home page displays"() {
		given:
			to NotLoggedInHome
		expect:
			at NotLoggedInHome	
	}
}
