package cc.test.service;

import cc.test.model.UserModel;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class UserService {
	private static UserService userService;
	
	public static UserService getIntance(){
		if(userService==null){
			userService=new UserService();
		}
		return userService;
	}
	
	//新增一个user实体
	public void insertUser(UserModel user){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Entity entity = new Entity("Users");
		entity.setProperty(UserModel.EMAIL, user.getEmail());
		entity.setProperty(UserModel.ANDROID_SID, user.getAndroid_sid());
		entity.setProperty(UserModel.CIUDAD, user.getCiudad());
		entity.setProperty(UserModel.COLEGIO, user.getColegio());
		entity.setProperty(UserModel.REGION, user.getRegion());
		entity.setProperty(UserModel.RUT, user.getRut());
		
		datastore.put(entity);
	}
}
