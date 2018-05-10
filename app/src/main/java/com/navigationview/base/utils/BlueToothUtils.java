package com.navigationview.base.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.util.Log;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/10
 * @Time 15:00
 */
public class BlueToothUtils {
    private final static String TAG="BlueToothUtils";
    public  static void ifOpenBlueTooth(Context context){
        BluetoothManager bluetoothManager = (BluetoothManager)context.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter=bluetoothManager.getAdapter();
        if (bluetoothAdapter.isEnabled()){
            Log.e(TAG,"已开启蓝牙");
        }else{
            Log.e(TAG,"未开启蓝牙");
        }
    }
}
