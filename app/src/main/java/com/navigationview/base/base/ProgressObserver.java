package com.navigationview.base.base;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by JohnsonFan on 2017/9/29.
 */

public abstract class ProgressObserver<T> extends  BaseObserver<T>{
	private MaterialDialog mMaterialDialog;
	private Context mContext;
	private String mLoadingText;

	public ProgressObserver(Context context){
		this(context, null);
	}

	public ProgressObserver(Context context, String loadingText){
		mContext = context;
		mLoadingText = loadingText;
	}

	@Override
	public void onSubscribe(@NonNull Disposable d) {
		if (!d.isDisposed()) {
			mMaterialDialog = new MaterialDialog.Builder(mContext).content(mLoadingText == null ? "正在加载中..."
					: mLoadingText).progress(true,0).build();
			mMaterialDialog.show();
		}
	}

	@Override
	public void onComplete() {
		if (mMaterialDialog != null) {
			mMaterialDialog.dismiss();
		}
	}

	@Override
	public void onError(@NonNull Throwable e) {
		super.onError(e);
		if (mMaterialDialog != null) {
			mMaterialDialog.dismiss();
		}
	}

}
