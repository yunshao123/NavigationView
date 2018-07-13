package com.navigationview.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.navigationview.ColumnarItem;
import com.navigationview.R;
import com.navigationview.VerticalColumnarGraphView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.vc_view)
    VerticalColumnarGraphView verticalColumnarGraphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        verticalColumnarGraphView.setOnColumnarItemClickListener(new VerticalColumnarGraphView.OnColumnarItemClickListener() {
            @Override
            public void onColumnarItemClick(VerticalColumnarGraphView view, int selectedIndex, @Nullable ColumnarItem selectedItem) {
                Toast.makeText(TestActivity.this,selectedIndex,Toast.LENGTH_SHORT).show();
            }
        });
        verticalColumnarGraphView.setOnColumnarItemLongClickListener(new VerticalColumnarGraphView.OnColumnarItemLongClickListener() {
            @Override
            public void onColumnarItemLongClick(VerticalColumnarGraphView view, int selectedIndex, @Nullable ColumnarItem selectedItem) {
                Toast.makeText(TestActivity.this,selectedIndex,Toast.LENGTH_SHORT).show();
            }
        });

        verticalColumnarGraphView.initCustomUI(
                new VerticalColumnarGraphView.Builder()
                        .setYAxisLabels(new String[]{"\u20000", "25", "50", "75", "100"})
                        .setXAxisLabels(new String[]{"\u20000", "25", "50", "75", "100", "75", "100"})
                        .setOffset(60, 0, 20, 40)
        );
        verticalColumnarGraphView.setItems(createTestData());

    }
    /**
     * 创建测试数据
     *
     * @return test data source
     */
    private List<ColumnarItem> createTestData() {
        List<ColumnarItem> data = new ArrayList<>();
        float[] ratios = {.76f, .36f, .54f, .36f, .05f, .36f, .6f};
        int[] colors = {0xFFFFCF5E, 0xFFB4EE4D, 0xFF27E67B, 0xFF36C771, 0xFF1CA291, 0xFF24DDD0, 0xFf32CEF7};
        String[] labels = {"返情配种", "多次输精", "人工授精", "本交", "同精液配种", "已配种母猪", "其他配种"};
        String[] values = {"76头", "36头", "54头", "36头", "5头", "36头", "60头"};
        for (int i = 0; i < 7; i++) {
            ColumnarItem item = new ColumnarItem();
            item.setColor(colors[i]);
            item.setRatio(ratios[i]);
            item.setLabel(labels[i]);
            item.setValue(values[i]);
            data.add(item);
        }
        return data;
    }
}
