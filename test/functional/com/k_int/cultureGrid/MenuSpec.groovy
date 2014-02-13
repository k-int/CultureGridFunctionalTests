package com.k_int.cultureGrid;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.DataPush.Pages.DataPushHome;
import com.k_int.cultureGrid.Depositor.Pages.DepositorHome;
import com.k_int.cultureGrid.Editor.Pages.EditorHome;
import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.MediaFormats.Pages.MediaFormatsHome;
import com.k_int.cultureGrid.OAI.Pages.OAIHome;
import com.k_int.cultureGrid.Privileges.Pages.PrivilegesHome;
import com.k_int.cultureGrid.Provider.Pages.ProviderHome;
import com.k_int.cultureGrid.Reports.Pages.ReportsHome;
import com.k_int.cultureGrid.UpdateRequest.Pages.UpdateRequestHome;
import com.k_int.cultureGrid.Upload.Pages.UploadHome;
import com.k_int.cultureGrid.User.Pages.UserHome;

@Stepwise
class MenuSpec extends GebReportingSpec {

	def "Provider list displays"() {
		given:
			to LoggedInHome
		expect:
			at LoggedInHome
			menu.dataPush.click();
		waitFor {at DataPushHome}
			menu.depositor.click();
		waitFor {at DepositorHome}
			menu.editor.click();
		waitFor {at EditorHome}
			menu.mediaFormats.click();
		waitFor {at MediaFormatsHome}
			menu.oai.click();
		waitFor {at OAIHome}
			menu.privilege.click();
		waitFor {at PrivilegesHome}
			menu.provider.click();
		waitFor {at ProviderHome}
			menu.reports.click();
		waitFor {at ReportsHome}
			menu.update.click();
		waitFor {at UpdateRequestHome}
			menu.upload.click();
		waitFor {at UploadHome}
			menu.user.click();
		waitFor {at UserHome}
	}
}
