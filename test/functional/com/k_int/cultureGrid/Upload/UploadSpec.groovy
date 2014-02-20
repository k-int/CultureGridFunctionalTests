package com.k_int.cultureGrid.Upload

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise;

import com.k_int.cultureGrid.data.Data
import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.Upload.Pages.UploadHome;

@Stepwise
class UploadSpec extends GebReportingSpec {

	def "Media Upload"() {
		given:
			to LoggedInHome
		expect:
			at LoggedInHome
			menu.upload.click()

		and:			
			waitFor {at UploadHome}
			processFiles(Data.COLLECTION_TEST_ID, Data.PROVIDER_GENERAL_ID, Data.UPLOAD_FILES)
	}
}
