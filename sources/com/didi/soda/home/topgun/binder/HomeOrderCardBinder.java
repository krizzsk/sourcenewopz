package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.customer.widget.countdown.CountDownTextView;
import com.didi.soda.home.topgun.binder.model.HomeOrderCardRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.widget.HomeCardBarAnimView;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.router.DiRouter;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.taxis99.R;

public class HomeOrderCardBinder extends CustomerLogicItemBinder<HomeOrderCardBinderBinderLogic, HomeOrderCardRvModel, ViewHolder> {

    /* renamed from: a */
    ScopeContext f42757a;

    public HomeOrderCardBinder(ScopeContext scopeContext) {
        this.f42757a = scopeContext;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.customer_item_home_order, viewGroup, false));
        viewHolder.mCardBarAnimView.bindScopeContext(this.f42757a);
        return viewHolder;
    }

    public void bind(ViewHolder viewHolder, HomeOrderCardRvModel homeOrderCardRvModel) {
        viewHolder.mOrderCardTitle.setText(viewHolder.mOrderCardTitle.getContext().getResources().getString(R.string.customer_home_order_title));
        if (homeOrderCardRvModel.mTotalNum > 1) {
            viewHolder.mOrderCardAllArrow.setVisibility(0);
            if (GlobalContext.isEmbed()) {
                viewHolder.mOrderViewAllMask.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        HomeOrderCardBinder.this.m30190a(view);
                    }
                });
            } else {
                viewHolder.mOrderViewAllMask.setOnClickListener(new View.OnClickListener(homeOrderCardRvModel) {
                    public final /* synthetic */ HomeOrderCardRvModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        HomeOrderCardBinder.this.m30195b(this.f$1, view);
                    }
                });
            }
            HomeOmegaHelper.getInstance().trackOrderShowAllShow();
        } else {
            viewHolder.mOrderCardAllArrow.setVisibility(8);
            viewHolder.mOrderViewAllMask.setClickable(false);
        }
        m30192a(viewHolder, homeOrderCardRvModel);
        viewHolder.mOrderStatus.setText(homeOrderCardRvModel.mOrderStatus);
        viewHolder.mOrderShopDesc.setText(homeOrderCardRvModel.mShopName);
        viewHolder.mOrderViewMask.setOnClickListener(new View.OnClickListener(homeOrderCardRvModel) {
            public final /* synthetic */ HomeOrderCardRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeOrderCardBinder.this.m30194a(this.f$1, view);
            }
        });
        HomeOmegaHelper.getInstance().orderExposure(homeOrderCardRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30190a(View view) {
        HomeOmegaHelper.getInstance().trackOrderShowAllClick();
        ((HomeOrderCardBinderBinderLogic) getBinderLogic()).onOrderAllClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30195b(HomeOrderCardRvModel homeOrderCardRvModel, View view) {
        HomeOmegaHelper.getInstance().trackOrderShowAllClick();
        ((HomeOrderCardBinderBinderLogic) getBinderLogic()).onOrderClick(homeOrderCardRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30194a(HomeOrderCardRvModel homeOrderCardRvModel, View view) {
        HomeOmegaHelper.getInstance().trackOrderClick(homeOrderCardRvModel);
        ((HomeOrderCardBinderBinderLogic) getBinderLogic()).onOrderClick(homeOrderCardRvModel);
    }

    public Class<HomeOrderCardRvModel> bindDataType() {
        return HomeOrderCardRvModel.class;
    }

    public HomeOrderCardBinderBinderLogic onCreateBinderLogic() {
        return new HomeOrderCardBinderBinderLogic() {
            public Class<EmptyLogicRepo> bindLogicRepoType() {
                return EmptyLogicRepo.class;
            }

            /* access modifiers changed from: package-private */
            public void onOrderClick(HomeOrderCardRvModel homeOrderCardRvModel) {
                DiRouter.request().path("orderPage").putString("orderid", homeOrderCardRvModel.mOrderId).putInt("from", 1).putString("path", "/order_page").open();
            }

            /* access modifiers changed from: package-private */
            public void onOrderAllClick() {
                ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).openOrderHistory();
            }
        };
    }

    /* renamed from: a */
    private void m30192a(ViewHolder viewHolder, HomeOrderCardRvModel homeOrderCardRvModel) {
        String str;
        Context context = viewHolder.mOrderEtaTime.getContext();
        m30189a(context, viewHolder);
        homeOrderCardRvModel.mNeedTrackEta = false;
        if (homeOrderCardRvModel.mDebtInfoRvModel != null && homeOrderCardRvModel.mDebtInfoRvModel.mIsComplete == 0) {
            if (!TextUtils.isEmpty(homeOrderCardRvModel.mDebtInfoRvModel.mUnpaidMoneyDisplay)) {
                viewHolder.mOrderEtaTime.setText(homeOrderCardRvModel.mDebtInfoRvModel.mUnpaidMoneyDisplay);
            }
            viewHolder.mOrderTimeDesc.setText(ResourceHelper.getString(R.string.customer_order_price));
        } else if (homeOrderCardRvModel.mStatus == 0 && !homeOrderCardRvModel.isForClientPay) {
            viewHolder.mOrderEtaTime.setVisibility(8);
            viewHolder.mOrderTimeDesc.setText(homeOrderCardRvModel.mOrderSubStatus);
            viewHolder.mOrderTimeDesc.setPadding(DisplayUtils.dip2px(context, 8.0f), DisplayUtils.dip2px(context, 9.0f), 0, 0);
            viewHolder.mOrderTimeDesc.setTextSize(1, 18.0f);
        } else if (homeOrderCardRvModel.mStatus == 100 && CommonUtil.isNumeric(homeOrderCardRvModel.mTimeDesc)) {
            viewHolder.mOrderEtaTime.setText(context.getResources().getQuantityString(R.plurals.customer_order_eta, Integer.valueOf(homeOrderCardRvModel.mTimeDesc).intValue(), new Object[]{Integer.valueOf(Integer.parseInt(homeOrderCardRvModel.mTimeDesc))}));
            viewHolder.mOrderTimeDesc.setText(homeOrderCardRvModel.mOrderIntlSubDesc);
            homeOrderCardRvModel.mNeedTrackEta = true;
        } else if (homeOrderCardRvModel.mStatus != 500 || homeOrderCardRvModel.mUserTakeCountDown <= 0) {
            if (!StringUtils.isEmpty(homeOrderCardRvModel.mStatusTimeDescRich)) {
                viewHolder.mOrderEtaTime.setText(homeOrderCardRvModel.mStatusTimeDescRich);
            } else {
                String str2 = homeOrderCardRvModel.mTimeDesc;
                if (!TextUtils.isEmpty(str2)) {
                    int indexOf = str2.toLowerCase().indexOf("AM".toLowerCase());
                    int indexOf2 = str2.toLowerCase().indexOf("PM".toLowerCase());
                    if (indexOf > 0 || indexOf2 > 0) {
                        int max = Math.max(indexOf, indexOf2);
                        str = str2.substring(max);
                        str2 = str2.substring(0, max - 1);
                        viewHolder.mOrderEtaTime.setText(str2);
                        viewHolder.mOrderTimeSub.setText(str);
                    }
                }
                str = "";
                viewHolder.mOrderEtaTime.setText(str2);
                viewHolder.mOrderTimeSub.setText(str);
            }
            viewHolder.mOrderTimeDesc.setText(homeOrderCardRvModel.mOrderIntlSubDesc);
            homeOrderCardRvModel.mNeedTrackEta = true;
        } else {
            m30193a(viewHolder, homeOrderCardRvModel.mOrderId, (long) homeOrderCardRvModel.mUserTakeCountDown);
            viewHolder.mOrderEtaTime.setTextColor(SkinUtil.getBrandPrimaryColor());
            viewHolder.mOrderEtaTime.setMinimumWidth(m30188a((TextView) viewHolder.mOrderEtaTime, "00:00"));
            viewHolder.mOrderTimeDesc.setText(homeOrderCardRvModel.mOrderIntlSubDesc);
        }
    }

    /* renamed from: a */
    private void m30189a(Context context, ViewHolder viewHolder) {
        viewHolder.mOrderEtaTime.setMinimumWidth(0);
        viewHolder.mOrderEtaTime.setVisibility(0);
        viewHolder.mOrderEtaTime.setTextColor(viewHolder.mOrderEtaTime.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        viewHolder.mOrderEtaTime.setText((CharSequence) null);
        viewHolder.mOrderTimeSub.setText((CharSequence) null);
        viewHolder.mOrderTimeDesc.setText((CharSequence) null);
        viewHolder.mOrderTimeDesc.setTextSize(1, 12.0f);
        viewHolder.mOrderTimeDesc.setPadding(DisplayUtils.dip2px(context, 4.0f), DisplayUtils.dip2px(context, 0.0f), 0, 0);
        m30191a(viewHolder);
    }

    /* renamed from: a */
    private void m30193a(ViewHolder viewHolder, final String str, long j) {
        if (!viewHolder.mOrderEtaTime.isCounting()) {
            viewHolder.mOrderEtaTime.start(j);
            viewHolder.mOrderEtaTime.addCountFinishCallback(new CountDownTextView.CountTimeoutListener() {
                public void onCountTimeout() {
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(str);
                }
            });
        }
    }

    /* renamed from: a */
    private void m30191a(ViewHolder viewHolder) {
        if (viewHolder.mOrderEtaTime != null && viewHolder.mOrderEtaTime.isCounting()) {
            viewHolder.mOrderEtaTime.cancel();
            viewHolder.mOrderEtaTime.removeCountFinishCallback();
        }
    }

    /* renamed from: a */
    private int m30188a(TextView textView, String str) {
        return Math.round(textView.getPaint().measureText(str));
    }

    static class ViewHolder extends ItemViewHolder<HomeOrderCardRvModel> {
        /* access modifiers changed from: private */
        public HomeCardBarAnimView mCardBarAnimView;
        /* access modifiers changed from: private */
        public View mOrderCardAllArrow;
        /* access modifiers changed from: private */
        public TextView mOrderCardTitle;
        /* access modifiers changed from: private */
        public CountDownTextView mOrderEtaTime;
        /* access modifiers changed from: private */
        public TextView mOrderShopDesc;
        /* access modifiers changed from: private */
        public TextView mOrderStatus;
        /* access modifiers changed from: private */
        public TextView mOrderTimeDesc;
        /* access modifiers changed from: private */
        public TextView mOrderTimeSub;
        /* access modifiers changed from: private */
        public View mOrderViewAllMask;
        /* access modifiers changed from: private */
        public View mOrderViewMask;

        ViewHolder(View view) {
            super(view);
            this.mOrderCardTitle = (TextView) view.findViewById(R.id.customer_tv_order_title);
            this.mOrderCardAllArrow = view.findViewById(R.id.customer_tv_order_view_all_arrow);
            this.mCardBarAnimView = (HomeCardBarAnimView) view.findViewById(R.id.customer_tv_order_anim_bar);
            this.mOrderStatus = (TextView) view.findViewById(R.id.customer_tv_order_status);
            this.mOrderEtaTime = (CountDownTextView) view.findViewById(R.id.customer_tv_order_time);
            this.mOrderTimeSub = (TextView) view.findViewById(R.id.customer_tv_order_time_sub);
            this.mOrderTimeDesc = (TextView) view.findViewById(R.id.customer_tv_order_time_desc);
            this.mOrderShopDesc = (TextView) view.findViewById(R.id.customer_tv_order_shop);
            this.mOrderViewAllMask = view.findViewById(R.id.customer_cl_order_view_all_mark);
            this.mOrderViewMask = view.findViewById(R.id.customer_cl_order_view_container_mark);
        }
    }

    static abstract class HomeOrderCardBinderBinderLogic extends BinderLogic<EmptyLogicRepo> {
        /* access modifiers changed from: package-private */
        public abstract void onOrderAllClick();

        /* access modifiers changed from: package-private */
        public abstract void onOrderClick(HomeOrderCardRvModel homeOrderCardRvModel);

        HomeOrderCardBinderBinderLogic() {
        }
    }
}
