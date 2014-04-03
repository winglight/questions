package cc.test.service;

import java.util.Date;

import cc.test.common.DateFormatCovert;
import cc.test.model.ResultModel;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class TestResultService {
	private static TestResultService testResultService;
	
	public static TestResultService getIntance(){
		if(testResultService==null){
			testResultService=new TestResultService();
		}
		return testResultService;
	}
	
	//新增一个user实体
	public void insertTestResult(ResultModel result){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Entity entity = new Entity("TestResult");
		entity.setProperty(ResultModel.EMAIL, result.getEmail());
		entity.setProperty(ResultModel.QUESTION_ANSWER_CODES, result.getQuestionAnswerCodes());
		entity.setProperty(ResultModel.QUESTION_CODES, result.getQuestionCodes());
		entity.setProperty(ResultModel.RITHT_PERCENT, result.getRightPercent());
		entity.setProperty(ResultModel.SUBMIT_TIME, DateFormatCovert.dateTiemFormat(new Date()));
		
		datastore.put(entity);
	}
}
