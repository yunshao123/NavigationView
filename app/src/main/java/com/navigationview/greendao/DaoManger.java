package com.navigationview.greendao;

import android.content.Context;
import android.widget.Toast;

import com.navigationview.base.utils.User;

import java.util.List;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/17
 * @Time 13:46
 */
public class DaoManger {
    private static final String TAG ="DaoManger";
    private static volatile DaoManger daoManger=null;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private Context context;
    public DaoManger(Context mcontext){
        try {
            this.context = mcontext.getApplicationContext();
        }catch (Exception e){
            e.printStackTrace();
            this.context = mcontext;
        }
        devOpenHelper=new DaoMaster.DevOpenHelper(context, "my-db", null);
    }
    public static DaoManger getIntence(Context context){
        if (daoManger==null){
            synchronized (DaoManger.class){
                if (daoManger==null){
                    daoManger=new DaoManger(context);
                }
            }
        }
        return daoManger;
    }
    public  DaoMaster getDaoMaster(){
        if (daoMaster==null){
            daoMaster=new DaoMaster(devOpenHelper.getWritableDatabase());
        }
        return daoMaster;
    }
    public  DaoSession getDaoSession(){
        if (daoSession==null){
            daoSession=getDaoMaster().newSession();
        }
        return daoSession;
    }
    public void insertUserDao(User user){
        UserDao userDao=getDaoSession().getUserDao();
        user=new User(null,"兰超");
        userDao.insert(user);
        Toast.makeText(context,"插入成功",Toast.LENGTH_SHORT);
    }
    public List<User> queryUserDao(User user){
        UserDao userDao=getDaoSession().getUserDao();
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Id.notEq(1))
                .limit(5)
                .build().list();
        return userList;
    }
}
