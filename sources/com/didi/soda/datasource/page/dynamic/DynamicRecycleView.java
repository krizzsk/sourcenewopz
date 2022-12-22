package com.didi.soda.datasource.page.dynamic;

import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.datasource.page.dynamic.DynamicRecyclePresenter;
import com.didi.soda.home.topgun.binder.DynamicRecyclerBinder;
import com.didi.soda.home.topgun.widget.HomeDynamicBlockDecoration;
import com.taxis99.R;

public abstract class DynamicRecycleView<P extends DynamicRecyclePresenter> extends CustomerRecyclerView<P> {
    private DynamicRecyclerBinder mDynamicBinder;

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registBlockBinder();
    }

    private void registBlockBinder() {
        DynamicRecyclerBinder dynamicRecyclerBinder = new DynamicRecyclerBinder(((DynamicRecyclePresenter) getPresenter()).getScope());
        this.mDynamicBinder = dynamicRecyclerBinder;
        registerBinder(dynamicRecyclerBinder);
    }

    public void clearViewCachePool() {
        DynamicRecyclerBinder dynamicRecyclerBinder = this.mDynamicBinder;
        if (dynamicRecyclerBinder != null) {
            dynamicRecyclerBinder.clearCachePool();
        }
    }

    /* access modifiers changed from: protected */
    public ItemDecorator getBlockItemDecorator(float f) {
        HomeDynamicBlockDecoration homeDynamicBlockDecoration = new HomeDynamicBlockDecoration(ResourceHelper.getColor(R.color.rf_color_v2_grey2_10_a100), DisplayUtils.dip2px(getContext(), f));
        homeDynamicBlockDecoration.enablePositionTopDecorator();
        return homeDynamicBlockDecoration;
    }
}
