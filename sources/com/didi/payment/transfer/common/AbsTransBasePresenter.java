package com.didi.payment.transfer.common;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.common.IPageView;

public abstract class AbsTransBasePresenter<PageView extends IPageView> extends IPresenter<PageView> {
    protected Context mContext;
    /* access modifiers changed from: protected */
    public PageView mPageView;

    public void onActivityResult(int i, int i2) {
    }

    public void onBackPressed() {
    }

    public void onCreate() {
    }

    public void onPause() {
    }

    public void onRemove() {
    }

    public void onStop() {
    }

    public AbsTransBasePresenter(Context context, PageView pageview) {
        this.mContext = context;
        if (pageview != null) {
            this.mPageView = pageview;
            return;
        }
        throw new IllegalArgumentException("PageView must be not empty!");
    }

    public void onAdd() {
        DebugUtil.log("AbsBaseFragment#onAdd()", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    public FragmentManager getFragmentMgr() {
        Context context = this.mContext;
        if (context != null && (context instanceof FragmentActivity)) {
            return ((FragmentActivity) context).getSupportFragmentManager();
        }
        return null;
    }

    public void showPageLoadding() {
        this.mPageView.onShowPageLoadding();
    }

    public void dismissPageLoadding() {
        this.mPageView.onDismissPageLoadding();
    }

    public void setPageView(PageView pageview) {
        this.mPageView = pageview;
    }
}
