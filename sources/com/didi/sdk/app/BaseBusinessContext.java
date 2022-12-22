package com.didi.sdk.app;

import android.content.Context;
import android.view.View;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class BaseBusinessContext implements IBizNavBarDelegate, IStatusBarDelegate, ITitleBarDelegate, Serializable, Observer {
    private IBizNavBarDelegate bizNavBarDelegate;
    private BroadcastReceiverManager broadcastReceiverManager;
    private Context mContext;
    private INavigation mNavigation;
    private IStatusBarDelegate statusBarDelegate;
    private ITitleBarDelegate titleBarDelegate;

    public void update(Observable observable, Object obj) {
    }

    /* access modifiers changed from: package-private */
    public void assemble(Context context, INavigation iNavigation, ITitleBarDelegate iTitleBarDelegate, IStatusBarDelegate iStatusBarDelegate, IBizNavBarDelegate iBizNavBarDelegate) {
        this.mContext = context;
        this.mNavigation = iNavigation;
        this.titleBarDelegate = iTitleBarDelegate;
        this.statusBarDelegate = iStatusBarDelegate;
        this.bizNavBarDelegate = iBizNavBarDelegate;
    }

    public Context getContext() {
        return this.mContext;
    }

    public BroadcastReceiverManager getReceiverManager() {
        if (this.broadcastReceiverManager == null) {
            this.broadcastReceiverManager = new BroadcastReceiverManagerImpl(this);
        }
        return this.broadcastReceiverManager;
    }

    public boolean isInHomePage() {
        return BusinessContextManager.getInstance().isInHomePage();
    }

    public INavigation getNavigation() {
        return this.mNavigation;
    }

    public void hideTitleBar() {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.hideTitleBar();
        }
    }

    public void restoreTitleBar() {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.restoreTitleBar();
        }
    }

    public void updateTitleBarLeftBtn(int i, View.OnClickListener onClickListener) {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.updateTitleBarLeftBtn(i, onClickListener);
        }
    }

    public void hideTitleBarRightBtn() {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.hideTitleBarRightBtn();
        }
    }

    public void addViewToRightRegion(View view) {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.addViewToRightRegion(view);
        }
    }

    public void resetTitleBarYPosition(int i) {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.resetTitleBarYPosition(i);
        }
    }

    public void resetTitleBarAlpha(float f) {
        ITitleBarDelegate iTitleBarDelegate = this.titleBarDelegate;
        if (iTitleBarDelegate != null) {
            iTitleBarDelegate.resetTitleBarAlpha(f);
        }
    }

    public void changedStatusBar(boolean z) {
        this.statusBarDelegate.changedStatusBar(z);
    }

    public void showBizBar() {
        IBizNavBarDelegate iBizNavBarDelegate = this.bizNavBarDelegate;
        if (iBizNavBarDelegate != null) {
            iBizNavBarDelegate.showBizBar();
        }
    }

    public void hideBizBar() {
        IBizNavBarDelegate iBizNavBarDelegate = this.bizNavBarDelegate;
        if (iBizNavBarDelegate != null) {
            iBizNavBarDelegate.hideBizBar();
        }
    }

    public int getBizBarHeight() {
        IBizNavBarDelegate iBizNavBarDelegate = this.bizNavBarDelegate;
        if (iBizNavBarDelegate != null) {
            return iBizNavBarDelegate.getBizBarHeight();
        }
        return 0;
    }

    public void showBizBarDivider() {
        IBizNavBarDelegate iBizNavBarDelegate = this.bizNavBarDelegate;
        if (iBizNavBarDelegate != null) {
            iBizNavBarDelegate.showBizBarDivider();
        }
    }

    public void hideBizBarDivider() {
        IBizNavBarDelegate iBizNavBarDelegate = this.bizNavBarDelegate;
        if (iBizNavBarDelegate != null) {
            iBizNavBarDelegate.hideBizBarDivider();
        }
    }

    public void setBizBarBackgroundColor(int i) {
        IBizNavBarDelegate iBizNavBarDelegate = this.bizNavBarDelegate;
        if (iBizNavBarDelegate != null) {
            iBizNavBarDelegate.setBizBarBackgroundColor(i);
        }
    }
}
