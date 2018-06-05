package com.navigationview.base.base;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;



public abstract class BaseObserver<T> implements Observer<Response<T>> {

	@Override
	public final void onNext(@NonNull Response<T> result) {
		if (result.getRet() == -1) {
			onFailure(new Exception(result.getMsg()),  result.getMsg());
		} else {
			onSuccess(result.getData());
		}
	}

	@Override
	public void onError(@NonNull Throwable e) {

	}



	@Override
	public void onComplete() {

	}

	@Override
	public void onSubscribe(@NonNull Disposable d) {

	}

	public abstract void onSuccess(T result);

	public abstract void onFailure(Throwable e, String errorMsg);
}
