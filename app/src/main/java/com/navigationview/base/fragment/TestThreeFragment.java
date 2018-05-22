package com.navigationview.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.navigationview.R;
import com.navigationview.base.BaseViewPageFragment;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/18
 * @Time 16:10
 */
public class TestThreeFragment extends BaseViewPageFragment {
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_test;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyloadData() {

    }
}
