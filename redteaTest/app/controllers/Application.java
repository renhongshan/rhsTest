package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;

import models.User;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("Your new application is ready.");
    }  
    
    //HelloWorld接口
    public static Result helloWorld() {
        return ok("Hello World");
    }  
    
    //User接口
    public static Result userRegister() {
    	//获取post请求中的json数据
    	JsonNode json = request().body().asJson();
    	
        if(json == null) {
            return badRequest("Expecting Json data(json is null)");
        } else {
        	//打印接收到的json数据
            System.out.println(json);
            
            //解释收到的json数据
            String un=json.findPath("username").textValue();
            String fn=json.findPath("firstname").textValue();
            String ln=json.findPath("lastname").textValue();
            String addr=json.findPath("address").textValue();
            
            //创建一个User对象
            User user=new User(un, fn, ln, addr);
            
            //保存到数据库
            try {
            	user.save();
            	return ok("ok");
			} catch (Exception e) {
				return ok(e.getMessage());
			}
            
            
            
        }
    }

}
