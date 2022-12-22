package com.didichuxing.xpanel.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didichuxing.xpanel.base.BorderRecyclerView;
import com.didichuxing.xpanel.base.IState;
import java.util.ArrayList;
import java.util.List;

public abstract class XPanelBaseView<T extends BorderRecyclerView, F extends LinearLayoutManager> implements IState.IStateChange, IXPanelViewPrivate {

    /* renamed from: a */
    private IStateChangeListener f49322a;
    /* access modifiers changed from: protected */
    public boolean mAppend;
    /* access modifiers changed from: protected */
    public T mCardRecyclerView;
    /* access modifiers changed from: protected */
    public Context mContext;
    /* access modifiers changed from: protected */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: protected */
    public F mLayoutManager;
    protected List<IState> mStateList = new ArrayList();

    public void onPause() {
    }

    public void onResume() {
    }

    public XPanelBaseView(Context context) {
        this.mContext = context;
    }

    public void destroy() {
        for (IState stateDestory : this.mStateList) {
            stateDestory.stateDestory();
        }
        this.mStateList.clear();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public void registerState(IState iState) {
        if (!this.mStateList.contains(iState)) {
            this.mStateList.add(iState);
            iState.stateBindChange(this);
        }
    }

    /* access modifiers changed from: protected */
    public void unRegisterState(IState iState) {
        this.mStateList.remove(iState);
        iState.stateDestory();
    }

    public void stateChange(IState iState) {
        int i = 0;
        for (IState state : this.mStateList) {
            i |= state.getState();
        }
        IStateChangeListener iStateChangeListener = this.f49322a;
        if (iStateChangeListener != null) {
            iStateChangeListener.onStateChanged(i);
        }
    }

    /* access modifiers changed from: protected */
    public void setStateListener(IStateChangeListener iStateChangeListener) {
        this.f49322a = iStateChangeListener;
    }
}
