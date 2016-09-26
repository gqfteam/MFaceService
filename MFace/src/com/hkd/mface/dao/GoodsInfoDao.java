package com.hkd.mface.dao;

import java.util.ArrayList;

import com.hkd.mface.model.GoodsInfo;
import com.hkd.mface.model.UserInfo;

public interface GoodsInfoDao {
	boolean addGoodsInfo(GoodsInfo goods);
	boolean updateGoodsInfo(GoodsInfo goods);
	boolean deleteGoodsInfo(GoodsInfo goods);
	
	ArrayList<GoodsInfo> getUsersGoodsInfo(GoodsInfo goods);//��ѯ�û�����������Ʒ
	public ArrayList<GoodsInfo> getLikeGoodsInfo(GoodsInfo goods);//������Ʒ��ģ����ѯ
	public ArrayList<GoodsInfo> getGoodsInfoBySchoolAndClassification(GoodsInfo goods);//���ݳ��У�ѧУ��У�����в�ѯ
}
