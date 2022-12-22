package com.bigkoo.pickerview.adapter;

import com.contrarywind.adapter.WheelAdapter;
import java.util.List;

public class ArrayWheelAdapter<T> implements WheelAdapter {

    /* renamed from: a */
    private List<T> f2070a;

    public ArrayWheelAdapter(List<T> list) {
        this.f2070a = list;
    }

    public Object getItem(int i) {
        return (i < 0 || i >= this.f2070a.size()) ? "" : this.f2070a.get(i);
    }

    public int getItemsCount() {
        return this.f2070a.size();
    }

    public int indexOf(Object obj) {
        return this.f2070a.indexOf(obj);
    }
}
