package com.smartfren.DB

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.sql.*;
import groovy.sql.Sql
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable

public class DBUtility {

	private DBDetails
	private queryResult
	private sql
	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */
	@Keyword
	def connectDB(){
		switch (DBDetails.driver){
			case "com.mysql.jdbc.Driver":
				sql = Sql.newInstance('jdbc:mysql://'+DBDetails.get('host')+':'+DBDetails.get('port')+'/'+DBDetails.get('dbName'),
				DBDetails.get('user'), DBDetails.get('password'), DBDetails.get('driver'))
				break
			case "org.postgresql.Driver":
				sql = Sql.newInstance('jdbc:postgresql://'+DBDetails.get('host')+':'+DBDetails.get('port')+'/'+DBDetails.get('dbName')+'?currentSchema='+DBDetails.get('schema'),
				DBDetails.get('user'), DBDetails.get('password'), DBDetails.get('driver'))
				break
		}
	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	//Executing the constructed Query and Saving results in resultset
	@Keyword
	def executeQueryAndDisplay (String queryString) {
		KeywordUtil.logInfo('  RESULT OF QUERY  --> ' + queryString + '\n')
		KeywordUtil.logInfo('-' * 40)
		sql.eachRow(queryString) { resultSet ->
			def meta = resultSet.getMetaData()
			if (meta.columnCount <= 0) return
				for (i in 0..<meta.columnCount) {
					KeywordUtil.logInfo(meta.getColumnLabel(i + 1)+' :' + ' ' + resultSet[i]?.toString() +'\n')
				}
			KeywordUtil.logInfo('-' * 40)
		}

	}

	@Keyword
	def queryDB(String DB, String query){
		setDBDetails(DB)
		connectDB ()
		queryResult = executeQuery (query)
		closeDBConnection()
		return queryResult
	}

	@Keyword
	def displayQueryResult(String DB, String query){
		setDBDetails(DB)
		connectDB ()
		executeQueryAndDisplay (query)
		closeDBConnection()
	}

	def setDBDetails (String DB){
		switch (DB){
			case "PopQuizDB":
				DBDetails  = GlobalVariable.PopQuizDB
				break
			case "SmartPoinDB":
				DBDetails = GlobalVariable.SmartPoinDB
				break
		}
	}

	@Keyword
	def executeQuery (String query) {

		def results = []
		sql.eachRow(query) {
			results << it.toRowResult()
		}
		println results
		return results
		/*sql.query(queryString) { queryResult ->
		 while (queryResult.next()) {
		 }
		 }*/
	}
	@Keyword
	def closeDBConnection(){
		if (sql != null){
			sql.close()
		}
		sql = null
	}
	@Keyword
	def executeUpdateQuery (String DB,String query){
		setDBDetails(DB)
		connectDB ()
		sql.execute(query)
		closeDBConnection()
	}
}
