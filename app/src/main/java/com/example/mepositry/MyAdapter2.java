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


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    private List<String> mDataList = new ArrayList<>();
    private Context context;

    public MyAdapter2(Context mContext, List<String> list) {
        this.context=mContext;
        this.mDataList = list;
    }


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item2, parent, false);
        return new BaseRecyclerViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, final int position) {
        TextView name = holder.findBindItemView(R.id.tv_title);
        name.setText("id:"+position+mDataList.get(position));
        //抽象方法
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "holder.itemView:" + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

/*    @Override
    protected int setupItemLayoutId() {
        return ;
    }

    @Override
    protected void findBindView(int position, BaseRecyclerViewHolder holder) {
        String data = mDataList.get(position);
        TextView name = holder.findBindItemView(R.id.tv_title);
        name.setText(data);

    }*/
}
