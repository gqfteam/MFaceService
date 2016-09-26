package com.hkd.mface.service.impl;

import com.hkd.mface.dao.GoodsInfoDao;
import com.hkd.mface.model.GoodsInfo;
import com.hkd.mface.service.dao.GoodsInfoServiceDao;

import java.util.ArrayList;

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
			//��ӳɹ�
			
		}else{
			//��ӳɹ�
			
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
		ArrayList<GoodsInfo> list=null;
		if(goods.getPhone()!=null&&goods.getGoodsname()==null){
			list=mGoodsInfoDao.getUsersGoodsInfo(goods);
		} else if(goods.getGoodsname()!=null&&goods.getPhone()==null){
			list=mGoodsInfoDao.getLikeGoodsInfo(goods);
		} else if(goods.getGoodscity()!=null&&goods.getPhone()==null&&goods.getGoodsname()==null){
			list=mGoodsInfoDao.getGoodsInfoBySchoolAndClassification(goods);
		}
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}


}
