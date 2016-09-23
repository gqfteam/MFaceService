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



	//���ݲ���
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
	 * ���ѧ����Ϣ
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
				//����ɹ�			
			r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\"seccess\"}");				
			}else{
				//����ʧ��				
				r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"fail\"}");		
			}
		
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �ж��ֻ����Ƿ�ע���
	 */
	public void isPhoneExists() {
		Gson gson=new Gson();
		UserInfo user=gson.fromJson(getParams(), UserInfo.class);
		HttpServletResponse r=ServletActionContext.getResponse();
		r.setContentType("text/html;charset=utf-8");
		try {
		if (mUserInfoService.isPhoneExists(user)) {
				//����ɹ�			
			r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\"seccess\"}");				
			}else{
				//����ʧ��				
				r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"fail\"}");		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		/**
		 * ��¼��ȡ�û���Ϣ
		 */
public void getUserInfo(){
	
	Gson gson=new Gson();
	UserInfo user=gson.fromJson(getParams(), UserInfo.class);

	HttpServletResponse r=ServletActionContext.getResponse();
	r.setContentType("text/html;charset=utf-8");
	ArrayList<UserInfo> list=mUserInfoService.getUserInfo(user);
	
	try {
	if (list!=null&&list.size()>0) {
			//����ɹ�		
		String json=gson.toJson(list);
		r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\""+json+"\"}");				
		}else{
			//����ʧ��				
			r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"��¼ʧ�ܣ��û������������\"}");		
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	

}
