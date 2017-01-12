package com.flyinghero.webtest;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




/**
 * 
 * @author zhanghua
 * 
 */

// @Path here defines class level path. Identifies the URI path that 
// a resource class will serve requests for.
@Path("/")
public class AppVersionCheck {

	
	//当前最新版本code
	private int mCurrent_version_code = 9;
	//当前最新版本号
	private String mCurrent_version_name = "1.0.1";
	//更新修复内容
	private String mUpdateInfos = "[{\"update_info\":\"1.用户协议说明修复\"},{\"update_info\":\"2.优化多余的请求\"}]";
	private String mDownloadUrl = "http://120.24.19.185:8099/app/android/base/baochefei_version/bcf_Andriod.apk";
	
	 // @GET here defines, this method will method will process HTTP GET
	 // requests.
	 @GET
	 @Path("/")
	 // @Path here defines method level path. Identifies the URI path that a
	 // resource class method will serve requests for.
	 // @Produces here defines the media type(s) that the methods
	 // of a resource class can produce.
	 @Produces("application/json;charset=UTF-8")
	 // @PathParam injects the value of URI parameter that defined in @Path
	 // expression, into the method.@PathParam("i") String i
	 public String checkAppVersion(@QueryParam("version_code") int version_code,@QueryParam("version_name") String version_name,@QueryParam("phone_os") int phone_os) {
		 
		 String str = "{\"update_flag\":" + false + "}";
		 if(phone_os == 1){
			 //1为Android机型
			 if(mCurrent_version_name.equals(version_name) == false&&version_code < mCurrent_version_code){
				 str = "{\"update_flag\":" + true + ",\"new_version_code\":" + mCurrent_version_code + ",\"new_version_name\":" + mCurrent_version_name + ",\"update_infos\":" + mUpdateInfos +  ",\"download_url\":\"" + mDownloadUrl +"\"}";
			 }
		 }else if(phone_os == 2){
			 //2为iphone机型
			 
		 }else{
			 
		 }
		 return str;
		 
	 }
}
