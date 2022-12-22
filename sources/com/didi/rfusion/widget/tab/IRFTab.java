package com.didi.rfusion.widget.tab;

public interface IRFTab<T> {
    void bindData(T t);

    void setSelectedState(boolean z);

    void setTabBarSpec(int i);
}
