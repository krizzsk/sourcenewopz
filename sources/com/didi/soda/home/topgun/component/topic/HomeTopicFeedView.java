package com.didi.soda.home.topgun.component.topic;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.component.topic.Contract;
import com.didi.soda.home.topgun.component.topic.data.HomeTopicOmegaHelper;
import com.taxis99.R;

public class HomeTopicFeedView extends Contract.AbsHomeTopicFeedView {
    @BindView(18476)
    IconTextView mBackIv;
    @BindView(18679)
    NovaRecyclerView mRecyclerView;
    @BindView(19149)
    TextView mTitleTv;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    public void dismissLoadingDialog() {
        DialogUtil.hideLoadingDialog();
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    public void updateTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitleTv.setText(str);
            this.mTitleTv.setVisibility(0);
            return;
        }
        this.mTitleTv.setVisibility(4);
    }

    public void scrollToTop() {
        this.mRecyclerView.scrollToPosition(0);
    }

    public int calculateAbnormalHeight() {
        return (CustomerSystemUtil.getScreenHeight(getContext()) - CustomerSystemUtil.getStatusBarHeight(getContext())) - DisplayUtils.dip2px(getContext(), 120.0f);
    }

    public String footerViewNoMoreTxt() {
        if (LoginUtil.isLogin()) {
            return ResourceHelper.getString(R.string.customer_common_no_more);
        }
        return ResourceHelper.getString(R.string.customer_footer_load_to_login_see_more);
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.MULTI_COLOR;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
        this.mBackIv.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeTopicFeedView.this.m30348a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30348a(View view) {
        getScopeContext().getNavigator().finish();
        ((Contract.AbsHomeTopicFeedPresenter) getPresenter()).onClickBack();
    }

    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    public void initItemBinders() {
        registerBinder(new HomeBusinessItemBinder(m30347a(), HomeTopicOmegaHelper.getInstance()));
        registerBinder(new TopGunAbnormalViewBinder());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_component_topic_feed, viewGroup, true);
    }

    /* renamed from: a */
    private ItemDecorator m30347a() {
        CustomerSimpleDecorator customerSimpleDecorator = new CustomerSimpleDecorator(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7), DisplayUtils.dip2px(getContext(), 10.0f));
        customerSimpleDecorator.enablePositionTopDecorator();
        return customerSimpleDecorator;
    }
}
