package com.didi.entrega.customer.component.drawer;

public interface IDrawer {
    void collapseDrawer();

    void expandDrawer();

    void hideDrawerEntrance();

    boolean isCollapse();

    boolean isExpand();

    boolean isShowDrawerEntrance();

    void showDrawerEntrance();
}
