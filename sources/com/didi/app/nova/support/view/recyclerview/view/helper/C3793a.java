package com.didi.app.nova.support.view.recyclerview.view.helper;

import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;

/* renamed from: com.didi.app.nova.support.view.recyclerview.view.helper.a */
/* compiled from: NovaTouchHelper */
abstract class C3793a implements RecyclerView.OnItemTouchListener {
    protected static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int DOWN = 2;
    public static final int INFINITE = -1;
    public static final int LEFT = 4;
    public static final int NONE = 0;
    public static final int RIGHT = 8;

    /* renamed from: UP */
    public static final int f8635UP = 1;
    protected float mDx;
    protected float mDy;
    protected float mInitialTouchX;
    protected float mInitialTouchY;
    protected NovaRecyclerView mRecyclerView;
    protected int mSlop;
    protected final float[] mTmpPosition = new float[2];

    /* access modifiers changed from: protected */
    public void onAttachToRecyclerView(NovaRecyclerView novaRecyclerView) {
    }

    /* access modifiers changed from: protected */
    public void onDetachToRecyclerView(NovaRecyclerView novaRecyclerView) {
    }

    C3793a() {
    }

    public void attachToRecyclerView(NovaRecyclerView novaRecyclerView) {
        if (this.mRecyclerView != novaRecyclerView) {
            detachToRecyclerView();
            this.mRecyclerView = novaRecyclerView;
            if (novaRecyclerView != null) {
                this.mSlop = ViewConfiguration.get(novaRecyclerView.getContext()).getScaledTouchSlop();
                this.mRecyclerView.addOnItemTouchListener(this);
                onAttachToRecyclerView(novaRecyclerView);
            }
        }
    }

    public void detachToRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.mRecyclerView;
        if (novaRecyclerView != null) {
            novaRecyclerView.removeOnItemTouchListener(this);
            onDetachToRecyclerView(this.mRecyclerView);
        }
        this.mRecyclerView = null;
    }
}
