package com.didi.addressnew.widget;

import java.io.Serializable;

public class EmptyViewItem<T> implements Serializable {
    public static final int TYPE_INFO = 3;
    public static final int TYPE_START = 1;
    public static final int TYPE_TIP = 2;
    public T address;
    public int emptyViewType = 3;

    public EmptyViewItem(int i) {
        this.emptyViewType = i;
    }

    public EmptyViewItem(T t) {
        if (t != null) {
            this.emptyViewType = 3;
            this.address = t;
            return;
        }
        this.emptyViewType = 2;
    }

    public EmptyViewItem(int i, T t) {
        if (t != null) {
            this.emptyViewType = i;
            this.address = t;
            return;
        }
        this.emptyViewType = 2;
    }
}
