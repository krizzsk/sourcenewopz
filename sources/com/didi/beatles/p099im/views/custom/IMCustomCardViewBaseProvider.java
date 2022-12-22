package com.didi.beatles.p099im.views.custom;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.didi.beatles.p099im.access.msg.IMMessageTraffic;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;

/* renamed from: com.didi.beatles.im.views.custom.IMCustomCardViewBaseProvider */
public abstract class IMCustomCardViewBaseProvider {

    /* renamed from: a */
    private SparseArray<IMMessage> f10157a;

    /* renamed from: b */
    private SparseArray<IMMessageTraffic> f10158b;
    protected IMCradViewStatusCallback mCallBack;

    public abstract void bindData(int i, View view, String str);

    public abstract View getView(Context context, View view, int i);

    /* access modifiers changed from: protected */
    public void onBindData(int i, View view, String str, IMMessage iMMessage, IMRenderCardEnv iMRenderCardEnv) {
    }

    public final void bindData(int i, View view, String str, IMMessage iMMessage, IMRenderCardEnv iMRenderCardEnv) {
        if (this.f10157a == null) {
            this.f10157a = new SparseArray<>();
        }
        this.f10157a.put(i, iMMessage);
        SparseArray<IMMessageTraffic> sparseArray = this.f10158b;
        if (sparseArray != null) {
            sparseArray.remove(i);
        }
        bindData(i, view, str);
        onBindData(i, view, str, iMMessage, iMRenderCardEnv);
    }

    public void setCardViewStatusCallback(IMCradViewStatusCallback iMCradViewStatusCallback) {
        this.mCallBack = iMCradViewStatusCallback;
    }

    public void removeCardViewStatusCallback(IMCradViewStatusCallback iMCradViewStatusCallback) {
        this.mCallBack = null;
    }

    public void clear() {
        this.f10157a = null;
        this.f10158b = null;
    }

    /* access modifiers changed from: protected */
    public IMMessageTraffic findCardMessage(int i) {
        IMMessageTraffic iMMessageTraffic;
        if (this.f10157a == null) {
            return null;
        }
        SparseArray<IMMessageTraffic> sparseArray = this.f10158b;
        if (sparseArray != null && (iMMessageTraffic = sparseArray.get(i)) != null) {
            return iMMessageTraffic;
        }
        IMMessage iMMessage = this.f10157a.get(i);
        if (iMMessage == null) {
            return null;
        }
        IMMessageTraffic a = m6926a(iMMessage);
        if (this.f10158b == null) {
            this.f10158b = new SparseArray<>();
        }
        this.f10158b.put(i, a);
        return a;
    }

    /* renamed from: a */
    private IMMessageTraffic m6926a(IMMessage iMMessage) {
        return new IMMessageTraffic(iMMessage.getMid(), iMMessage.getSid());
    }
}
