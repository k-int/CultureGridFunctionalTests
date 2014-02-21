package com.k_int.cultureGrid.MediaFormats;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise

import com.k_int.cultureGrid.data.Data
import com.k_int.cultureGrid.Home.Pages.LoggedInHome;
import com.k_int.cultureGrid.MediaFormats.Pages.*
import com.k_int.cultureGrid.Provider.Pages.*


@Stepwise
class MediaSpec extends GebReportingSpec {

	def "Media formats display"() {
		given:			
			to LoggedInHome
		expect:
			menu.mediaFormats.click(MediaFormatsHome);			
	}

	def "Create format"() {
		given:
			at MediaFormatsHome

		createNewFormat.click(EditCreateMediaFormat)
		when:
			formatTitle(Data.MEDIA_FORMAT_NAME)
			submit.click(MediaFormatsHome)
		then:
			selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)			
	}
 
 	def "Create with existing name"() {
		given:
			menu.mediaFormats.click(MediaFormatsHome);			

		createNewFormat.click(EditCreateMediaFormat)
		when:
			formatTitle(Data.MEDIA_FORMAT_NAME)
			submit.click()
				
		then:
			editError.isEmpty() == false
			
		menu.mediaFormats.click(MediaFormatsHome);			
		selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)			
	}

	def "Apply format to provider"() {
		given:
			at EditCreateMediaFormat 

		when:
			applyTo(Data.MEDIA_FORMAT_PROVIDER_CODE)
			submit.click()
		then:
			at MediaFormatsHome

		when:
			selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)	
		then:
			providerList(Data.PROVIDER_GENERAL_NAME).size() == 1	
			removeFrom(Data.MEDIA_FORMAT_PROVIDER_CODE).isEmpty() == false
		
		when:
			applyTo(Data.MEDIA_FORMAT_PROVIDER_CODE).isEmpty()	
		then:
			thrown(java.lang.IllegalArgumentException)
	}

	def "Delete  link removed "() {
		given:
			at EditCreateMediaFormat
		expect:
			deleteFormat.isEmpty()
	}

	def "Remove format from provider"() {
		given:
			at EditCreateMediaFormat
		when:
			removeFrom(Data.MEDIA_FORMAT_PROVIDER_CODE)
			submit.click(MediaFormatsHome)	
			selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)	
		then:
			applyTo(Data.MEDIA_FORMAT_PROVIDER_CODE).isEmpty() == false

		when:
			removeFrom(Data.MEDIA_FORMAT_PROVIDER_CODE)
		then:
			thrown(java.lang.IllegalArgumentException)
		when:
			providerList(Data.MEDIA_FORMAT_PROVIDER_CODE)
		then:
			thrown(geb.error.RequiredPageContentNotPresent)
	}

	def "Rename format"() {
		given:
			menu.mediaFormats.click(MediaFormatsHome)
			selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)	
			
		when:
			formatTitle("renamed")
			submit.click(MediaFormatsHome)
		then:
			selectFormat("renamed").click(EditCreateMediaFormat)
			formatTitle(Data.MEDIA_FORMAT_NAME)	
			submit.click(MediaFormatsHome)
	}

	def "View Format Artifacts"() {
		given:
			menu.mediaFormats.click(MediaFormatsHome)
		when:
			selectFormatArtifact(Data.MEDIA_FORMAT_NAME).click()	
		then:
			at ListArtifacts		
	}

	def "Add new Artifact"() {
		given:
			at ListArtifacts
		when:
			addNewArtifact.click()
		then:
			at EditCreateArtifact

		when:
			updateDetails(Data.MEDIA_ARTIFACT_NAME,"100","100","true","jpg","10","5","20","30","SMALL_IMAGE")
			saveArtifact.click(ListArtifacts)
		then:
			editArtifact(Data.MEDIA_ARTIFACT_NAME).click(EditCreateArtifact)
			verifyDetails(Data.MEDIA_ARTIFACT_NAME,"100","100","true","jpg","10","5","20","30","SMALL_IMAGE")
	}


	def "Delete Artifact"() {
		given:
			at EditCreateArtifact
		when:
			withConfirm { deleteArtifact.click() }
		then:
			at ListArtifacts
			editArtifact(Data.MEDIA_ARTIFACT_NAME).isEmpty()
	}

	def "Invalid artifact values"() {
		given:
			at ListArtifacts
			addNewArtifact.click(EditCreateArtifact)
		when:
			updateDetails(Data.MEDIA_ARTIFACT_NAME,"-50","100","true","jpg","10","5","20","30","SMALL_IMAGE")
			saveArtifact.click()
		then:
			errorMessage.size() != 0 

	}

	def "Delete Format"(){
		given:
			menu.mediaFormats.click(MediaFormatsHome)
			selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)			
		when:
			withConfirm { deleteFormat.click(MediaFormatsHome) }
			selectFormat(Data.MEDIA_FORMAT_NAME).click(EditCreateMediaFormat)			
		then:
			thrown(geb.error.RequiredPageContentNotPresent)

	}
}
