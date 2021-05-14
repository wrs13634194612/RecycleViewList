/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-09-18 23:47:01
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.example.mepositry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity implements PagerGridLayoutManager
        .PageListener {

    private int mRows = 2;  //设置行数
    private int mColumns = 4;  //设置列数
    private RecyclerView mRecyclerView;
    private MyAdapter2 mAdapter;
    private PagerGridLayoutManager mLayoutManager;
    private RelativeLayout lineParent;
    private int mTotal = 0;
    private int mCurrent = 0;
    private View lineChild;
    private String[] names = {"多多果园","九块九特卖","多多爱消除","天天领现金"
            ,"行家帮你选","限时秒杀","断码清仓","跟着好评买"
            ,"充值中心","医药馆","签到","多多赚大钱"
            ,"砍价免费拿","多多精灵","省钱月卡","现金大转盘"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        lineParent = findViewById(R.id.rl_line_parent);
        lineChild = findViewById(R.id.view_line_child);
        mLayoutManager = new PagerGridLayoutManager(mRows, mColumns, PagerGridLayoutManager
                .HORIZONTAL);
        // 系统带的 RecyclerView，无需自定义
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // 水平分页布局管理器
        mLayoutManager.setPageListener(this);    // 设置页面变化监听器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 如果需要查看调试日志可以设置为true，一般情况忽略即可
        PagerConfig.setShowLog(true);
        initData();

    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            list.add(names[i]);
        }
        //   mAdapter.refreshDataList(list);
        // 使用原生的 Adapter 即可
        mAdapter = new MyAdapter2(TwoActivity.this, list);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onPageSizeChanged(int pageSize) {
        mTotal = pageSize;
        Log.e("TAG", "总页数 = " + pageSize);
    }

    @Override
    public void onPageSelect(int pageIndex, int pageSize) {
        mCurrent = pageIndex;
        Log.e("TAG", "选中页码 = " + pageIndex + "\t" + pageSize);
        //计算滚动条宽度
        float proportion = (float) ((pageIndex + 1) / pageSize);
        float transMaxRange = lineParent.getWidth() - lineChild.getWidth();
        //设置滚动条移动
        lineChild.setTranslationX(transMaxRange * proportion);
    }
}
