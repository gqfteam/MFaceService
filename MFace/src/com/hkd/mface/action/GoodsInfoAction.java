package com.hkd.mface.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.hkd.mface.model.GoodsInfo;
import com.hkd.mface.model.UserInfo;
import com.hkd.mface.service.dao.GoodsInfoServiceDao;

public class GoodsInfoAction {
	private GoodsInfoServiceDao mGoodsInfoService;

	public GoodsInfoServiceDao getmGoodsInfoService() {
		return mGoodsInfoService;
	}

	public void setmGoodsInfoService(GoodsInfoServiceDao mGoodsInfoService) {
		this.mGoodsInfoService = mGoodsInfoService;
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
		public void  addGoodsInfo(){	
			HttpServletResponse r=ServletActionContext.getResponse();
			r.setContentType("text/html;charset=utf-8");
			Gson gson=new Gson();
			GoodsInfo goods=gson.fromJson(getParams(), GoodsInfo.class);
			try {
			
				boolean flag=mGoodsInfoService.addGoodsInfo(goods);	
				if (flag) {
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
		public void getUsersGoodsInfo(){
			
			Gson gson=new Gson();
			GoodsInfo goods=gson.fromJson(getParams(), GoodsInfo.class);

			HttpServletResponse r=ServletActionContext.getResponse();
			r.setContentType("text/html;charset=utf-8");
			ArrayList<GoodsInfo> list=mGoodsInfoService.getUsersGoodsInfo(goods);
			
			try {
			if (list!=null&&list.size()>0) {
					//保存成功		
				String json=gson.toJson(list);
				r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\""+json+"\"}");				
				}else{
					//保存失败				
					r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"查询商品表失败\"}");		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
public void getLikeGoodsInfo(){
			
			Gson gson=new Gson();
			GoodsInfo goods=gson.fromJson(getParams(), GoodsInfo.class);

			HttpServletResponse r=ServletActionContext.getResponse();
			r.setContentType("text/html;charset=utf-8");
			ArrayList<GoodsInfo> list=mGoodsInfoService.getLikeGoodsInfo(goods);
			
			try {
			if (list!=null&&list.size()>0) {
					//保存成功		
				String json=gson.toJson(list);
				r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\""+json+"\"}");				
				}else{
					//保存失败				
					r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"查询商品表失败\"}");		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
public void getGoodsInfoBySchoolAndClassification(){
	
	Gson gson=new Gson();
	GoodsInfo goods=gson.fromJson(getParams(), GoodsInfo.class);

	HttpServletResponse r=ServletActionContext.getResponse();
	r.setContentType("text/html;charset=utf-8");
	ArrayList<GoodsInfo> list=mGoodsInfoService.getGoodsInfoBySchoolAndClassification(goods);
	
	try {
	if (list!=null&&list.size()>0) {
			//保存成功		
		String json=gson.toJson(list);
		r.getWriter().print("{\"type\":0,\"result\":\"true\",\"msg\":\""+json+"\"}");				
		}else{
			//保存失败				
			r.getWriter().print("{\"type\":1,\"result\":\"false\",\"msg\":\"查询商品表失败\"}");		
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
			
}
