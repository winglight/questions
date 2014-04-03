package cc.test.service;

import java.util.List;
import cc.test.model.CodeModel;
import cc.test.model.QuestionModel;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class CodeService {
private static CodeService codeService;
	
	public static CodeService getIntance(){
		if(codeService==null){
			codeService=new CodeService();
		}
		return codeService;
	}
	
	//插入ciudad选项
	public void insertCodeKeyAndValue(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Entity entity1 = new Entity("Code");
		entity1.setProperty(CodeModel.CODE_NO, 1);
		entity1.setProperty(CodeModel.CODE_KEY, "1");
		entity1.setProperty(CodeModel.CODE_VALUE, "zhuhai");
		entity1.setProperty(CodeModel.TYPE, "ciudad");
		datastore.put(entity1);
		
		Entity entity2 = new Entity("Code");
		entity2.setProperty(CodeModel.CODE_NO, 2);
		entity2.setProperty(CodeModel.CODE_KEY, "2");
		entity2.setProperty(CodeModel.CODE_VALUE, "guangzhou");
		entity2.setProperty(CodeModel.TYPE, "ciudad");
		datastore.put(entity2);
		
		Entity entity3 = new Entity("Code");
		entity3.setProperty(CodeModel.CODE_NO, 3);
		entity3.setProperty(CodeModel.CODE_KEY, "3");
		entity3.setProperty(CodeModel.CODE_VALUE, "Los Angeles");
		entity3.setProperty(CodeModel.TYPE, "ciudad");
		datastore.put(entity3);
		
		Entity entity4 = new Entity("Code");
		entity4.setProperty(CodeModel.CODE_NO, 1);
		entity4.setProperty(CodeModel.CODE_KEY, "1");
		entity4.setProperty(CodeModel.CODE_VALUE, "math");
		entity4.setProperty(CodeModel.TYPE, "colegio");
		datastore.put(entity4);
		
		Entity entity5 = new Entity("Code");
		entity5.setProperty(CodeModel.CODE_NO, 2);
		entity5.setProperty(CodeModel.CODE_KEY, "2");
		entity5.setProperty(CodeModel.CODE_VALUE, "chemical industry");
		entity5.setProperty(CodeModel.TYPE, "colegio");
		datastore.put(entity5);
		
		Entity entity6 = new Entity("Code");
		entity6.setProperty(CodeModel.CODE_NO, 3);
		entity6.setProperty(CodeModel.CODE_KEY, "3");
		entity6.setProperty(CodeModel.CODE_VALUE, "literature");
		entity6.setProperty(CodeModel.TYPE, "colegio");
		datastore.put(entity6);
	}
	
	//根据类型查询code表
	public List getCodeByType(String type){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Code");
		PreparedQuery preparedQuery = datastore.prepare(query);
		List list = preparedQuery.asList(FetchOptions.Builder.withDefaults());
		//如果code表没有资料则插入数据
		if(list==null){
			insertCodeKeyAndValue();
		}
		
		//写入查询条件，查询
		query.addFilter(CodeModel.TYPE, Query.FilterOperator.EQUAL, type);
		PreparedQuery preparedCodeByTypeQuery = datastore.prepare(query);
		List codeList=preparedCodeByTypeQuery.asList(FetchOptions.Builder.withDefaults());
		return codeList;
	}
	
	//获取所有code表资料，以json格式返回
	public String getAllCode(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Code");
//		PreparedQuery preparedQuery = datastore.prepare(query);
//		List list = preparedQuery.asList(FetchOptions.Builder.withDefaults());
//		//如果code表没有资料则插入数据
//		if(list==null || list.size()==0){
//			insertCodeKeyAndValue();
//		}
		
		//写入查询条件，查询
		PreparedQuery preparedCodeQuery = datastore.prepare(query);
		List codeList=preparedCodeQuery.asList(FetchOptions.Builder.withDefaults());
		return codeEntityConvertToJson(codeList);
	}
	
	//转换成json格式
	public String codeEntityConvertToJson(List list){
		StringBuffer result=new StringBuffer("{\"code\":[");
		
		for (int i = 0; i < list.size(); i++) {
			Entity entity=(Entity)list.get(i);
			result.append("{");
			result.append("\"codeNo\":"+(Long)entity.getProperty(CodeModel.CODE_NO)+",");
			result.append("\"codeKey\":\""+(String)entity.getProperty(CodeModel.CODE_KEY)+"\",");
			result.append("\"codeValue\":\""+(String)entity.getProperty(CodeModel.CODE_VALUE)+"\",");
			result.append("\"type\":\""+(String)entity.getProperty(CodeModel.TYPE)+"\"");
			result.append("}");
			if(i!=list.size()-1){
				result.append(",");
			}
		}
		result.append("]}");
		return result.toString();
	}
}
