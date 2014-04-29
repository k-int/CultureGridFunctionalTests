

/*
	This is the Geb configuration file.
 
 	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.firefox.FirefoxDriver
//import org.openqa.selenium.chrome.ChromeDriver
//import org.openqa.selenium.ie.InternetExplorerDriver

atCheckWaiting = true
//baseUrl = 'http://testing.culturegrid.org.uk/dpp/'
baseUrl = 'http://cgautodeploy.k-int.co.uk/dpp/user'
driver = { new FirefoxDriver() }

environments {

	// run as “grails -Dgeb.env=chrome test-app”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
//	chrome {
//		driver = { new ChromeDriver() }
//	}

	// run as “grails -Dgeb.env=firefox test-app”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

	// run as “grails -Dgeb.env=ie test-app”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
//	ie {
//		driver = { new InternetExplorerDriver() }
//	}
}
