package com.example.minjie.mmvvm.model;

import java.util.List;

/**
 * Created by minjie on 28/04/2017.
 */

public class LoveDao {
	public static void insertLove(Shop shop){
		DaoUtil.getDaoSession().getShopDao().insertOrReplace(shop);
	}
	public static void deleteLove(long id){
		DaoUtil.getDaoSession().getShopDao().deleteByKey(id);
	}
	public static void updateLove(Shop shop){
		DaoUtil.getDaoSession().getShopDao().update(shop);
	}
	public static List<Shop> queryLove(){
		return DaoUtil.getDaoSession().getShopDao().queryBuilder().where(ShopDao.Properties.Id.eq(Long.parseLong("1"))).list();
	}
	public static List<Shop> queryAll(){
		return DaoUtil.getDaoSession().getShopDao().queryBuilder().list();
	}
}
