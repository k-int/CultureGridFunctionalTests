package com.k_int.cultureGrid.User;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.User.Pages.UserDetails;
import com.k_int.cultureGrid.User.Pages.UserHome;

@Stepwise
class UserSpec extends GebReportingSpec {

	def FUNC_TEST_1_ID = "_functestUser1_"
	def FUNC_TEST_1_EMAIL = "email@func1User"
	def FUNC_TEST_1_EDITED_EMAIL = "edit@func1User"
	def FUNC_TEST_1_EDITED_NAME = "**Edited Functional TestUser 1**"
	def FUNC_TEST_1_EDITED_PASSWORD = "Password1"
	def FUNC_TEST_1_NAME = "**Functional TestUser 1**"
	def FUNC_TEST_1_PASSWORD = "password"
	def FUNC_TEST_1_PASSWORD_CONFIRM = "password"
		
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
				createSelect(FUNC_TEST_1_ID, FUNC_TEST_1_NAME, FUNC_TEST_1_PASSWORD, FUNC_TEST_1_PASSWORD_CONFIRM, FUNC_TEST_1_EMAIL)
		and:
			at UserDetails
			checkId(FUNC_TEST_1_ID)
			updateDetails(FUNC_TEST_1_EDITED_NAME, FUNC_TEST_1_EDITED_EMAIL, FUNC_TEST_1_EDITED_PASSWORD, FUNC_TEST_1_EDITED_PASSWORD)
		and:
			at UserDetails
			verifyDetails(FUNC_TEST_1_ID, FUNC_TEST_1_EDITED_NAME, FUNC_TEST_1_EDITED_EMAIL)
	}
}
