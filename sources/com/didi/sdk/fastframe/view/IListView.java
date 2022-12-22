package com.didi.sdk.fastframe.view;

public interface IListView extends IView {
    public static final int PAGE_SIZE = 10;

    void loadComplete();

    void refreshComplete();
}
