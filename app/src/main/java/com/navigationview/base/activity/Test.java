package com.navigationview.base.activity;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/25
 * @Time 14:53
 */
public class Test {
    public static volatile  Test test=null;
    public  Test(){}
    public static Test getInsce(){
        if (test==null){
            synchronized (Test.class){
                if (test==null){
                    test=new Test();
                }
            }
        }
        return test;
    }
}
