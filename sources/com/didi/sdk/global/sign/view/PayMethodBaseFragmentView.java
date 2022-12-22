package com.didi.sdk.global.sign.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.sign.activity.GlobalBasePayMethodListActivity;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.view.ContainerViewManager;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import com.didi.sdk.global.sign.view.helper.RedDotViewHelper;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public abstract class PayMethodBaseFragmentView extends LinearLayout implements ContainerViewManager.ICardViewController, IPayMethodListView<PaySelPageData> {
    protected String discountContent;
    protected ContainerViewManager mCardViewManager;
    protected Context mContext;
    protected PayMethodPageEventListener mPayMethodPageEventListener;
    protected List<PayMethodCardView> mPayMethodViewList = new ArrayList();

    public interface PayMethodPageEventListener {
        void onBalanceSwitchClick(boolean z);

        void onEnterpriseSwitch(View view, boolean z);

        boolean onInterceptPayMethodSelect(View view, PaySelItemData paySelItemData);

        void onPageClickEvent(View view, PaySelPageData paySelPageData);

        void onPageUrlClicked(String str);

        void onPayMethodClickEvent(View view, PaySelItemData paySelItemData);

        void onPayMethodSelectEvent(View view, PaySelItemData paySelItemData);
    }

    public PayMethodBaseFragmentView(Context context) {
        super(context);
        this.mContext = context;
        this.mCardViewManager = new ContainerViewManager(context, this);
    }

    public PayMethodBaseFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mCardViewManager = new ContainerViewManager(context, this);
    }

    public void showProgressDialog(String str) {
        ((GlobalBasePayMethodListActivity) this.mContext).showLoadingDialog();
    }

    public void dismissProgressDialog() {
        ((GlobalBasePayMethodListActivity) this.mContext).hideLoadingDialog();
    }

    public void setPayMethodPageEventListener(PayMethodPageEventListener payMethodPageEventListener) {
        this.mPayMethodPageEventListener = payMethodPageEventListener;
    }

    public void setDiscountContent(String str) {
        this.discountContent = str;
    }

    public void addCardView(LinearLayout linearLayout, PaySelItemData paySelItemData, boolean z) {
        if (linearLayout != null && paySelItemData != null && !((Activity) this.mContext).isFinishing()) {
            if (Build.VERSION.SDK_INT < 17 || !((Activity) this.mContext).isDestroyed()) {
                PayMethodCardView payMethodCardView = new PayMethodCardView(this.mContext);
                payMethodCardView.setPayMethodItemInfo(paySelItemData);
                if (z) {
                    payMethodCardView.setMethodClickListener(new PayMethodSelectListener(paySelItemData));
                    m25708a(payMethodCardView, paySelItemData);
                    linearLayout.addView(payMethodCardView);
                }
                this.mPayMethodViewList.add(payMethodCardView);
            }
        }
    }

    public void addCreditCardAddView(LinearLayout linearLayout, final PaySelItemData paySelItemData) {
        Context context;
        if (linearLayout != null && paySelItemData != null && (context = this.mContext) != null && !((Activity) context).isFinishing() && !((Activity) this.mContext).isDestroyed()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.item_wallet_paymethod_list_add_card, linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_paymethod_label);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_discount_content);
            if (!TextUtils.isEmpty(this.discountContent)) {
                textView2.setVisibility(0);
                textView2.setText(this.discountContent);
            }
            textView.setTextColor(ResourcesHelper.getColor(this.mContext, !paySelItemData.isFrozen ? R.color.wallet_color_FF8040 : R.color.wallet_color_D4D7D9));
            textView.setText(ResourcesHelper.getString(this.mContext, R.string.GRider_Cognition_Add_a_dpKu));
            linearLayout.addView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!paySelItemData.isFrozen && PayMethodBaseFragmentView.this.mPayMethodPageEventListener != null) {
                        PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onPayMethodClickEvent(view, paySelItemData);
                    }
                }
            });
        }
    }

    public void removeCardViews(LinearLayout linearLayout) {
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        List<PayMethodCardView> list = this.mPayMethodViewList;
        if (list != null && list.size() > 0) {
            this.mPayMethodViewList.clear();
        }
    }

    public void addEnterpriseView(LinearLayout linearLayout, List<PaySelItemData> list, EnterprisePayway enterprisePayway) {
        EnterpriseCardView enterpriseCardView = new EnterpriseCardView(this.mContext);
        enterpriseCardView.setData(list, enterprisePayway);
        enterpriseCardView.setMethodClickListener(new PayMethodSelectListener((PaySelItemData) null));
        linearLayout.addView(enterpriseCardView);
    }

    public class PayMethodSelectListener implements View.OnClickListener {
        public PaySelItemData mItemInfo;

        public PayMethodSelectListener(PaySelItemData paySelItemData) {
            this.mItemInfo = paySelItemData;
        }

        public void updateItemInfo(PaySelItemData paySelItemData) {
            this.mItemInfo = paySelItemData;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            PaySelItemData paySelItemData = this.mItemInfo;
            if (paySelItemData != null && paySelItemData.isEnabled && PayMethodBaseFragmentView.this.mPayMethodViewList != null && PayMethodBaseFragmentView.this.mPayMethodViewList.size() != 0) {
                RedDotViewHelper.clickRedDotItem(PayMethodBaseFragmentView.this.mContext, view, this.mItemInfo);
                int i = this.mItemInfo.style;
                if (i == 0) {
                    return;
                }
                if (i == 2) {
                    doClickEvent(view);
                } else if (i != 3) {
                    doSelectEvent(view);
                } else {
                    doSwitchEvent(view);
                }
            }
        }

        private void doSelectEvent(View view) {
            if (PayMethodBaseFragmentView.this.mPayMethodPageEventListener == null || !PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onInterceptPayMethodSelect(view, this.mItemInfo)) {
                PayMethodSelectHelper.doSelectEvent(view, this.mItemInfo, PayMethodBaseFragmentView.this.mPayMethodViewList);
                if (PayMethodBaseFragmentView.this.mPayMethodPageEventListener != null) {
                    PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onPayMethodSelectEvent(view, this.mItemInfo);
                }
            }
        }

        private void doSwitchEvent(View view) {
            PayMethodSelectHelper.SwitchResult doSwitchEvent = PayMethodSelectHelper.doSwitchEvent(view, this.mItemInfo, PayMethodBaseFragmentView.this.mPayMethodViewList);
            PayMethodBaseFragmentView payMethodBaseFragmentView = PayMethodBaseFragmentView.this;
            int a = payMethodBaseFragmentView.m25707a(payMethodBaseFragmentView.mPayMethodViewList);
            if (doSwitchEvent != PayMethodSelectHelper.SwitchResult.SUCCESS) {
                ToastHelper.showLongInfo(PayMethodBaseFragmentView.this.mContext, PayMethodSelectHelper.getSwitchErrorMessage(PayMethodBaseFragmentView.this.mContext, doSwitchEvent), (int) R.drawable.pay_toast_error);
                GlobalOmegaUtils.trackPayMethodSelectPageBalanceSwitched(PayMethodBaseFragmentView.this.mContext, this.mItemInfo.isSelected ? 3 : 2, a);
                return;
            }
            GlobalOmegaUtils.trackPayMethodSelectPageBalanceSwitched(PayMethodBaseFragmentView.this.mContext, this.mItemInfo.isSelected ? 1 : 0, a);
            if (PayMethodBaseFragmentView.this.mPayMethodPageEventListener != null) {
                PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onPayMethodSelectEvent(view, this.mItemInfo);
            }
            PaySelItemData paySelItemData = this.mItemInfo;
            if (paySelItemData == null) {
                return;
            }
            if ((120 == paySelItemData.channelId || (190 == this.mItemInfo.channelId && this.mItemInfo.isHit99payCombination)) && PayMethodBaseFragmentView.this.mPayMethodPageEventListener != null) {
                PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onBalanceSwitchClick(this.mItemInfo.isSelected);
                GlobalOmegaUtils.trackPaylistPageBalancepreSwitchCk(this.mItemInfo.isSelected ? 1 : 0);
            }
        }

        private void doClickEvent(View view) {
            if (PayMethodBaseFragmentView.this.mPayMethodPageEventListener != null) {
                PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onPayMethodClickEvent(view, this.mItemInfo);
            }
        }

        public void enterpriseClick(View view, boolean z) {
            if (PayMethodBaseFragmentView.this.mPayMethodPageEventListener != null) {
                PayMethodBaseFragmentView.this.mPayMethodPageEventListener.onEnterpriseSwitch(view, z);
            }
        }
    }

    /* renamed from: a */
    private void m25708a(PayMethodCardView payMethodCardView, PaySelItemData paySelItemData) {
        if (paySelItemData.channelId == 150) {
            if (!paySelItemData.isEnabled) {
                payMethodCardView.setContentDescription(paySelItemData.subTitle);
            } else if (paySelItemData.style == 2) {
                payMethodCardView.setContentDescription(getResources().getString(R.string.one_payment_global_add_credit_card_desc));
            } else if (!TextUtils.isEmpty(paySelItemData.discount)) {
                Resources resources = getResources();
                payMethodCardView.setContentDescription(resources.getString(R.string.one_payment_global_discount_desc, new Object[]{paySelItemData.discount, getResources().getString(R.string.one_payment_global_credit_card_item_desc) + paySelItemData.title}));
            } else {
                payMethodCardView.setContentDescription(getResources().getString(R.string.one_payment_global_pay_with_card_desc, new Object[]{paySelItemData.title}));
            }
        } else if (paySelItemData.channelId == 154) {
            if (!TextUtils.isEmpty(paySelItemData.discount)) {
                payMethodCardView.setContentDescription(getResources().getString(R.string.one_payment_global_discount_desc, new Object[]{paySelItemData.discount, getResources().getString(R.string.one_payment_global_pos_desc)}));
                return;
            }
            payMethodCardView.setContentDescription(getResources().getString(R.string.one_payment_global_with_desc, new Object[]{getResources().getString(R.string.one_payment_global_pos_desc)}));
        } else if (!paySelItemData.isEnabled) {
            payMethodCardView.setContentDescription(paySelItemData.title);
        } else if (!TextUtils.isEmpty(paySelItemData.discount)) {
            payMethodCardView.setContentDescription(getResources().getString(R.string.one_payment_global_discount_desc, new Object[]{paySelItemData.discount, paySelItemData.title}));
        } else {
            payMethodCardView.setContentDescription(getResources().getString(R.string.one_payment_global_with_desc, new Object[]{paySelItemData.title}));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m25707a(List<PayMethodCardView> list) {
        int i = 0;
        for (PayMethodCardView payMethodItemInfo : list) {
            if (payMethodItemInfo.getPayMethodItemInfo().channelId == 150) {
                i++;
            }
        }
        return i >= 1 ? i - 1 : i;
    }
}
