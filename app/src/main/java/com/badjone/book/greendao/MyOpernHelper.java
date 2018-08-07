package com.badjone.book.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

/**
 * 数据库升级类
 *
 * @author wugx
 * @data 2018/5/26.
 */

public class MyOpernHelper extends DaoMaster.DevOpenHelper {
//    Class<? extends AbstractDao>[]clzs={UserDao.class, StudentDao.class};

    public MyOpernHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (oldVersion < newVersion) {

            //升级过程需要升级的类，如果是两个，参照下面
            MigrationHelper.getInstance().migrate(db, UserDao.class);
        }
    }
}
