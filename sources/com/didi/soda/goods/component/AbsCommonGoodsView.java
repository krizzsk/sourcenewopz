package com.didi.soda.goods.component;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.widget.goods.purchase.GoodsPurchaseBottomButton;
import com.didi.soda.customer.widget.scroll.CustomerSmoothScroller;
import com.didi.soda.customer.widget.scroll.SmoothScrollListener;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.goods.binder.EmptyHeightBinder;
import com.didi.soda.goods.binder.GoodsPurchaseContentBinder;
import com.didi.soda.goods.binder.GoodsPurchaseSubItemBinder;
import com.didi.soda.goods.binder.GoodsSelectAmountSubItemBinder;
import com.didi.soda.goods.component.AbsCommonGoodsPresenter;
import com.didi.soda.goods.component.Contract;

public abstract class AbsCommonGoodsView<T extends AbsCommonGoodsPresenter> extends Contract.AbsGoodsView<T> {
    @BindView(18450)
    protected IconTextView mBackView;
    @BindView(17926)
    protected GoodsPurchaseBottomButton mBottomButton;
    protected EmptyHeightBinder mEmptyHeightBinder;
    /* access modifiers changed from: private */
    public boolean mIsCartEnabled;
    @BindView(17981)
    protected NovaRecyclerView mRecyclerView;
    protected CustomerSmoothScroller mSmoothScroller;
    @BindView(18190)
    protected FrameLayout mStickyHeaderContainer;
    @BindView(19138)
    protected CustomerAppCompatTextView mTitleTvView;
    @BindView(18725)
    protected FrameLayout mTitleView;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    public void anchorToUnSatisfiedContent(int i, final SmoothScrollListener smoothScrollListener) {
        this.mSmoothScroller.setSmoothScrollListener(new SmoothScrollListener() {
            public void onStart() {
                SmoothScrollListener smoothScrollListener = smoothScrollListener;
                if (smoothScrollListener != null) {
                    smoothScrollListener.onStart();
                }
            }

            public void onStop() {
                SmoothScrollListener smoothScrollListener = smoothScrollListener;
                if (smoothScrollListener != null) {
                    smoothScrollListener.onStop();
                    AbsCommonGoodsView.this.mSmoothScroller.setSmoothScrollListener((SmoothScrollListener) null);
                }
            }
        });
        this.mRecyclerView.smoothScrollToPosition(i);
    }

    public void changeAddCartText(String str) {
        this.mBottomButton.changeAddCartText(str);
    }

    public void refreshTitleBar(String str, float f) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitleTvView.setText(str);
        }
        this.mTitleTvView.setAlpha(f);
    }

    public void disableAddCartAndEvent() {
        this.mBottomButton.setOnTouchListener((View.OnTouchListener) null);
        this.mBottomButton.setOnClickListener((View.OnClickListener) null);
        this.mBottomButton.disableAddCartView();
        this.mIsCartEnabled = false;
    }

    public void disableAddCartView() {
        setBottomClickEvent();
        this.mBottomButton.disableAddCartView();
        this.mIsCartEnabled = false;
    }

    public void enableAddCartView() {
        setBottomClickEvent();
        this.mBottomButton.enableAddCartView();
        this.mIsCartEnabled = true;
    }

    public void onCreate() {
        super.onCreate();
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).onCloseClicked();
            }
        });
        setBottomClickEvent();
        this.mRecyclerView.setDescendantFocusability(131072);
        this.mRecyclerView.setFocusable(true);
        this.mRecyclerView.setFocusableInTouchMode(true);
        this.mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.requestFocusFromTouch();
                return false;
            }
        });
    }

    public void showCartLoadingView() {
        DialogUtil.showBlockDialog(getScopeContext());
        this.mBottomButton.showCartLoadingView();
    }

    public void hideCartLoadingView() {
        DialogUtil.hideBlockDialog();
        this.mBottomButton.hideCartLoadingView();
    }

    public void changeOfflinePrice(int i, int i2, String str) {
        this.mBottomButton.changeOfflinePrice(i, i2, str);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new EmptyHeightBinder());
        registerBinder(new GoodsPurchaseContentBinder());
        registerBinder(new GoodsPurchaseSubItemBinder(((AbsCommonGoodsPresenter) getPresenter()).provideComponentLogicUnit()) {
            public boolean canSubItemSelected(String str) {
                return ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).canSubItemSelected(str);
            }

            public void onSelectionStateChanged(String str, String str2, boolean z) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).onSelectionStateChanged(str, str2, z);
            }

            public void resetSelectionState(String str, boolean z) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).resetSelectionState(str, z);
            }

            public void showRemindAnimation(String str) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).showRemindAnimation(str);
            }
        });
        registerBinder(new GoodsSelectAmountSubItemBinder(((AbsCommonGoodsPresenter) getPresenter()).provideComponentLogicUnit()) {
            public boolean canSubItemSelected(String str) {
                return ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).canSubItemSelected(str);
            }

            public void onSelectionStateChanged(String str, String str2, boolean z) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).onSelectionStateChanged(str, str2, z);
            }

            public void resetSelectionState(String str, boolean z) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).resetSelectionState(str, z);
            }

            public void showRemindAnimation(String str) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).showRemindAnimation(str);
            }
        });
        registerBinder(new CustomerDividerLineBinder());
    }

    /* access modifiers changed from: protected */
    public void setupNovaLayoutManager(INovaLayoutManager iNovaLayoutManager) {
        super.setupNovaLayoutManager(iNovaLayoutManager);
        CustomerSmoothScroller customerSmoothScroller = new CustomerSmoothScroller(getContext());
        this.mSmoothScroller = customerSmoothScroller;
        iNovaLayoutManager.setSmoothScroller(customerSmoothScroller);
    }

    private void setBottomClickEvent() {
        this.mBottomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((AbsCommonGoodsPresenter) AbsCommonGoodsView.this.getPresenter()).onAddCartViewClicked(AbsCommonGoodsView.this.mIsCartEnabled);
            }
        });
        this.mBottomButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                CustomerSystemUtil.virate(AbsCommonGoodsView.this.getContext());
                return false;
            }
        });
    }
}
