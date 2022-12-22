package com.didi.sdk.fastframe.view.fastlistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.didi.sdk.fastframe.view.fastlistview.ListItemBase;
import java.util.HashSet;
import java.util.List;

public abstract class CommonAdapter<T extends ListItemBase> extends BaseAdapter {

    /* renamed from: a */
    private C12206a f35930a;
    protected Context mContext;
    protected List<T> mData;
    protected SparseArray<Integer> mTypeMap = new SparseArray<>();

    public abstract void assemble(T t, int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public CommonAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mData = list;
        m25441a(list);
    }

    public void refreshView(List<T> list) {
        this.mData = list;
        this.mTypeMap.clear();
        m25441a(list);
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return this.mData;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        this.f35930a = C12206a.m25442a(this.mContext, view, viewGroup, getItem(i).getLayoutId());
        assemble(getItem(i), i);
        return this.f35930a.mo91715a();
    }

    public int getViewTypeCount() {
        return Math.max(this.mTypeMap.size(), 1);
    }

    public int getItemViewType(int i) {
        if (getItem(i) == null) {
            return -1;
        }
        return this.mTypeMap.get(getItem(i).getLayoutId()).intValue();
    }

    public int getCount() {
        List<T> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i) {
        List<T> list = this.mData;
        if (list == null) {
            return null;
        }
        return (ListItemBase) list.get(i);
    }

    /* access modifiers changed from: protected */
    public View findViewById(int i) {
        C12206a aVar = this.f35930a;
        if (aVar == null) {
            return null;
        }
        return aVar.mo91716a(i);
    }

    /* renamed from: a */
    private void m25441a(List<T> list) {
        if (list != null) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (T layoutId : list) {
                hashSet.add(Integer.valueOf(layoutId.getLayoutId()));
            }
            int i = 0;
            for (Integer intValue : hashSet) {
                this.mTypeMap.put(intValue.intValue(), Integer.valueOf(i));
                i++;
            }
        }
    }
}
