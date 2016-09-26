package com.hkd.mface.service.dao;

import com.hkd.mface.model.GoodsInfo;

import java.util.ArrayList;

public interface GoodsInfoServiceDao {
	boolean addGoodsInfo(GoodsInfo goods);
	boolean updateGoodsInfo(GoodsInfo goods);
	boolean deleteGoodsInfo(GoodsInfo goods);
	
	ArrayList<GoodsInfo> getUsersGoodsInfo(GoodsInfo goods);
}
