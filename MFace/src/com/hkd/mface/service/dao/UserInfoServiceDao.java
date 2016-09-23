package com.hkd.mface.service.dao;

import java.util.ArrayList;

import com.hkd.mface.model.UserInfo;

public interface UserInfoServiceDao {
	boolean regiesterUserInfo(UserInfo user);
	void updateUserInfo(UserInfo user);
	void deleteUserInfo(UserInfo user);
	/**
	 * ÅÐ¶ÏÓÃ»§ÊÇ·ñ×¢²á
	 * @param user
	 * @return
	 */
	boolean isPhoneExists(UserInfo user);
	ArrayList<UserInfo> getUserInfo(UserInfo user);

}
