package com.navigationview.base.base;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.navigationview.base.bean.BaseBean;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/6/6
 * @Time 10:49
 */
public abstract class BaseObsever<T> implements Observer<BaseBean<T>> {
    protected Context mContext;

    public BaseObsever(Context cxt) {
        this.mContext = cxt;
    }

    public BaseObsever() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();

    }

    @Override
    public void onNext(BaseBean<T> tBaseEntity) {
        onRequestEnd();
        if (tBaseEntity.getStatus().equals( "0" )) {
            try {
                onSuccees(tBaseEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                onCodeError(tBaseEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
//        Log.w(TAG, "onError: ", );这里可以打印错误信息
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e, true);
            } else {
                onFailure(e, false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
    }

    /**
     * 返回成功
     *
     * @param t
     * @throws Exception
     */
    public abstract void onSuccees(BaseBean<T> t) throws Exception;

    /**
     * 返回成功了,但是code错误
     *
     * @param t
     * @throws Exception
     */
    public void onCodeError(BaseBean<T> t) throws Exception {
    }

    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    public abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;

    public void onRequestStart() {
    }

    public void onRequestEnd() {
        closeProgressDialog();
    }

    public void showProgressDialog() {

    }

    public void closeProgressDialog() {

    }

}
