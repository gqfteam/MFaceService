package com.hkd.mface.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hkd.mface.model.GoodsInfo;
import com.hkd.mface.model.UserInfo;

public class GoodsInfoDaoImpl implements GoodsInfoDao{
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

	@Override
	public boolean addGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		System.out.println("mSessionFactory----"+mSessionFactory);
		int result = (Integer) getSession().save(goods);
		return result>0?true:false;
	}

	@Override
	public boolean updateGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		getSession().update(goods);
		return true;
	}

	@Override
	public boolean deleteGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		getSession().delete(goods);
		return true;
	}

	@Override
	public ArrayList<GoodsInfo> getUsersGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sqlString="from GoodsInfo where phone="+goods.getPhone();//+" and goodsname="+goods.getGoodsname();
		Query query=getSession().createQuery(sqlString);
		
		ArrayList<GoodsInfo> list=null;
		try {
			list = (ArrayList<GoodsInfo>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---------------查询失败");
		}
		
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
		String sqlString="from GoodsInfo where goodsname like '%"+goods.getGoodsname()+"%'";//+" and goodsname="+goods.getGoodsname();
		Query query=getSession().createQuery(sqlString);
		
		ArrayList<GoodsInfo> list=null;
		try {
			list = (ArrayList<GoodsInfo>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---------------查询失败");
		}
		
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}

	@Override
	public ArrayList<GoodsInfo> getGoodsInfoBySchoolAndClassification(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sqlString="";
		if(goods.getGoodscity()!=null){//根据城市查询
			sqlString=sqlString+"from GoodsInfo where goodscity = '"+goods.getGoodscity()+"'";
		}else if(goods.getGoodsuniversity()!=null){//根据学校查询
			sqlString=sqlString+"' and goodsuniversity = '"+goods.getGoodsuniversity()+"'";
		}else if(goods.getGoodscampus()!=null){//根据校区查询
			sqlString=sqlString+"' and goodscampus = '"+goods.getGoodscampus()+"'";

		}else if(goods.getGoodsclassification()!=null){//根据大类查询
			sqlString=sqlString+"' and goodsclassification = '"+goods.getGoodsclassification()+"'";

		}else if(goods.getGoodsspecies()!=null){//根据小类查询
			sqlString=sqlString+"' and goodsspecies = '"+goods.getGoodsspecies()+"'";
		}
		//String sqlString="from GoodsInfo where phone="+goods.getPhone();//+" and goodsname="+goods.getGoodsname();
		Query query=getSession().createQuery(sqlString);
		
		ArrayList<GoodsInfo> list=null;
		try {
			list = (ArrayList<GoodsInfo>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---------------查询失败");
		}
		
		if (list!=null) {
			if(list.size()>0){
				return list;
			}
			
		}
		return null;
	}
}
