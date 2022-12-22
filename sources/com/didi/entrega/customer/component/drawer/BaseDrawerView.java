package com.didi.entrega.customer.component.drawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public abstract class BaseDrawerView<P extends CustomerRecyclerPresenter> extends CustomerRecyclerView<P> implements IDrawer {
    /* access modifiers changed from: protected */
    public abstract BottomSheetBehavior getBehavior();

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    public void collapseDrawer() {
        if (getBehavior() != null) {
            getBehavior().setState(4);
        }
    }

    public void expandDrawer() {
        if (getBehavior() != null) {
            getBehavior().setState(3);
        }
    }

    public void hideDrawerEntrance() {
        if (getBehavior() != null) {
            getBehavior().setHideable(true);
        }
    }

    public boolean isCollapse() {
        if (getBehavior() == null || getBehavior().getState() == 4) {
            return true;
        }
        return false;
    }

    public boolean isExpand() {
        if (getBehavior() != null && getBehavior().getState() == 3) {
            return true;
        }
        return false;
    }

    public boolean isShowDrawerEntrance() {
        if (getBehavior() == null) {
            return false;
        }
        return !getBehavior().isHideable();
    }

    public void showDrawerEntrance() {
        if (getBehavior() != null) {
            getBehavior().setHideable(false);
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(getLayoutId(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public <V extends View> V findViewById(int i) {
        if (getView() != null) {
            return getView().findViewById(i);
        }
        return null;
    }
}
