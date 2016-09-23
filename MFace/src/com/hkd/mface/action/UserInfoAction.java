package com.hkd.mface.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.google.gson.Gson;
import com.hkd.mface.model.UserInfo;

import com.hkd.mface.service.dao.UserInfoServiceDao;
import com.hkd.mface.service.impl.UserInfoServiceDaoImpl;



public class UserInfoAction {
	private UserInfoServiceDao mUserInfoService; 


	public UserInfoServiceDao getmUserInfoService() {
		return mUserInfoService;
	}
	public void setmUserInfoService(UserInfoServiceDao mUserInfoService) {
		System.out.println("---sss--"+mUserInfoService);
		this.mUserInfoService = mUserInfoService;
	}



	//数据参数
	private String params;

	public void setParams(String params) {
		this.params = params;
	}
	

	public String getParams() {
		try {
			this.params=new String(params.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return params;
	}

	/**
	 * 添加学生信息
	 */
	
	public void  regiesterUserInfo(){	
		HttpServletResponse r=ServletActionContext.getResponse();
		r.setContentType("text/html;charset=utf-8");
		Gson gson=new Gson();
		UserInfo user=gson.fromJson(getParams(), UserInfo.class);
		try {
		if(mUserInfoService.isPhoneExists(user)){
			r.getWriter().print("{\"type\":2,\"result\":\"false\",\"msg\":\"regiestered\"}");	
		}else{
			boolean flag=mUserInfoService.regiesterUserInfo(user);	
			if (flag) {
				//保存成功			
			r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\"seccess\"}");				
			}else{
				//保存失败				
				r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"fail\"}");		
			}
		
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 判断手机号是否注册过
	 */
	public void isPhoneExists() {
		Gson gson=new Gson();
		UserInfo user=gson.fromJson(getParams(), UserInfo.class);
		HttpServletResponse r=ServletActionContext.getResponse();
		r.setContentType("text/html;charset=utf-8");
		try {
		if (mUserInfoService.isPhoneExists(user)) {
				//保存成功			
			r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\"seccess\"}");				
			}else{
				//保存失败				
				r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"fail\"}");		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		/**
		 * 登录获取用户信息
		 */
public void getUserInfo(){
	
	Gson gson=new Gson();
	UserInfo user=gson.fromJson(getParams(), UserInfo.class);

	HttpServletResponse r=ServletActionContext.getResponse();
	r.setContentType("text/html;charset=utf-8");
	ArrayList<UserInfo> list=mUserInfoService.getUserInfo(user);
	
	try {
	if (list!=null&&list.size()>0) {
			//保存成功		
		String json=gson.toJson(list);
		r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\""+json+"\"}");				
		}else{
			//保存失败				
			r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"登录失败，用户名或密码错误\"}");		
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	

}
