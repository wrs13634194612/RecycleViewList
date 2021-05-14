package com.example.mepositry;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: zzhh
 * Date: 2021/01/17 21:51
 * Description: recyclerview 横线指示器
 * 参考博客：https://www.jb51.net/article/181536.htm
 */
public class LineIndicatorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LineIndicatorAdapter adapter;
    private List<String> mItemList = new ArrayList<>();

    private RelativeLayout lineParent;
    private View lineChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_indicator);

        for (int i = 0; i < 10; i++) {
            mItemList.add("" + i);
        }

        lineParent = findViewById(R.id.rl_line_parent);
        lineChild = findViewById(R.id.view_line_child);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new LineIndicatorAdapter(mItemList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //整体的总宽度，注意是整体，包括在显示区域之外的
                //滚动条表示的总范围
                int range = recyclerView.getWidth();
                int temp = recyclerView.computeHorizontalScrollRange();
                if (temp > range) {
                    range = temp;
                }
                //滑块的偏移量
                int offset = recyclerView.computeHorizontalScrollOffset();
                //可视区域长度
                int extent = recyclerView.computeHorizontalScrollExtent();
                //滑出部分在剩余范围的比例
                float proportion = (float) (offset * 1.0 / (range - extent));
                //计算滚动条宽度
                float transMaxRange = lineParent.getWidth() - lineChild.getWidth();
                //设置滚动条移动
                lineChild.setTranslationX(transMaxRange * proportion);
            }
        });
    }
}
