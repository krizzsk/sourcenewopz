package com.didi.component.common.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;

public abstract class AbsViewBinder<T> extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    public T data;
    private View mView;

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

    public <V extends View> V getView(int i) {
        return this.mView.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public void setData(T t) {
        this.data = t;
    }
}
