package com.didi.entrega.customer.mvp.loadmore;

import android.content.Context;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.component.feed.base.FooterViewIView;

public class LoadMoreModel {
    public String mDescription;
    public boolean mIsBottomStubShow;
    public boolean mIsCartStubShow;
    public FooterViewIView.Mode mLoadMoreViewMode = FooterViewIView.Mode.SIMPLE;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public int mState = 0;
    public int mStubHeight;

    public LoadMoreModel(Context context) {
        this.mPaddingTop = DisplayUtils.dip2px(context, 30.0f);
        this.mPaddingBottom = DisplayUtils.dip2px(context, 30.0f);
    }
}
