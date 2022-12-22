package com.didi.app.nova.support.view.recyclerview.binder;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class StaggerItemViewHolder<T> extends ItemViewHolder<T> {
    /* access modifiers changed from: protected */
    public boolean needFullSpan() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean useStaggerLayout() {
        return true;
    }

    public StaggerItemViewHolder(View view) {
        super(view);
        if (useStaggerLayout() && needFullSpan()) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            layoutParams.setFullSpan(true);
            view.setLayoutParams(layoutParams);
        }
    }
}
