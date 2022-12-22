package com.didi.dimina.container.p106ui.pickerview.adapter;

import com.didi.dimina.container.p106ui.wheelview.adapter.WheelAdapter;

/* renamed from: com.didi.dimina.container.ui.pickerview.adapter.NumericWheelAdapter */
public class NumericWheelAdapter implements WheelAdapter {

    /* renamed from: a */
    private final int f17580a;

    /* renamed from: b */
    private final int f17581b;

    public NumericWheelAdapter(int i, int i2) {
        this.f17580a = i;
        this.f17581b = i2;
    }

    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.f17580a + i);
    }

    public int getItemsCount() {
        return (this.f17581b - this.f17580a) + 1;
    }

    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f17580a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
