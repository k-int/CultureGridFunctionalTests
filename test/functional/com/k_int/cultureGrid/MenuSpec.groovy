package com.k_int.cultureGrid;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.Pages.*

@Stepwise
class MenuSpec extends GebReportingSpec {

	def "Provider list displays"() {
		given:
			to HomePageLoggedIn
		expect:
			at HomePageLoggedIn
			menu.dataPush.click();
		waitFor {at DataPush}
			menu.depositor.click();
		waitFor {at DepositorHome}
			menu.editor.click();
		waitFor {at Editor}
			menu.mediaFormats.click();
		waitFor {at MediaFormats}
			menu.oai.click();
		waitFor {at OAIAdministration}
			menu.privilege.click();
		waitFor {at PrivilegeAdministration}
			menu.provider.click();
		waitFor {at ProviderPage}
			menu.reports.click();
		waitFor {at Reports}
			menu.update.click();
		waitFor {at UpdateRequestAdministration}
			menu.upload.click();
		waitFor {at Upload}
			menu.user.click();
		waitFor {at UserAdministration}
	}
}
