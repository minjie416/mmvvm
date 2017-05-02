package com.example.minjie.mmvvm.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by minjie on 28/04/2017.
 */

public class DaoUtil{
	private static DaoSession daoSession;

	public static void setupDatabase(Context context){
		DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "shop.db", null);
		SQLiteDatabase db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();
	}

	public static DaoSession getDaoSession(){
		return daoSession;
	}
}
