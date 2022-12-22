package com.didi.sdk.fastframe.view.fastlistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.didi.sdk.fastframe.view.fastlistview.a */
/* compiled from: ViewHolder */
class C12206a {

    /* renamed from: a */
    private SparseArray<View> f35931a = new SparseArray<>();

    /* renamed from: b */
    private View f35932b;

    private C12206a(Context context, ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
        this.f35932b = inflate;
        inflate.setTag(this);
    }

    /* renamed from: a */
    static C12206a m25442a(Context context, View view, ViewGroup viewGroup, int i) {
        if (view == null) {
            return new C12206a(context, viewGroup, i);
        }
        return (C12206a) view.getTag();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo91716a(int i) {
        View view = this.f35931a.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.f35932b.findViewById(i);
        this.f35931a.put(i, findViewById);
        return findViewById;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo91715a() {
        return this.f35932b;
    }
}
