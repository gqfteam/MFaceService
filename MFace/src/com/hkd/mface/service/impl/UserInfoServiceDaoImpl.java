package com.hkd.mface.service.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hkd.mface.model.UserInfo;
import com.hkd.mface.service.dao.UserInfoServiceDao;

import com.hkd.mface.dao.UserInfoDao;
import com.hkd.mface.dao.UserInfoDaoImpl;


public class UserInfoServiceDaoImpl implements UserInfoServiceDao{
	
	
	private UserInfoDao mUserInfoDao;

	
	public UserInfoDao getmUserInfoDao() {
		return mUserInfoDao;
	}

	public void setmUserInfoDao(UserInfoDao mUserInfoDao) {
		this.mUserInfoDao = mUserInfoDao;
	}

	/**
	 * ����û�
	 */
	public boolean regiesterUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		boolean flag=mUserInfoDao.addUserInfo(user);
		if(flag){
			//��ӳɹ�
			
		}else{
			//��ӳɹ�
			
		}
		return flag;
		
		
		
	}

	@Override
	/**
	 * �����û���Ϣ
	 */
	public void updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		mUserInfoDao.updateUserInfo(user);
		
	}

	/**
	 * ɾ���û���Ϣ
	 */
	@Override
	public void deleteUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		mUserInfoDao.deleteUserInfo(user);
	}

	@Override
	public boolean isPhoneExists(UserInfo user) {
		return mUserInfoDao.isPhoneExists(user);
	}

	@Override
	public ArrayList<UserInfo> getUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		ArrayList<UserInfo> list=mUserInfoDao.getUserInfo(user);
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}

	

}
