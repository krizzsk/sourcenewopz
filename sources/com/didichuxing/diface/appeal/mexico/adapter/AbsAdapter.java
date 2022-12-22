package com.didichuxing.diface.appeal.mexico.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.diface.appeal.mexico.adapter.ViewHolder;
import com.google.p217ar.core.ImageMetadata;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsAdapter<T, H extends ViewHolder> extends BaseAdapter {

    /* renamed from: a */
    private List<T> f47075a = new ArrayList();

    /* renamed from: b */
    private final LayoutInflater f47076b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemClickListener<T> f47077c;

    /* access modifiers changed from: protected */
    public abstract void bindViewHolder(H h, int i, T t);

    /* access modifiers changed from: protected */
    public abstract H createViewHolder(View view);

    /* access modifiers changed from: protected */
    public int getDescendantFocusability() {
        return ImageMetadata.HOT_PIXEL_MODE;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* access modifiers changed from: protected */
    public abstract int getLayout();

    public AbsAdapter(Context context) {
        this.f47076b = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.f47077c = onItemClickListener;
    }

    public void addAllItem(List<T> list, boolean z) {
        if (z) {
            this.f47075a.clear();
        }
        this.f47075a.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(T t, boolean z) {
        if (z) {
            this.f47075a.clear();
        }
        this.f47075a.add(t);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f47075a.size();
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.f47075a.size()) {
            return null;
        }
        return this.f47075a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            try {
                view = this.f47076b.inflate(getLayout(), (ViewGroup) null, false);
                viewHolder = createViewHolder(view);
                view.setTag(viewHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Object item = getItem(i);
        bindViewHolder(viewHolder, i, item);
        m33740a(view, i, item);
        return view;
    }

    /* renamed from: a */
    private void m33740a(View view, final int i, final T t) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setDescendantFocusability(getDescendantFocusability());
            }
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (AbsAdapter.this.f47077c != null) {
                        AbsAdapter.this.f47077c.onClick(view, i, t);
                    }
                }
            });
        }
    }
}
