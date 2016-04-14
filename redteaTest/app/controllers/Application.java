package controllers;

import com.fasterxml.jackson.databind.JsonNode;

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
            return ok("ok");
        }
    }

}
