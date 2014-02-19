package com.k_int.cultureGrid.data

class Data {
	
	// Predefined data for testing the user pages
	static def USER_TEST_1_ID = "_functestUser1_"
	static def USER_TEST_1_EMAIL = "email@func1User"
	static def USER_TEST_1_EDITED_EMAIL = "edit@func1User"
	static def USER_TEST_1_EDITED_NAME = "**Edited Functional TestUser 1**"
	static def USER_TEST_1_EDITED_PASSWORD = "Password1"
	static def USER_TEST_1_NAME = "**Functional TestUser 1**"
	static def USER_TEST_1_PASSWORD = "password"
	static def USER_TEST_1_PASSWORD_CONFIRM = "password"

	// Predefined data used for the testing the provider pages
	
	static def PROVIDER_TEST_1_COLLECTION = "Chas"
	static def PROVIDER_TEST_1_EDITED_NAME = "**Edited Functional Test 1**"
	static def PROVIDER_TEST_1_EMAIL = "email@func1a"
	static def PROVIDER_TEST_1_EUROPEANA_ID = "func1EuropeanaId"
	static def PROVIDER_TEST_1_EUROPEANA_NAME = "func1EuropeanaName"
	static def PROVIDER_TEST_1_ID = "_functest1_"
	static def PROVIDER_TEST_1_MEDIA_PATH = "/func1/media/store/path"
	static def PROVIDER_TEST_1_NAME = "**Functional Test 1**"

	// Variables used for CollectionsSpec test

	static def TESTING_COLLECTION = "FunctionalTest"
	static def TESTING_COLLECTION_USER = "ACCES"
	static def TESTING_COLLECTION_CHILD = "Collection-639"


	//Variables used for Media Format tests

	static def MEDIA_FORMAT_NAME= "Small"
	static def MEDIA_FORMAT_PROVIDER_CODE = PROVIDER_TEST_1_COLLECTION
	static def MEDIA_ARTIFACT_NAME = "small"
}
