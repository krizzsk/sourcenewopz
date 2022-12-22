package com.bigkoo.pickerview.adapter;

import com.contrarywind.adapter.WheelAdapter;

public class NumericWheelAdapter implements WheelAdapter {

    /* renamed from: a */
    private int f2071a;

    /* renamed from: b */
    private int f2072b;

    public NumericWheelAdapter(int i, int i2) {
        this.f2071a = i;
        this.f2072b = i2;
    }

    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.f2071a + i);
    }

    public int getItemsCount() {
        return (this.f2072b - this.f2071a) + 1;
    }

    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f2071a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
