package com.navigationview.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.navigationview.R;
import com.navigationview.base.bean.LoginBean;
import com.navigationview.base.utils.BaseRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventTestActivity extends AppCompatActivity {
    @BindView(R.id.ll)
    LinearLayout linearLayout;
    @BindView(R.id.btn)
    Button button;
    public static final String TAG ="AppCompatActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);
        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Retrofit retrofit=new Retrofit.Builder().baseUrl("http://121.196.228.220:8080/jeecg-framework/")
//                        .addConverterFactory(ScalarsConverterFactory.create())
//                        .addConverterFactory(GsonConverterFactory.create()).build();

                Call<LoginBean> call= BaseRetrofit.getRetrofit().login("15619187872","123456","1.0","79b61592f06cba684de095f7598955317263da77");
                call.enqueue(new Callback<LoginBean>() {
                    @Override
                    public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                        Log.e(TAG,response.body().getMsg());
                    }

                    @Override
                    public void onFailure(Call<LoginBean> call, Throwable t) {

                    }
                });
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG,"长按事件");
                return true;
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

}
