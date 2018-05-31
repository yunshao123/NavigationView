package com.navigationview.base.utils;

import com.navigationview.base.interfance.APIinterfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/31
 * @Time 15:51
 * Retrofit单例对象获取
 */
public class BaseRetrofit {
    private static volatile BaseRetrofit retrofit=null;
    private static APIinterfaces apIinterfaces;
    private BaseRetrofit(){};
    public static APIinterfaces getRetrofit(){
        if (retrofit==null){
            synchronized (Retrofit.class){
                if (retrofit==null){
                    Retrofit retrofit=new Retrofit.Builder().baseUrl("http://121.196.228.220:8080/jeecg-framework/")
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    apIinterfaces=retrofit.create(APIinterfaces.class);
                }
            }
        }
        return apIinterfaces;
    }
}
