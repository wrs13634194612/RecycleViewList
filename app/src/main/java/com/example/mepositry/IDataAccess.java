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
 * Last modified 2019-05-09 02:18:05
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.example.mepositry;

import java.util.List;

/**
 * Created by louisgeek on 2018/9/21.
 */
public interface IDataAccess<T> {
    List<T> getDataList();

    T getData(int position);

    boolean addDataListAtStart(List<T> dataList);

    boolean addDataListAtEnd(List<T> dataList);

    void refreshDataList(List<T> dataList);

    void clearDataList();

    boolean addData(int position, T data);

    boolean addDataAtStart(T data);

    boolean addDataAtEnd(T data);

    boolean removeData(int position);

    boolean removeData(T data);

    boolean replaceData(int locationPos, T data);

    boolean replaceData(T oldData, T data);
}
