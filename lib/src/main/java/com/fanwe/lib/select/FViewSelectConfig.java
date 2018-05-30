package com.fanwe.lib.select;

import android.view.View;

import com.fanwe.lib.select.properties.FViewProperties;
import com.fanwe.lib.select.properties.ImageViewProperties;
import com.fanwe.lib.select.properties.TextViewProperties;
import com.fanwe.lib.select.properties.ViewProperties;

public class FViewSelectConfig implements ViewSelectConfig
{
    private ViewProperties mPropertiesNormal;
    private ViewProperties mPropertiesSelected;

    @Override
    public ViewSelectConfig configView(PropertiesIniter<ViewProperties> initer)
    {
        mPropertiesNormal = mPropertiesNormal != null ?
                mPropertiesNormal : FViewProperties.ofView();

        mPropertiesSelected = mPropertiesSelected != null ?
                mPropertiesSelected : FViewProperties.ofView();

        initer.init(mPropertiesNormal, mPropertiesSelected);
        return this;
    }

    @Override
    public ViewSelectConfig configTextView(PropertiesIniter<TextViewProperties> initer)
    {
        mPropertiesNormal = mPropertiesNormal instanceof TextViewProperties ?
                mPropertiesNormal : FViewProperties.ofTextView();

        mPropertiesSelected = mPropertiesSelected instanceof TextViewProperties ?
                mPropertiesSelected : FViewProperties.ofTextView();

        initer.init((TextViewProperties) mPropertiesNormal, (TextViewProperties) mPropertiesSelected);
        return this;
    }

    @Override
    public ViewSelectConfig configImageView(PropertiesIniter<ImageViewProperties> initer)
    {
        mPropertiesNormal = mPropertiesNormal instanceof ImageViewProperties ?
                mPropertiesNormal : FViewProperties.ofImageView();

        mPropertiesSelected = mPropertiesSelected instanceof ImageViewProperties ?
                mPropertiesSelected : FViewProperties.ofImageView();

        initer.init((ImageViewProperties) mPropertiesNormal, (ImageViewProperties) mPropertiesSelected);
        return this;
    }

    @Override
    public ViewSelectConfig reset()
    {
        mPropertiesNormal = null;
        mPropertiesSelected = null;
        return this;
    }

    @Override
    public void setSelected(boolean selected, boolean invokeViewSelected, View view)
    {
        if (view == null)
            return;

        if (selected)
        {
            if (mPropertiesSelected != null)
                mPropertiesSelected.invoke(view);
        } else
        {
            if (mPropertiesNormal != null)
                mPropertiesNormal.invoke(view);
        }

        if (invokeViewSelected)
            view.setSelected(selected);
    }
}
