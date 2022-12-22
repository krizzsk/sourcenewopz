package com.android.didi.safetoolkit.widget.topbarview.adapter;

import android.app.Activity;
import android.database.Observable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.android.didi.safetoolkit.MyObserver;
import java.util.Iterator;

public abstract class BaseTopBarAdapter extends Observable<MyObserver> {
    protected Activity mActivity;

    public abstract View getCenterView(View view, ViewGroup viewGroup);

    public abstract View getLeftView(View view, ViewGroup viewGroup);

    public abstract View getRightView(View view, ViewGroup viewGroup);

    public BaseTopBarAdapter(Activity activity) {
        this.mActivity = activity;
    }

    public void notifyDataSetChanged() {
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            MyObserver myObserver = (MyObserver) it.next();
            myObserver.onChanged(-1);
            myObserver.onInvalidated(-1);
        }
    }

    public void notifyItemChanged(int i) {
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            MyObserver myObserver = (MyObserver) it.next();
            myObserver.onChanged(i);
            myObserver.onInvalidated(i);
        }
    }

    /* access modifiers changed from: protected */
    public int dip2px(int i) {
        Activity activity = this.mActivity;
        if (activity == null || activity.getResources() == null) {
            return 0;
        }
        return (int) TypedValue.applyDimension(1, (float) i, this.mActivity.getResources().getDisplayMetrics());
    }
}
