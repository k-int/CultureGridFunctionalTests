package com.k_int.cultureGrid.Upload.Pages

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource

import com.k_int.cultureGrid.data.Data
import com.k_int.cultureGrid.Generic.BasePage

class UploadHome extends BasePage {
	static url = "media/mediaUpload"
	static at = {title.endsWith("Upload")};
	
	static def getFilePath(fileName) {
		def filePath = null;
		if (fileName != null) {
			// The files we use for testing live in the test/functional/resources directory, so ...
			Resource resource = new ClassPathResource(Data.UPLOAD_DIRECTORY + fileName)
			def file = resource.getFile()
			filePath = file.getCanonicalPath()
		}
		return(filePath)
	}
	
	static def createFieldMap(metadataFile, mediaFile, storeLocation) {
		return(["recordFile" : metadataFile,
				"mediaFile" : mediaFile,
				"storeLocation" : storeLocation])
	}

	static def createSelectMap(collectionId, providerId) {
		return(["collectionIdent" : collectionId,
			    "providerIdent" : providerId])
	}

	static content = {
		
		successful {numberOfRecords ->
			$("p", text: contains(numberOfRecords + " records were successfully"))
		}
		processFiles {collectionId, providerId, files ->
			files.each() {fileObject ->
				updateDetailsBase(createFieldMap(getFilePath(fileObject.get(Data.UPLOAD_FILENAME)),
												 getFilePath(fileObject.get(Data.UPLOAD_MEDIA_FILE)), null),
								  createSelectMap(collectionId, providerId), "submit_files", true)
				successful(fileObject.get(Data.UPLOAD_NUMBER_RECORDS))
				menu.upload.click(UploadHome)
			}
		}
	}
}
