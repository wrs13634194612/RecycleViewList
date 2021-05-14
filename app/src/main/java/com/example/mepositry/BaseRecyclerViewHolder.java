/*
 * Copyright 2019 GcsSloop
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
 * Last modified 2019-05-09 02:17:38
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.example.mepositry;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;


/**
 * Created by louisgeek on 2018/9/21.
 */
public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViewSparseArray = new SparseArray<>();
    protected View mItemView;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
    }

    public <T extends View> T findBindItemView(int viewId) {
        View view = mViewSparseArray.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViewSparseArray.put(viewId, view);
        }
        return (T) view;

    }

}