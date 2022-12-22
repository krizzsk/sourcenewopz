package com.didi.dimina.container.p106ui.pickerview.adapter;

import com.didi.dimina.container.p106ui.wheelview.adapter.WheelAdapter;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.adapter.ArrayWheelAdapter */
public class ArrayWheelAdapter<T> implements WheelAdapter {

    /* renamed from: a */
    private final List<T> f17579a;

    public ArrayWheelAdapter(List<T> list) {
        this.f17579a = list;
    }

    public Object getItem(int i) {
        return (i < 0 || i >= this.f17579a.size()) ? "" : this.f17579a.get(i);
    }

    public int getItemsCount() {
        return this.f17579a.size();
    }

    public int indexOf(Object obj) {
        return this.f17579a.indexOf(obj);
    }
}
