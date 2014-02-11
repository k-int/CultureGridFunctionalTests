package com.k_int.cultureGrid

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Pages.HomePageNotLoggedIn

@Stepwise
class HomeSpec extends GebReportingSpec {
    def "Home page displays"() {
		given:
			to HomePageNotLoggedIn
		expect:
			at HomePageNotLoggedIn	
	}
}
