package com.hkd.mface.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.hkd.mface.model.UserInfo;

import com.hkd.mface.dao.UserInfoDao;


public class UserInfoDaoImpl implements UserInfoDao{
	
	
	private SessionFactory mSessionFactory;

	public SessionFactory getmSessionFactory() {
		return mSessionFactory;
	}

	public void setmSessionFactory(SessionFactory mSessionFactory) {
		this.mSessionFactory = mSessionFactory;
	}

	private Session getSession() {
		return mSessionFactory.getCurrentSession();

	}
	
	/**
	 * 添加用户
	 */
	public boolean addUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		System.out.println("mSessionFactory----"+mSessionFactory);
		int result = (Integer) getSession().save(user);
		return result>0?true:false;
	}

	@Override
	/**
	 * 更新用户信息
	 */
	public boolean updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		getSession().update(user);
		return true;
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public boolean deleteUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		getSession().delete(user);
		return true;
	}

	@Override
	public ArrayList<UserInfo> getUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		String sqlString="from UserInfo where phone="+user.getPhone()+" and passWord="+user.getPassWord();
		Query query=getSession().createQuery(sqlString);
		ArrayList<UserInfo> list=(ArrayList<UserInfo>) query.list();
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		
		return null;
	}

	/**
	 * 判断手机号是否注册过
	 */
	@Override
	public boolean isPhoneExists(UserInfo user) {
		// TODO Auto-generated method stub
		String sqlString="from UserInfo where phone="+user.getPhone();
		Query query=getSession().createQuery(sqlString);
		ArrayList<UserInfo> list=(ArrayList<UserInfo>) query.list();
		if (list!=null) {
			if(list.size()>0){
				return true;
			}
			
		}
		
		return false;
	}
		

}
