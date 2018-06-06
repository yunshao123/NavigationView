package com.navigationview.base.interfance;

import com.navigationview.base.bean.BaseBean;
import com.navigationview.base.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/31
 * @Time 10:36
 */
public interface APIinterfaces {
    @FormUrlEncoded
    @POST("m/specialController.do?login")
    Call<LoginBean> login(@Field("username") String name, @Field("password") String passwd,
                          @Field("aversion") String aversion, @Field("xgtoken")String xgtoken);
    @FormUrlEncoded
    @POST("m/specialController.do?login")
    Observable<BaseBean<Object>> login2(@Field("username") String name, @Field("password") String passwd,
                                @Field("aversion") String aversion, @Field("xgtoken")String xgtoken);

    /**
     * @Auth Mr.lc(兰超)
     * @Date 2017/1/12 17:05
     * 修改密码参数
     */
    @FormUrlEncoded @POST("wyApp.do?updatePwd")
    Observable<String> change(@Field("employeeId") String user, @Field("pwd") String pwd);
}
