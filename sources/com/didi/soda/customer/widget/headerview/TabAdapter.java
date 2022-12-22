package com.didi.soda.customer.widget.headerview;

import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import java.util.List;

public abstract class TabAdapter<T> {
    public abstract List<T> getData();

    public abstract int getItemCount();

    public abstract ITab<T> getItemView(int i);
}
