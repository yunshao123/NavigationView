package com.navigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.navigationview.base.adapter.TabLayoutAdapter;
import com.navigationview.base.intfrence.OnFragmentInteractionListener;
import com.navigationview.base.fragment.TestOneFragment;
import com.navigationview.base.fragment.TestTwoFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 兰超
 * 666
 */
public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    @BindView(R.id.naview)
    NavigationView navigationView;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.dl_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tb_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    TabLayoutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }
    private void init(){
        tvRight.setBackgroundResource(R.mipmap.menu);
        tvTitle.setText("测试状态");
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_camera:
                        Log.e("dddddddddd","eeeeee");
                        Toast.makeText(MainActivity.this,"nav_camera",Toast.LENGTH_SHORT).show();

                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
        initFragment();
        adapter=new TabLayoutAdapter(getSupportFragmentManager(),fragmentArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
    private ArrayList<Fragment> fragmentArrayList;
    private void initFragment(){
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new TestOneFragment());
        fragmentArrayList.add(new TestTwoFragment());
    }

    @Override
    public void onFragmentInteraction(Object object) {

    }
}
