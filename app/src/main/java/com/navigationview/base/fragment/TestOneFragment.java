package com.navigationview.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.navigationview.R;
import com.navigationview.base.BaseViewPageFragment;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2017/12/29
 * @Time 14:16
 */

/**
 * 好玩啊
 */
public class TestOneFragment extends BaseViewPageFragment {


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
}