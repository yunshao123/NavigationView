package com.navigationview.base.base;

import android.content.Context;

/**
 * Created by JohnsonFan on 2017/9/29.
 */

public abstract class ProgressObserver<T> extends  BaseObserver<T>{

	private Context mContext;
	private String mLoadingText;

	public ProgressObserver(Context context){
		this(context, null);
	}

	public ProgressObserver(Context context, String loadingText){
		mContext = context;
		mLoadingText = loadingText;
	}


}
