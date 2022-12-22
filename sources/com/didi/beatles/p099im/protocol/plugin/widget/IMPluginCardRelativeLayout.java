package com.didi.beatles.p099im.protocol.plugin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.beatles.p099im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p099im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.protocol.plugin.widget.IMPluginCardRelativeLayout */
public abstract class IMPluginCardRelativeLayout extends RelativeLayout implements IIMPluginCardView {

    /* renamed from: a */
    private int f9577a;

    /* renamed from: b */
    private IMMessageViewStatusCallback f9578b;

    public abstract boolean isShowInMiddle();

    public abstract void onBindData(String str);

    public abstract void onCardClick(View view);

    public IMPluginCardRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPluginCardRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPluginCardRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9577a = -1;
    }

    public final void onBind(int i, IMRenderCardEnv iMRenderCardEnv, String str, IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.f9577a = i;
        this.f9578b = iMMessageViewStatusCallback;
        onBindData(str);
    }

    /* access modifiers changed from: protected */
    public final void executeUpdateData(String str) {
        int i;
        IMMessageViewStatusCallback iMMessageViewStatusCallback = this.f9578b;
        if (iMMessageViewStatusCallback == null || (i = this.f9577a) == -1) {
            String simpleName = getClass().getSimpleName();
            IMLog.m6632e(simpleName, "[executeUpdateData] invalid callback or position. position=" + this.f9577a);
            return;
        }
        iMMessageViewStatusCallback.onUpdate(i, str);
    }

    /* access modifiers changed from: protected */
    public final void executeDeleteMessage() {
        int i;
        IMMessageViewStatusCallback iMMessageViewStatusCallback = this.f9578b;
        if (iMMessageViewStatusCallback == null || (i = this.f9577a) == -1) {
            String simpleName = getClass().getSimpleName();
            IMLog.m6632e(simpleName, "[executeDeleteMessage] invalid callback or position. position=" + this.f9577a);
            return;
        }
        iMMessageViewStatusCallback.deleteMessage(i);
    }
}
