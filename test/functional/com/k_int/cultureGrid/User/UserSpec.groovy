package com.k_int.cultureGrid.User;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.data.Data
import com.k_int.cultureGrid.Home.Pages.LoggedInHome
import com.k_int.cultureGrid.User.Pages.UserDetails
import com.k_int.cultureGrid.User.Pages.UserHome

@Stepwise
class UserSpec extends GebReportingSpec {

	def "User list display"() {
		given:
			to LoggedInHome
		expect:
			at LoggedInHome
			menu.user.click();
			
		waitFor {at UserHome}
	}
	
	def "User Edit Func Test 1"() {
		// It appears That we cannot carry on from where the previous test left off
		// except that we are still logged in
		given:
			to UserHome
		expect:
			at UserHome
				createSelect(Data.USER_TEST_1_ID, Data.USER_TEST_1_NAME, Data.USER_TEST_1_PASSWORD, Data.USER_TEST_1_PASSWORD_CONFIRM,  Data.USER_TEST_1_EMAIL)
		and:
			at UserDetails
			checkId(Data.USER_TEST_1_ID)
			updateDetails( Data.USER_TEST_1_EDITED_NAME,  Data.USER_TEST_1_EDITED_EMAIL,  Data.USER_TEST_1_EDITED_PASSWORD,  Data.USER_TEST_1_EDITED_PASSWORD)
		and:
			at UserDetails
			verifyDetails( Data.USER_TEST_1_ID,  Data.USER_TEST_1_EDITED_NAME,  Data.USER_TEST_1_EDITED_EMAIL)
	}
}
