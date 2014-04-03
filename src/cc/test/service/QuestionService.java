package cc.test.service;

import java.util.List;

import cc.test.model.QuestionModel;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

public class QuestionService{
	private static QuestionService questionService;
	
	
	public static QuestionService getIntance(){
		if(questionService==null){
			questionService=new QuestionService();
		}
		return questionService;
	}
	
	//获取数据
	public List getQuestionsBySubject(String subject){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Questions");
		query.addFilter(QuestionModel.SUBJECT, Query.FilterOperator.EQUAL, subject);
		PreparedQuery preparedQuery = datastore.prepare(query);
		List list = preparedQuery.asList(FetchOptions.Builder.withDefaults());
		return list;
	}
	
	//转换成json格式
	public String questionEntityConvertToJson(List list){
		StringBuffer result=new StringBuffer("{\"questions\":[");
		
		for (int i = 0; i < list.size(); i++) {
			Entity entity=(Entity)list.get(i);
			result.append("{");
			result.append("\"code\":"+(Long)entity.getProperty(QuestionModel.CODE)+",");
			result.append("\"question\":\""+(String)entity.getProperty(QuestionModel.QUESTION)+"\",");
			result.append("\"image\":\""+(String)entity.getProperty(QuestionModel.IMAGE)+"\",");
			result.append("\"options\":\""+(String)entity.getProperty(QuestionModel.OPTIONS)+"\",");
			result.append("\"rightAnswer\":"+(Long)entity.getProperty(QuestionModel.RIGHT_ANSWER)+",");
			result.append("\"tips\":\""+(String)entity.getProperty(QuestionModel.TIPS)+"\",");
			result.append("\"typeName\":\""+(String)entity.getProperty(QuestionModel.TYPE_NAME)+"\",");
			result.append("\"typeCode\":\""+(String)entity.getProperty(QuestionModel.TYPE_CODE)+"\",");
			result.append("\"level\":\""+(String)entity.getProperty(QuestionModel.LEVEL)+"\",");
			result.append("\"subject\":\""+(String)entity.getProperty(QuestionModel.SUBJECT)+"\"");
			result.append("}");
			if(i!=list.size()-1){
				result.append(",");
			}
		}
		result.append("],\"lastUpdateCode\":\""+getLastUpdateCode()+"\"}");
		return result.toString();
	}
	
	//获取最新的数据的版本号
	public String getLastUpdateCode(){
		String code="";
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("UpdateHistory");
		query.addSort("LAST_CODE", SortDirection.DESCENDING);
		PreparedQuery preparedQuery = datastore.prepare(query);
		List list = preparedQuery.asList(FetchOptions.Builder.withDefaults());
		if(list!=null && list.size()>0){
			Entity entity=(Entity)list.get(0);
			code=(String)entity.getProperty("LAST_CODE");
		}
		return code;
	}
	
	//更新数据版本号
	public void updateHistoryCode(String hsitoryCode){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity("UpdateHistory");
		entity.setProperty("LAST_CODE", hsitoryCode);
		datastore.put(entity);
	}
	
	//插入一条题目数据到DB
	public void insertQuestion(QuestionModel question){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity("Questions");
		entity.setProperty(QuestionModel.CODE, question.getCode());
		entity.setProperty(QuestionModel.QUESTION, question.getQuestion());
		entity.setProperty(QuestionModel.IMAGE, question.getImage());
		entity.setProperty(QuestionModel.OPTIONS, question.getOptions());
		entity.setProperty(QuestionModel.RIGHT_ANSWER, question.getRightAnswer());
		entity.setProperty(QuestionModel.TIPS, question.getTips());
		entity.setProperty(QuestionModel.TYPE_NAME, question.getTypeName());
		entity.setProperty(QuestionModel.TYPE_CODE, question.getTypeCode());
		entity.setProperty(QuestionModel.LEVEL, question.getLevel());
		entity.setProperty(QuestionModel.SUBJECT, question.getSubject());
		datastore.put(entity);
	}
}