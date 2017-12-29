package com.navigationview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.navigationview.R;
import com.navigationview.base.BaseViewPageFragment;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2017/12/29
 * @Time 14:19
 */

public class TestTwoFragment extends BaseViewPageFragment {
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.base_two;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyloadData() {

    }
}
