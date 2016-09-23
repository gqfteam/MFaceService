package com.hkd.mface.dao;

import java.util.ArrayList;

import com.hkd.mface.model.UserInfo;



public interface UserInfoDao {
	boolean addUserInfo(UserInfo user);
	boolean updateUserInfo(UserInfo user);
	boolean deleteUserInfo(UserInfo user);
	/**
	 * ÅÐ¶ÏÓÃ»§ÊÇ·ñ×¢²á
	 * @param user
	 * @return
	 */
	boolean isPhoneExists(UserInfo user);
	ArrayList<UserInfo> getUserInfo(UserInfo user);

}
