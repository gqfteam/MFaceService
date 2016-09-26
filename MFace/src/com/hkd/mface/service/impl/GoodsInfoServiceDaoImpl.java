package com.hkd.mface.service.impl;

import java.util.ArrayList;

import com.hkd.mface.dao.GoodsInfoDao;
import com.hkd.mface.model.GoodsInfo;
import com.hkd.mface.model.UserInfo;
import com.hkd.mface.service.dao.GoodsInfoServiceDao;

public class GoodsInfoServiceDaoImpl implements GoodsInfoServiceDao{

	private GoodsInfoDao mGoodsInfoDao;
	
	
	public GoodsInfoDao getmGoodsInfoDao() {
		return mGoodsInfoDao;
	}

	public void setmGoodsInfoDao(GoodsInfoDao mGoodsInfoDao) {
		this.mGoodsInfoDao = mGoodsInfoDao;
	}

	@Override
	public boolean addGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		boolean flag=mGoodsInfoDao.addGoodsInfo(goods);
		if(flag){
			//添加成功
			
		}else{
			//添加成功
			
		}
		return flag;
	}

	@Override
	public boolean updateGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		return mGoodsInfoDao.updateGoodsInfo(goods);
	}

	@Override
	public boolean deleteGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		return mGoodsInfoDao.deleteGoodsInfo(goods);
	}

	@Override
	public ArrayList<GoodsInfo> getUsersGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		ArrayList<GoodsInfo> list=mGoodsInfoDao.getUsersGoodsInfo(goods);
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}

	@Override
	public ArrayList<GoodsInfo> getLikeGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		ArrayList<GoodsInfo> list=mGoodsInfoDao.getLikeGoodsInfo(goods);
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}

	@Override
	public ArrayList<GoodsInfo> getGoodsInfoBySchoolAndClassification(
			GoodsInfo goods) {
		// TODO Auto-generated method stub
		ArrayList<GoodsInfo> list=mGoodsInfoDao.getGoodsInfoBySchoolAndClassification(goods);
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}

}
