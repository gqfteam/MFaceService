package com.hkd.mface.service.dao;

import java.util.ArrayList;

import com.hkd.mface.model.GoodsInfo;

public interface GoodsInfoServiceDao {
	boolean addGoodsInfo(GoodsInfo goods);
	boolean updateGoodsInfo(GoodsInfo goods);
	boolean deleteGoodsInfo(GoodsInfo goods);
	
	ArrayList<GoodsInfo> getUsersGoodsInfo(GoodsInfo goods);
	public ArrayList<GoodsInfo> getLikeGoodsInfo(GoodsInfo goods);//������Ʒ��ģ����ѯ
	public ArrayList<GoodsInfo> getGoodsInfoBySchoolAndClassification(GoodsInfo goods);//���ݳ��У�ѧУ��У�����в�ѯ
}
