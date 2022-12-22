package com.didi.dimina.starbox.p107ui.base;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;

/* renamed from: com.didi.dimina.starbox.ui.base.AbsViewBinder */
public abstract class AbsViewBinder<T> extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    public T data;
    private final View mView;

    public abstract void bind(T t);

    /* access modifiers changed from: protected */
    public abstract void getViews();

    /* access modifiers changed from: protected */
    public void onViewClick(View view, T t) {
    }

    public AbsViewBinder(final View view) {
        super(view);
        this.mView = view;
        getViews();
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AbsViewBinder absViewBinder = AbsViewBinder.this;
                absViewBinder.onViewClick(view, absViewBinder.data);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final View getView() {
        return this.mView;
    }

    public final <V extends View> V getView(int i) {
        return this.mView.findViewById(i);
    }

    public void bind(T t, int i) {
        bind(t);
    }

    public final void setData(T t) {
        this.data = t;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.mView.getContext();
    }
}
