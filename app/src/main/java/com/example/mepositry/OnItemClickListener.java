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
 * Last modified 2019-05-09 02:18:47
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.example.mepositry;


import android.view.View;

/**
 * Created by classichu on 2016/3/19.
 */
public abstract class OnItemClickListener {
    public boolean onItemLongClick(View view, int position) {
        return false;
    }

    public abstract void onItemClick(View view, int position);
}
