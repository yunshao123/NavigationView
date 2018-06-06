package com.navigationview.base.base;


import com.navigationview.base.bean.BaseBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public abstract class BaseObserver<T> implements Observer<BaseBean<T>> {

	@Override
	public  void onNext(BaseBean<T> result) {
		if (result.getStatus().equals("0")) {
			onSuccess(result.getResult());
		} else {
			onFailure(new Exception(result.getMsg()),  result.getMsg());
		}
	}

	@Override
	public void onError(Throwable e) {

	}



	@Override
	public void onComplete() {

	}

	@Override
	public void onSubscribe(Disposable d) {

	}

	public abstract void onSuccess(T result);

	public abstract void onFailure(Throwable e, String errorMsg);
}
