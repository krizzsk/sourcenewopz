package com.didi.soda.customer.base.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout;
import com.didi.app.nova.support.view.pullToRefresh.PullRefreshListener;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaStaggerGridLayoutManager;
import com.didi.nova.assembly.components.recyclerview.BaseRecyclerView;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.component.feed.base.HeaderViewIView;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.mvp.loadmore.LoadMoreBinder;
import com.didi.soda.customer.widget.headerview.CustomerHeaderView;
import com.taxis99.R;

public abstract class CustomerRecyclerView<P extends CustomerRecyclerPresenter> extends BaseRecyclerView<P> implements PullRefreshListener, FooterViewIView, HeaderViewIView {
    private NovaPullRefreshLayout mNovaPullRefreshLayout;
    private INovaRecyclerView mNovaRecyclerView;

    public NovaPullRefreshLayout generatePullToRefreshView() {
        return null;
    }

    public void onMoveRefreshView(int i) {
    }

    public final boolean isFooterViewLoading() {
        return ((CustomerRecyclerPresenter) getPresenter()).getLoadMoreModel().mState == 1;
    }

    public final boolean needBlockFooterLoading() {
        if (((CustomerRecyclerPresenter) getPresenter()).getLoadMoreModel().mState == 1 || ((CustomerRecyclerPresenter) getPresenter()).getLoadMoreModel().mState == 4 || ((CustomerRecyclerPresenter) getPresenter()).getLoadMoreModel().mState == 6 || ((CustomerRecyclerPresenter) getPresenter()).getLoadMoreModel().mState == 5 || ((CustomerRecyclerPresenter) getPresenter()).getLoadMoreModel().mState == 2) {
            return true;
        }
        return false;
    }

    public final void showFooterEmptyView() {
        ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelState(0);
        ((CustomerRecyclerPresenter) getPresenter()).hideFooterBottomStubView();
    }

    public final void showFooterLoadingView() {
        if (this.mNovaRecyclerView.isAutoPreLoad()) {
            ((CustomerRecyclerPresenter) getPresenter()).updateAutoLoadModelState(1);
        } else {
            ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelState(1);
        }
    }

    public final void showFooterNoMoreView() {
        ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelState(2, footerViewNoMoreTxt());
    }

    public final void showFooteSignInView() {
        ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelState(5, footerViewNoMoreTxt());
    }

    public final void updateFooterViewPadding(int i, int i2, int i3, int i4) {
        ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelPadding(i, i2, i3, i4);
    }

    public void dismissPullToRefresh() {
        NovaPullRefreshLayout novaPullRefreshLayout = this.mNovaPullRefreshLayout;
        if (novaPullRefreshLayout != null) {
            novaPullRefreshLayout.dismissPullToRefresh();
        }
    }

    public String footerViewNoMoreTxt() {
        return ResourceHelper.getString(R.string.customer_common_no_more);
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.NONE;
    }

    public IRefreshView generateHeaderView() {
        return new CustomerHeaderView(getContext());
    }

    public HeaderViewIView.Mode headerViewMode() {
        return HeaderViewIView.Mode.DISABLED;
    }

    public void onCreate() {
        ButterKnife.bind((Object) this, getView());
        super.onCreate();
    }

    public void onMoveTargetView(int i) {
        ((CustomerRecyclerPresenter) getPresenter()).onPullTargetMove(i);
    }

    public void onPullToRefresh() {
        ((CustomerRecyclerPresenter) getPresenter()).onPullToRefresh();
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        this.mNovaRecyclerView = iNovaRecyclerView;
        iNovaRecyclerView.setItemMvpEnable(true);
        setupRecyclerViewLoadMore(iNovaRecyclerView);
        setupRecyclerViewPullToRefresh();
        ((RecyclerView) iNovaRecyclerView).setItemAnimator((RecyclerView.ItemAnimator) null);
    }

    public void showFooterErrorView() {
        ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelState(4);
    }

    public void showFooterNoNetView() {
        ((CustomerRecyclerPresenter) getPresenter()).updateLoadMoreModelState(4, getString(R.string.customer_net_error_tip));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        NovaPullRefreshLayout novaPullRefreshLayout = this.mNovaPullRefreshLayout;
        if (novaPullRefreshLayout != null) {
            novaPullRefreshLayout.setPullRefreshListener((PullRefreshListener) null);
        }
        INovaRecyclerView iNovaRecyclerView = this.mNovaRecyclerView;
        if (iNovaRecyclerView != null) {
            iNovaRecyclerView.setLoadMoreListener((INovaRecyclerView.LoadMoreListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        if (useLinearLayout()) {
            return new NovaLinearLayoutManager(getContext());
        }
        CustomerNovaGridLayoutManager customerNovaGridLayoutManager = new CustomerNovaGridLayoutManager(getContext());
        customerNovaGridLayoutManager.bindSource(getClass().getCanonicalName());
        return customerNovaGridLayoutManager;
    }

    private void setupRecyclerViewPullToRefresh() {
        if (headerViewMode() == HeaderViewIView.Mode.ENABLED) {
            NovaPullRefreshLayout generatePullToRefreshView = generatePullToRefreshView();
            this.mNovaPullRefreshLayout = generatePullToRefreshView;
            generatePullToRefreshView.setEnableOverPull(true);
            this.mNovaPullRefreshLayout.setRefreshViewOffsetFixedWhenRefreshing(true);
            this.mNovaPullRefreshLayout.setRefreshView((View) generateHeaderView(), new ViewGroup.LayoutParams(-1, -2));
            this.mNovaPullRefreshLayout.setPullRefreshListener(this);
        }
    }

    private void setupRecyclerViewLoadMore(INovaRecyclerView iNovaRecyclerView) {
        if (footerViewMode() != FooterViewIView.Mode.NONE) {
            iNovaRecyclerView.setFootLoadMoreEnable(true);
            ((CustomerRecyclerPresenter) getPresenter()).generateLoadMoreModel();
            registerBinder(new LoadMoreBinder() {
                public boolean isStaggerLayout() {
                    return CustomerRecyclerView.this.getNovaLayoutManager() instanceof NovaStaggerGridLayoutManager;
                }

                public void onFooterErrorClicked() {
                    ((CustomerRecyclerPresenter) CustomerRecyclerView.this.getPresenter()).updateLoadMoreModelState(6);
                    ((CustomerRecyclerPresenter) CustomerRecyclerView.this.getPresenter()).onFooterErrorClicked();
                }

                public void onFooterNoMoreClicked() {
                    ((CustomerRecyclerPresenter) CustomerRecyclerView.this.getPresenter()).onFooterNoMoreClicked();
                }

                public void onFooterSignInClicked() {
                    ((CustomerRecyclerPresenter) CustomerRecyclerView.this.getPresenter()).onFooterSignInClicked();
                }
            });
            iNovaRecyclerView.setLoadMoreListener(new INovaRecyclerView.LoadMoreListener() {
                public void onLoadMore() {
                    ((CustomerRecyclerPresenter) CustomerRecyclerView.this.getPresenter()).onLoadMore();
                }
            });
        }
    }
}
