package com.QuantumFinance.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static DBHelper dbHelper;

	private int openedConnections = 0;

	public synchronized SQLiteDatabase getReadableDatabase() {
		openedConnections++;
		return super.getReadableDatabase();
	}

	public synchronized SQLiteDatabase getWritableDatabase() {
		openedConnections++;
		return super.getWritableDatabase();
	}

	public synchronized void close() {
		openedConnections--;
		if (openedConnections == 0) {
			super.close();
		}
	}

	public static DBHelper dbHelper() {
		return dbHelper;
	}

	public static void init(Context context, int version) {
		if (dbHelper == null) {
			dbHelper = new DBHelper(context, version);
		}
	}

	private DBHelper(Context context) {
		super(context, "LzFinance.db", null, 1);
	}

	public DBHelper(Context context, int version) {
		super(context, "LzFinance.db", null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String account = "create table account" + "(id integer primary key," + "username varchar(255)," + "token varchar(255)," + "face varchar(255)," + "phone varchar(20)," + "email varchar(255)," + "bind_weibo integer," // 1表示已经绑定，0表示未绑定
				+ "bind_qq integer,"+"userid integer," +"sex varchar(25) default '男');";
		String praise = "create table praise" + "(id integer primary key," + "paper_id integer);";
		String collect = "create table collect" + "(id integer primary key," + "paper_id integer," + "title varchar(55)," + "lable varchar(55)," + "content varchar(255)," + "view_count integer," + "comments integer," + "logo varchar(255)," + "update_at long," + "synopsis varchar(255));";
		db.execSQL(account);
		db.execSQL(praise);
		db.execSQL(collect);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion) {
			db.execSQL("DROP TABLE account");
			db.execSQL("DROP TABLE praise");
			db.execSQL("DROP TABLE collect");
			onCreate(db);
		}

	}

}
