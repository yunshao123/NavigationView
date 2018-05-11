package com.navigationview.base.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.navigationview.R;
import com.navigationview.base.BaseViewPageFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2017/12/29
 * @Time 14:19
 */

public class TestTwoFragment extends BaseViewPageFragment {
    @BindView(R.id.bmapView)
    MapView mapView;
    @OnClick(R.id.location)
    void location(){
        isFirstLoc = true;
        initView();
        //初始化定位相关
        initLoc();
        //开始定位
        mLocationClient.start();
    }
    private BaiduMap baiduMap;
    private MyLocationConfiguration.LocationMode mCurrentMode;

    //显示定位点
    private BitmapDescriptor mMarker;
    //定位类
    private LocationClient mLocationClient;
    //是否是第一次定位
    private boolean isFirstLoc = true;
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.base_two;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyloadData() {
        //初始化试图
        initView();
        //初始化定位相关
        initLoc();
        //开始定位
        mLocationClient.start();
    }

    //定位回调
    private BDLocationListener mBDLocationListener = new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {

            Log.d(TAG, "SUCCESS: ");
            //定位成功后回调该方法
            //BDLocation封装了定位相关的各种信息

            //构造定位数据
            MyLocationData data = new MyLocationData.Builder()
                    .accuracy(0)//定位精度
                    .latitude(bdLocation.getLatitude())//纬度
                    .longitude(bdLocation.getLongitude())//经度
                    .direction(0)//方向 可利用手机方向传感器获取 此处为方便写死
                    .build();
            //设置定位数据
            baiduMap.setMyLocationData(data);

            //配置定位图层显示方式
            //有两个不同的构造方法重载 分别为三个参数和五个参数的
            //这里主要讲一下常用的三个参数的构造方法
            //三个参数：LocationMode(定位模式：罗盘，跟随),enableDirection（是否允许显示方向信息）
            // ,customMarker（自定义图标）
            MyLocationConfiguration configuration = new MyLocationConfiguration(
                    MyLocationConfiguration.LocationMode.NORMAL, false, mMarker);

            baiduMap.setMyLocationConfiguration(configuration);

            LatLng ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
            //第一次定位需要更新下地图显示状态
            if (isFirstLoc) {
                isFirstLoc = false;
                MapStatus.Builder builder = new MapStatus.Builder()
                        .target(ll)//地图缩放中心点
                        .zoom(18f);//缩放倍数 百度地图支持缩放21级 部分特殊图层为20级
                //改变地图状态
                baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }


        }
    };
    /**
     * 定位设置
     */
    private void initLoc() {

        //开启定位图层
        baiduMap.setMyLocationEnabled(true);
        //定位相关参数设置
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系
        //共有三种坐标可选
        //1. gcj02：国测局坐标；
        //2. bd09：百度墨卡托坐标；
        //3. bd09ll：百度经纬度坐标；

        int span = 1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        //加载设置
        mLocationClient.setLocOption(option);

    }
    private void initView() {
        //获取BadiuMap实例 地图控制器类
        baiduMap = mapView.getMap();
        mLocationClient = new LocationClient(getActivity());
        //注册定位回调
        mLocationClient.registerLocationListener(mBDLocationListener);

        //覆盖物 用于显示当前位置
        mMarker = BitmapDescriptorFactory.fromResource(R.mipmap.icon_geo);
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mLocationClient.isStarted()) {
            mLocationClient.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();

    }
}
