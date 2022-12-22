package com.didi.rfusion.widget.tab;

import android.content.Context;
import java.util.List;

public abstract class RFTabAdapter<T> {
    private Context mContext;

    public abstract List<T> getData();

    public abstract int getItemCount();

    public abstract IRFTab<T> getItemView();

    public RFTabAdapter(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }
}
