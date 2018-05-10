package com.navigationview.base.activity;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/10
 * @Time 13:35
 *
 */
public class Singleton {
    private static volatile Singleton singleton=null;
    private Singleton(){}
    private static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
