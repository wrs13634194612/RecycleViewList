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
 * Last modified 2019-05-09 02:16:23
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.example.mepositry;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by louisgeek on 2018/9/21.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> implements IDataAccess<T> {
    protected List<T> mDataList = new ArrayList<>();

    protected abstract int setupItemLayoutId();

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(setupItemLayoutId(), parent, false);
        return new BaseRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseRecyclerViewHolder holder, final int position) {
        //抽象方法
        this.findBindView(position, holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    return mOnItemClickListener.onItemLongClick(v, position);
                }
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    protected abstract void findBindView(int position, BaseRecyclerViewHolder baseViewHolder);

    //clickable
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public List<T> getDataList() {
        return mDataList;
    }

    @Override
    public T getData(int position) {
        return mDataList.get(position);
    }

    @Override
    public void refreshDataList(List<T> dataList) {
        if (dataList == null) {
            return;
        }
        mDataList.clear();
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public void clearDataList() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    @Override
    public boolean addDataListAtStart(List<T> dataList) {
        if (dataList == null) {
            return false;
        }
        mDataList.addAll(0, dataList);
        notifyItemRangeInserted(0, dataList.size());
        return true;
    }

    @Override
    public boolean addDataListAtEnd(List<T> dataList) {
        if (dataList == null) {
            return false;
        }
        int positionStart = mDataList.size();
        mDataList.addAll(dataList);
        notifyItemRangeInserted(positionStart, dataList.size());
        return true;
    }

    @Override
    public boolean addData(int position, T data) {
        if (data == null) {
            return false;
        }
        mDataList.add(data);
        notifyItemInserted(position);
        return true;
    }

    @Override
    public boolean addDataAtStart(T data) {
        if (data == null) {
            return false;
        }
        mDataList.add(0, data);
        notifyItemInserted(0);
        return true;
    }

    @Override
    public boolean addDataAtEnd(T data) {
        if (data == null) {
            return false;
        }
        int positionStart = mDataList.size();
        mDataList.add(data);
        notifyItemInserted(positionStart);
        return true;
    }

    @Override
    public boolean removeData(int position) {
        boolean result = false;
        T d = mDataList.remove(position);
        if (d != null) {
            result = true;
            notifyItemRemoved(position);
        }
        return result;
    }

    @Override
    public boolean removeData(T data) {
        if (data == null) {
            return false;
        }
        boolean result = false;
        int index = mDataList.indexOf(data);
        if (index > 0) {
            result = this.removeData(index);
        }
        return result;
    }

    @Override
    public boolean replaceData(int locationPos, T data) {
        if (data == null) {
            return false;
        }
        boolean result = false;
        T d = mDataList.set(locationPos, data);
        if (d != null) {
            result = true;
            notifyItemChanged(locationPos);
        }
        return result;
    }

    @Override
    public boolean replaceData(T oldData, T data) {
        if (oldData == null || data == null) {
            return false;
        }
        boolean result = false;
        int index = mDataList.indexOf(oldData);
        if (index > 0) {
            result = this.replaceData(index, data);
        }
        return result;
    }
}
