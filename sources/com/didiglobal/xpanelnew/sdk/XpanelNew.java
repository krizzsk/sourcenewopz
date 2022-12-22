package com.didiglobal.xpanelnew.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.base.XpOmegaConfig;
import com.didiglobal.xpanelnew.callback.IXpCallback;
import com.didiglobal.xpanelnew.callback.IXpView;
import com.didiglobal.xpanelnew.message.IXpMessageContainer;
import com.didiglobal.xpanelnew.view.XpanelView;
import java.util.List;

public class XpanelNew implements IXpView, IXpanelNew {

    /* renamed from: a */
    private Context f51625a;

    /* renamed from: b */
    private XpanelView f51626b;

    public void destroy() {
    }

    public XpanelNew(Activity activity, XpConfig xpConfig) {
        this.f51625a = activity;
        XpanelView xpanelView = new XpanelView(activity);
        this.f51626b = xpanelView;
        xpanelView.init(xpConfig);
    }

    public void setData(List<XpCardProperty> list) {
        this.f51626b.setData(list);
    }

    public void addCard(XpCardProperty xpCardProperty, int i) {
        this.f51626b.addCard(xpCardProperty, i);
    }

    public void removeCard(int i) {
        this.f51626b.removeCard(i);
    }

    public void setData(List<XpCardProperty> list, boolean z) {
        this.f51626b.setDataWithAnimator(list, z);
    }

    public void setXpScrollEnabled(boolean z) {
        XpanelView xpanelView = this.f51626b;
        if (xpanelView != null) {
            xpanelView.setXpScrollEnabled(z);
        }
    }

    public View getView() {
        return this.f51626b.getView();
    }

    public IXpMessageContainer getMessageContainer() {
        return this.f51626b.getMessageContainer();
    }

    public void setTitle(String str) {
        this.f51626b.setTitle(str);
    }

    public void refreshMsgHeight() {
        this.f51626b.refreshMsgHeight();
    }

    public void setConfig(XpConfig xpConfig) {
        this.f51626b.setConfig(xpConfig);
    }

    public void setOmegaConfig(XpOmegaConfig xpOmegaConfig) {
        this.f51626b.setOmegaConfig(xpOmegaConfig);
    }

    public void setShowOneCard() {
        this.f51626b.setShowOneCard();
    }

    public int getFirstCardHeight() {
        return this.f51626b.getFirstCardHeight();
    }

    public int getMessageRealHeight() {
        return this.f51626b.getMessageRealHeight();
    }

    public void fistCardHeightChange(int i) {
        this.f51626b.fistCardHeightChange(i);
    }

    public void firstCardHeightWillChangeTo(XpConfig xpConfig) {
        this.f51626b.firstCardHeightWillChangeTo(xpConfig);
    }

    public void cardHeightChange(int i, int i2) {
        this.f51626b.cardHeightChange(i, i2);
    }

    public void onResume() {
        this.f51626b.onResume();
    }

    public void onPause() {
        this.f51626b.onPause();
    }

    public void setXpCallback(IXpCallback iXpCallback) {
        this.f51626b.setXpCallback(iXpCallback);
    }
}
