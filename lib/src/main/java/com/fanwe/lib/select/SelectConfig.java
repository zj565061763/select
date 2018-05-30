/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.select;

import android.view.View;

import com.fanwe.lib.select.properties.ImageViewProperties;
import com.fanwe.lib.select.properties.TextViewProperties;
import com.fanwe.lib.select.properties.ViewProperties;

/**
 * View的状态参数配置
 */
public interface SelectConfig
{
    /**
     * 配置某个View
     *
     * @param initer
     * @return
     */
    SelectConfig configView(PropertiesIniter<ViewProperties> initer);

    /**
     * 配置某个TextView
     *
     * @param initer
     * @return
     */
    SelectConfig configTextView(PropertiesIniter<TextViewProperties> initer);

    /**
     * 配置某个ImageView
     *
     * @param initer
     * @return
     */
    SelectConfig configImageView(PropertiesIniter<ImageViewProperties> initer);

    /**
     * 清空配置
     *
     * @return
     */
    SelectConfig clear();

    /**
     * 设置view是否选中
     *
     * @param selected
     * @param view
     */
    void setSelected(boolean selected, View view);

    interface PropertiesIniter<T extends ViewProperties>
    {
        void init(T normal, T selected);
    }
}