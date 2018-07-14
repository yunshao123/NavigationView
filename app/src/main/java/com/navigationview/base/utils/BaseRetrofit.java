package com.navigationview.base.utils;

import com.navigationview.base.interfance.APIinterfaces;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/31
 * @Time 15:51
 * Retrofit单例对象获取
 */
public class BaseRetrofit {
    //超时时间
    public static final int DEFAULT_TIMEOUT = 10;
    private static volatile BaseRetrofit retrofit=null;
    private static APIinterfaces apIinterfaces;
    public static APIinterfaces getRetrofit(){
        if (retrofit==null){
            synchronized (Retrofit.class){
                if (retrofit==null){
                    OkHttpClient client = new OkHttpClient.Builder()
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .build();

                    Retrofit retrofit=new Retrofit.Builder().baseUrl("http://121.196.228.220:8080/jeecg-framework/")
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(client)
                            .build();
                    apIinterfaces=retrofit.create(APIinterfaces.class);
                }
            }
        }
        return apIinterfaces;
    }
}
