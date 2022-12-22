package com.didi.soda.customer.mvp.loadmore;

import android.content.Context;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.foundation.rpc.entity.NoMoreLoginEntity;

public class LoadMoreModel {
    public NoMoreLoginEntity loginEntity;
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
