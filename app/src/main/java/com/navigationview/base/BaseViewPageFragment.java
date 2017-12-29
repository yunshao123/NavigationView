package com.navigationview.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navigationview.base.intfrence.OnFragmentInteractionListener;

import butterknife.ButterKnife;

/**
 * @Auth Mr.Jobs(乔元培)
 * @Date 2016/12/30
 * @Time 10:42
 * 别人可以拷贝我的代码，但是不能拷贝我不断往前的激情(0-0)。
 **/

public abstract class BaseViewPageFragment extends Fragment {

    protected Context mContext;
    private final String className = getClass().getName();
    protected final String TAG = className.substring(className.lastIndexOf(".") + 1, className.length());
    private ProgressDialog loadDialog;
    public OnFragmentInteractionListener mListener;
    private boolean mHasLoadedOnce = false;/**已经加载过**/
    public boolean isPrePared = false; /**表示生命周期开始调用*/
    public BaseViewPageFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View mMainView = inflater.inflate(setLayout(inflater), container, false);
        ButterKnife.bind(this, mMainView);
        init(savedInstanceState);
        return mMainView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        /**装逼还的看自己！！！！12.30 乔*/
//        LogUtils.e(TAG,isVisibleToUser+"");
        if (isVisibleToUser){
            if (!mHasLoadedOnce) {
                Log.e(TAG,"BaselazyloadDate");
                lazyloadData();
                mHasLoadedOnce =true;
            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        /**我的想法是全部缓存页面，但是不加载数据，啊哈哈哈，完美*/
        super.onActivityCreated(savedInstanceState);
    }
    /**
     * @Auth Mr.Jobs(乔元培)
     * @Date 11.24
     * 重新构造fragment中的必须要实现的方法
     **/
    protected abstract int setLayout(LayoutInflater inflater);
    protected abstract void init(Bundle savedInstanceState);
    protected abstract void lazyloadData();
    @Override
    public void onAttach(Context context) {
        Log.e(TAG,"onAttach");
        super.onAttach(context);
        mContext = context;
        isPrePared = true;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        Log.e(TAG,"onDetach");
        super.onDetach();
        mListener = null;
    }


    public void showLoadDialog(String message){
        if (loadDialog==null){
            loadDialog= new ProgressDialog(getActivity());
            loadDialog.setMessage(message);
            loadDialog.show();
        } else if (loadDialog!=null&&!loadDialog.isShowing()){
            loadDialog.setMessage(message);
            loadDialog.show();
        }
        loadDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i== KeyEvent.KEYCODE_BACK){
                    return true;
                }else return false;
            }
        });
    }

    public void showLoadDialog(){
        showLoadDialog("加载中");
    }
    public void dismissDialog(){
        if (loadDialog!=null&&loadDialog.isShowing()){
            loadDialog.dismiss();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissDialog();
        loadDialog=null;
    }
}
