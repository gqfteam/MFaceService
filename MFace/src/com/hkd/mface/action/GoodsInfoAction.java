package com.hkd.mface.action;

import com.google.gson.Gson;
import com.hkd.mface.model.GoodsInfo;
import com.hkd.mface.service.dao.GoodsInfoServiceDao;

import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

public class GoodsInfoAction {
	private GoodsInfoServiceDao mGoodsInfoService;

	public GoodsInfoServiceDao getmGoodsInfoService() {
		return mGoodsInfoService;
	}

	public void setmGoodsInfoService(GoodsInfoServiceDao mGoodsInfoService) {
		this.mGoodsInfoService = mGoodsInfoService;
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
		public void  addGoodsInfo(){	
			HttpServletResponse r=ServletActionContext.getResponse();
			r.setContentType("text/html;charset=utf-8");
			Gson gson=new Gson();
			GoodsInfo goods=gson.fromJson(getParams(), GoodsInfo.class);
			try {
			
				boolean flag=mGoodsInfoService.addGoodsInfo(goods);	
				if (flag) {
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
		public void getUsersGoodsInfo(){
			
			Gson gson=new Gson();
			GoodsInfo goods=gson.fromJson(getParams(), GoodsInfo.class);

			HttpServletResponse r=ServletActionContext.getResponse();
			r.setContentType("text/html;charset=utf-8");
			ArrayList<GoodsInfo> list=mGoodsInfoService.getUsersGoodsInfo(goods);
			
			try {
			if (list!=null&&list.size()>0) {
					//����ɹ�		
				String json=gson.toJson(list);
				r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\""+json+"\"}");				
				}else{
					//����ʧ��				
					r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"��ѯ��Ʒ��ʧ��\"}");		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

			
}
