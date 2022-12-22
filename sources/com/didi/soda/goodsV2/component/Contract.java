package com.didi.soda.goodsV2.component;

import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.widget.scroll.SmoothScrollListener;
import com.didi.soda.goodsV2.contract.GoodsSubItemStateChangeListener;

interface Contract {

    public static abstract class AbsGoodsPresenter<T extends AbsGoodsView> extends CustomerRecyclerPresenter<T> implements GoodsSubItemStateChangeListener {
        public abstract void onAddCartViewClicked(boolean z);

        public abstract void onCloseClicked();

        public /* synthetic */ void showRemindAnimation(String str) {
            GoodsSubItemStateChangeListener.CC.$default$showRemindAnimation(this, str);
        }
    }

    public static abstract class AbsGoodsView<T extends AbsGoodsPresenter> extends CustomerRecyclerView<T> {
        public abstract void anchorToUnSatisfiedContent(int i, SmoothScrollListener smoothScrollListener);

        public abstract void changeAddCartText(String str);

        public abstract void changeOfflinePrice(int i, int i2, String str);

        public abstract void disableAddCartAndEvent();

        public abstract void disableAddCartView();

        public abstract void enableAddCartView();

        public abstract void hideCartLoadingView();

        public abstract void refreshTitleBar(String str, float f);

        public abstract void showCartLoadingView();
    }
}
