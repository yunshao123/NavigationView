package com.navigationview.base.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.navigationview.R;
import com.navigationview.base.BaseViewPageFragment;
import com.navigationview.base.utils.User;
import com.navigationview.greendao.DaoManger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2017/12/29
 * @Time 14:16
 */

/**
 * 好玩啊
 */
public class TestOneFragment extends BaseViewPageFragment {

    @BindView(R.id.animation_view)
    LottieAnimationView animationView;
    @OnClick(R.id.btn_insert)
    void  btnInsert(){
        DaoManger.getIntence(mContext).insertUserDao(new User());
    }
    @OnClick(R.id.btn_query)
    void btnQuery(){
        for (User user:DaoManger.getIntence(mContext).queryUserDao(new User())){
            Log.e(TAG,user.getUsername());
        }

    }
    Unbinder unbinder;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.base_one;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyloadData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
