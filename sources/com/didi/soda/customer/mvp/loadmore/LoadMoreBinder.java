package com.didi.soda.customer.mvp.loadmore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.soda.customer.widget.footerview.CustomerFooterView;

public abstract class LoadMoreBinder extends ItemBinder<LoadMoreModel, ViewHolder> {
    public abstract boolean isStaggerLayout();

    public abstract void onFooterErrorClicked();

    public abstract void onFooterNoMoreClicked();

    public abstract void onFooterSignInClicked();

    public void bind(ViewHolder viewHolder, final LoadMoreModel loadMoreModel) {
        viewHolder.mCustomerFooterView.updateView(loadMoreModel);
        viewHolder.mCustomerFooterView.setFooterType(loadMoreModel.mLoadMoreViewMode);
        viewHolder.mCustomerFooterView.setFooterClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (loadMoreModel.mState == 4) {
                    LoadMoreBinder.this.onFooterErrorClicked();
                } else if (loadMoreModel.mState == 2) {
                    LoadMoreBinder.this.onFooterNoMoreClicked();
                } else if (loadMoreModel.mState == 5) {
                    LoadMoreBinder.this.onFooterSignInClicked();
                }
            }
        });
        viewHolder.mCartStubView.setVisibility((loadMoreModel.mIsBottomStubShow || loadMoreModel.mIsCartStubShow) ? 0 : 8);
        viewHolder.mCartStubView.setLayoutParams(new LinearLayout.LayoutParams(-1, loadMoreModel.mStubHeight));
    }

    public Class<LoadMoreModel> bindDataType() {
        return LoadMoreModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new ViewHolder(frameLayout);
    }

    public class ViewHolder extends StaggerItemViewHolder<LoadMoreModel> {
        public View mCartStubView = this.mCustomerFooterView.getCartStubView();
        public CustomerFooterView mCustomerFooterView;

        public ViewHolder(View view) {
            super(view);
            CustomerFooterView customerFooterView = new CustomerFooterView(view.getContext());
            this.mCustomerFooterView = customerFooterView;
            ((ViewGroup) view).addView(customerFooterView);
        }

        /* access modifiers changed from: protected */
        public boolean needFullSpan() {
            return LoadMoreBinder.this.isStaggerLayout();
        }

        /* access modifiers changed from: protected */
        public boolean useStaggerLayout() {
            return LoadMoreBinder.this.isStaggerLayout();
        }
    }
}
