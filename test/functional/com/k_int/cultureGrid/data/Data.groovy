package com.k_int.cultureGrid.data

class Data {
	// To use for some of the true / false combos
	static def FALSE = "false"
	static def TRUE  = "true"
	
	// Predefined data for testing the user pages
	static def USER_TEST_1_EMAIL = "email@func1User"
	static def USER_TEST_1_EDITED_EMAIL = "edit@func1User"
	static def USER_TEST_1_EDITED_NAME = "**Edited Functional TestUser 1**"
	static def USER_TEST_1_EDITED_PASSWORD = "Password1"
	static def USER_TEST_1_ID = "_functestUser1_"
	static def USER_TEST_1_NAME = "**Functional TestUser 1**"
	static def USER_TEST_1_PASSWORD = "password"
	static def USER_TEST_1_PASSWORD_CONFIRM = "password"

	// The permanent user that will be generally used, so should not be deleted
	static def USER_GENERAL_EMAIL = "functestGeneralUser@k-int.com"
	static def USER_GENERAL_ID = "_functestGeneralUser_"
	static def USER_GENERAL_NAME = "**Functional Test General User**"
	static def USER_GENERAL_PASSWORD = "GeneralUser"

	// The permanent provider that will be generally used for testing, so should not be deleted
	static def PROVIDER_TEST_1_COLLECTION = "Chas"
	static def PROVIDER_TEST_1_EDITED_NAME = "**Edited Functional Test 1**"
	static def PROVIDER_TEST_1_EMAIL = "email@func1a"
	static def PROVIDER_TEST_1_EUROPEANA_ID = "func1EuropeanaId"
	static def PROVIDER_TEST_1_EUROPEANA_NAME = "func1EuropeanaName"
	static def PROVIDER_TEST_1_ID = "_functest1_"
	static def PROVIDER_TEST_1_MEDIA_PATH = "/func1/media/store/path"
	static def PROVIDER_TEST_1_NAME = "**Functional Test 1**"

	// Predefined data used for the testing the provider pages
	static def PROVIDER_GENERAL_EMAIL = "functestGeneralProvider@k-int.com"
	static def PROVIDER_GENERAL_ID = "_functestGeneralProvider_"
	static def PROVIDER_GENERAL_MEDIA_PATH = "funcTestGeneralProvider"
	static def PROVIDER_GENERAL_NAME = "**Functional Test General Provider**"

	// Variables used for CollectionsSpec test
	static def TESTING_COLLECTION = "FunctionalTest"
	static def TESTING_COLLECTION_USER = "ACCES"
	static def TESTING_COLLECTION_CHILD = "Collection-639"
	
	//  The permanent collection that will be generally used for testing, so should not be deleted
	static def COLLECTION_TEST_ID = "_functestGeneralCollection_"
	static def COLLECTION_TEST_NAME = "**Functional Test General Collection**"
	static def COLLECTION_TEST_PARENT_COLLECTION = "PN"
	static def COLLECTION_TYPE_ITEM = "Item"

	//Variables used for Media Format tests
	static def MEDIA_FORMAT_NAME= "Small"
	static def MEDIA_FORMAT_PROVIDER_CODE = PROVIDER_TEST_1_COLLECTION
	static def MEDIA_ARTIFACT_NAME = "small"
	
	// files that we use for the data upload
	// Are an array of a map defining the filename(s) and how many records we expect
	static def UPLOAD_FILENAME = "filename"
	static def UPLOAD_NUMBER_RECORDS = "numberOfRecords"
	static def UPLOAD_MEDIA_FILE = "mediaFilename"
	static def UPLOAD_DIRECTORY = "resources/"
	
	static def UPLOAD_FILES = []
	
	static {
		// As the keys are static variables, we need to create the file map array this way
		// Single Lido record
		def fileMap = [ : ]
		fileMap.put(UPLOAD_FILENAME, "LIDO-Single.xml")
		fileMap.put(UPLOAD_NUMBER_RECORDS, 1)
	 	UPLOAD_FILES.add(fileMap)
		 
	 	// Multiple Lido records in one file
		fileMap = [ : ]
	 	fileMap.put(UPLOAD_FILENAME, "LIDO-Multiple.xml")
		fileMap.put(UPLOAD_NUMBER_RECORDS, 2)
	 	UPLOAD_FILES.add(fileMap)
	 
	 	// Single Lido file in zip file
		 // There is a bug so this dosn't work at the moment
//		fileMap = [ : ]
//	 	fileMap.put(UPLOAD_FILENAME, "LIDO-Single.zip")
//		fileMap.put(UPLOAD_NUMBER_RECORDS, 1)
//	 	UPLOAD_FILES.add(fileMap)
	 
	 	// Multiple Lido files in zip file
		fileMap = [ : ]
	 	fileMap.put(UPLOAD_FILENAME, "LIDO-Multiple.zip")
		fileMap.put(UPLOAD_NUMBER_RECORDS, 3)
	 	UPLOAD_FILES.add(fileMap)
	 
	 	// Records in spreadsheet
		fileMap = [ : ]
	 	fileMap.put(UPLOAD_FILENAME, "Spreadsheet.xls")
		fileMap.put(UPLOAD_NUMBER_RECORDS, 4)
	 	UPLOAD_FILES.add(fileMap)
	 
	 	// Records in zipped spreadsheet
		fileMap = [ : ]
	 	fileMap.put(UPLOAD_FILENAME, "Spreadsheet.zip")
		fileMap.put(UPLOAD_NUMBER_RECORDS, 5)
	 	UPLOAD_FILES.add(fileMap)
	 
	 	// Spreadsheet that refers to media files
		fileMap = [ : ]
	 	fileMap.put(UPLOAD_FILENAME, "SpreadsheetMedia.zip")
		fileMap.put(UPLOAD_NUMBER_RECORDS, 6)
		fileMap.put(UPLOAD_MEDIA_FILE, "SpreadsheetMediaImages.zip")
	 	UPLOAD_FILES.add(fileMap)
	}
}
